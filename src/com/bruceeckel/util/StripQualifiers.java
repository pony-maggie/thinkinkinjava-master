package com.bruceeckel.util;

import java.io.*;

public class StripQualifiers 
{
	/*
	 * ��java.io.StreamTokenizer���Ի�ȡ���������������ΪToken(���)��StreamTokenizer��nextToken��������ȡ��һ�����
	 * Ĭ������£�StreamTokenizer��Ϊ����������Token����ĸ�����֡���C��C++ע�ͷ���������������š�����š�/������Token��ע�ͺ������Ҳ���ǣ�����\����Token��
	 * �����ź�˫�����Լ����е����ݣ�ֻ������һ��Token��Ҫͳ���ļ����ַ��������ܼ򵥵�ͳ��Token������Ϊ�ַ���������Token������Token�Ĺ涨��
	 * �����е����ݾ�����10ҳҲ����һ��Token�����ϣ�����ź������е����ݶ�����Token��Ӧ��ͨ��StreamTokenizer��ordinaryCha�����������ź�˫���ŵ�����ͨ�ַ�����
	 */
	private StreamTokenizer st;
	public StripQualifiers(String qualified)
	{
		st = new StreamTokenizer(new StringReader(qualified));
		//ordinaryCharָ���ַ������tokenizer�б���ԭ�壬��ֻ��ѵ�ǰ�ַ���Ϊ��ͨ���ַ������������������塣
		//��ΪStreamTokenizerĬ�����ÿո���Ϊtoken�ķָ����������û��ָ���ѿո���Ϊ��ͨ�ַ����������"public int java.lang.String.hashCode()", public ��һ��word token, 
		//������int����һ��work token, �ո��û�ˡ�����Ľ����������"publicinthashCode()"
		//���ó���֮ͨ�󣬿ո�Ҳ��Ϊһ��token, ���������default�����
		
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
				switch (st.ttype) //��ʵ����Ҳ������switch(token), ���ܺ����һЩ,��nextToken��ʵ�־Ϳ���֪��������Ч������ͬ��
				{
				case StreamTokenizer.TT_EOL://A constant indicating that the end of the line has been read.
					s = null;
					break;
				case StreamTokenizer.TT_NUMBER://A constant indicating that the end of the line has been read.
					s = Double.toString(st.nval);//���token��û�����֣���һ�п��Բ�Ҫ
					break;
				case StreamTokenizer.TT_WORD://A constant indicating that a word token has been read.һ������
					s = new String(st.sval);
					break;
				default:
					//A constant indicating that a word token has been read,���紫����49, �������"49"
					//�ٱ��紫'7', �������"7", ��' ', �������" "
					//���ע�͵���һ�䣬�ո�ȷ��žʹ�ӡ�������ˡ�
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
			//�ҵ����һ�γ����ض��ַ���λ�ã�����"public int java.lang.String.hashCode()"
			//���صľ���hashCodeǰ���Ǹ�'.'��λ��
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
