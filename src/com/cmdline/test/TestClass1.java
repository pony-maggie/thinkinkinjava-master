package com.cmdline.test;


public class TestClass1 {

	/**
	 * @param args
	 * �����������������������д��javaԴ�ļ�
	 * javac ���ڵ�ǰ·����ִ��
	 * �������У��л���D:\study\nationz\eclipse projects\ThinkingInJavaPractice\srcĿ¼
	 * ��˵˵-d,�����ʾҪ�����class�ļ��Ĵ��·����ǰ�����ڵ�ǰĿ¼��һ��Ҫ��-dָ��������, ��������classDir, �����������Ŀ¼�´������Ŀ¼
	 * -verbose�����������������Ϣ
	 * -sourcepath,��ָ��.java�ļ���·��������Ҫע�⣬��sourcepath��Ҫָ��һ����Ŀ¼����Ȼ����ִ�������ļ��������ҵ�com/cmdline/test/��
	 * ������.java�ļ�����������������:
	 * javac -verbose -sourcepath  com/cmdline/test/*.java
	 * ֻ������һ��TestClass2��class�ļ������������:
	 * javac -verbose -sourcepath  com com/cmdline/test/*.java
	 * �Ϳ�������ȫ����, �������յ�������:
	 * javac -verbose -d classDir/ -sourcepath com com/cmdline/test/*.java
	 * �������� ��ǰ·����classDirĿ¼����������.class�ļ���
	 * 
	 * ����class�ļ����Ϳ�����java��ִ���ˣ���class�ļ���Ŀ¼ִ�У����ֱ���:
	 * Could not find the main class xxxx
	 * �����������дһ���򵥵Ĵ���ŵ�c�̸�Ŀ˵�������package�Ͳ���package�����
	 * 
	 * ��˵˵�������,jar������һ��jar����ԭ���, ��������һЩ���ܣ��Ȱ�.javaԴ�ļ������.class�ļ���Ȼ������jar�������ǵĹ��̵������jar�����Ϳ���������Ĺ��ܡ�
	 * ������˵�Ĺ��ܣ���Ҫ������Ϊ��λ���ڵġ�
	 * 
	 * �л���classDirĿ¼, ִ��jar cvf ponyClass.jar *
	 * ��������jar�ļ�������c��ʾҪ�鵵, v������м���Ϣ��f��ʾָ������ļ�����*�����е�ǰĿ¼�������ļ�
	 * 
	 * ��jar tvf ponyClass.jar
	 * ���Բ鿴һ��jar��������.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("this is TestClass1");

	}

}
