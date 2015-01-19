package com.cmdline.test;


public class TestClass1 {

	/**
	 * @param args
	 * 这个包用来测试如何用命令行打包java源文件
	 * javac 是在当前路径下执行
	 * 打开命令行，切换到D:\study\nationz\eclipse projects\ThinkingInJavaPractice\src目录
	 * 先说说-d,这个表示要输出的class文件的存放路径，前提是在当前目录下一定要用-d指定的名字, 这里我用classDir, 所以先在这个目录下创建这个目录
	 * -verbose可以输出编译器的信息
	 * -sourcepath,是指定.java文件的路径，这里要注意，在sourcepath后要指定一个总目录，不然不会执行所的文件，比如我的com/cmdline/test/下
	 * 有两个.java文件，如果用下面的命令:
	 * javac -verbose -sourcepath  com/cmdline/test/*.java
	 * 只会生成一个TestClass2的class文件，如果用这种:
	 * javac -verbose -sourcepath  com com/cmdline/test/*.java
	 * 就可以生成全部的, 所以最终的命令是:
	 * javac -verbose -d classDir/ -sourcepath com com/cmdline/test/*.java
	 * 这样就在 当前路径的classDir目录下生成两个.class文件。
	 * 
	 * 有了class文件，就可以用java来执行了，到class文件的目录执行，发现报错:
	 * Could not find the main class xxxx
	 * 这种情况可以写一个简单的代码放到c盘根目说清楚，带package和不带package的情况
	 * 
	 * 再说说打包的事,jar包，查一下jar包的原理等, 别人做好一些功能，先把.java源文件编译成.class文件，然后打包成jar包，我们的工程导入这个jar包，就可以用里面的功能。
	 * 这里所说的功能，主要是以类为单位存在的。
	 * 
	 * 切换到classDir目录, 执行jar cvf ponyClass.jar *
	 * 可以生成jar文件，其中c表示要归档, v是输出中间信息，f表示指定输出文件名，*是所有当前目录的输入文件
	 * 
	 * 用jar tvf ponyClass.jar
	 * 可以查看一个jar包的内容.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("this is TestClass1");

	}

}
