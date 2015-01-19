package com.bruceeckel.util;

import java.io.*;

public class StripQualifiers 
{
	/*
	 * 类java.io.StreamTokenizer可以获取输入流并将其分析为Token(标记)。StreamTokenizer的nextToken方法将读取下一个标记
	 * 默认情况下，StreamTokenizer认为下列内容是Token：字母、数字、除C和C++注释符号以外的其他符号。如符号“/”不是Token，注释后的内容也不是，而“\”是Token。
	 * 单引号和双引号以及其中的内容，只能算是一个Token。要统计文件的字符数，不能简单地统计Token数，因为字符数不等于Token，按照Token的规定，
	 * 引号中的内容就算是10页也算是一个Token。如果希望引号和引号中的内容都算作Token，应该通过StreamTokenizer的ordinaryCha方法将单引号和双引号当做普通字符处理。
	 */
	private StreamTokenizer st;
	public StripQualifiers(String qualified)
	{
		st = new StreamTokenizer(new StringReader(qualified));
		//ordinaryChar指定字符在这个tokenizer中保持原义，即只会把当前字符认为普通的字符，不会有其他的语义。
		//因为StreamTokenizer默认是用空格作为token的分隔，所以如果没有指定把空格作为普通字符，比如对于"public int java.lang.String.hashCode()", public 是一个word token, 
		//接下来int又是一个work token, 空格就没了。输出的结果就像这样"publicinthashCode()"
		//设置成普通之后，空格也作为一个token, 进到下面的default里输出
		
		st.ordinaryChar(' '); //keep the spaces
	}
	
	public String getNext()
	{
		String s = null;
		try 
		{
			int token = st.nextToken();
			if(token != StreamTokenizer.TT_EOF)//A constant indicating that the end of the stream has been read
			{
				switch (st.ttype) //其实这里也可以用switch(token), 可能好理解一些,看nextToken的实现就可以知道这两个效果是相同的
				{
				case StreamTokenizer.TT_EOL://A constant indicating that the end of the line has been read.
					s = null;
					break;
				case StreamTokenizer.TT_NUMBER://A constant indicating that the end of the line has been read.
					s = Double.toString(st.nval);//如果token里没有数字，这一行可以不要
					break;
				case StreamTokenizer.TT_WORD://A constant indicating that a word token has been read.一个单词
					s = new String(st.sval);
					break;
				default:
					//A constant indicating that a word token has been read,比如传整数49, 输出就是"49"
					//再比如传'7', 输出就是"7", 传' ', 输出就是" "
					//如果注释掉这一句，空格等符号就打印不出来了。
					s = String.valueOf((char)st.ttype);
					break;
				}
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("error fetching token");
		}
		
		return s;
	}
	
	public static String strip(String qualified)
	{
		StripQualifiers sq = new StripQualifiers(qualified);
		String ss = "", si;
		while((si = sq.getNext()) != null)
		{
			//找到最后一次出现特定字符的位置，比如"public int java.lang.String.hashCode()"
			//返回的就是hashCode前面那个'.'的位置
			int lastDot = si.lastIndexOf('.');
			if(lastDot != -1)
			{
				si = si.substring(lastDot + 1);
			}
			ss += si;
		}
		return ss;
	}
	
}
