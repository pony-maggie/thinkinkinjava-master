package com.mess;

public class ValueofTest 
{

	/**
	 * @param args
	 * ��������
	 * false
	 * false
	 * true
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//����valueof�������ַ�������ʾ�����Ͷ�������ã�����ʵ�������������õıȽ�
		//����һЩ��վ�ϵķ�������һ��Ӧ�÷���true,��Ϊ��������-128~127֮��ʱ����ӻ���ȡ��Ӧ����ͬһ������
		//��֪��Ϊʲô�ҵ����н����false, ��jdk�汾�й�,jdk5.0���ϲſ��ԣ����Բ鿴valueOf��ʵ��Դ�룬�ͺ��������ײ���
		System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));
		System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
		
		//parseint���ص���int�ͻ�������ֵ���൱�ڱȽ�128 == 128����������ͬ�ġ�
		System.out.println(Integer.parseInt("128") == Integer.parseInt("128"));
		

	}

}
