package com.mess;

public class Immutable {

	/**
	 * @param args
	 * ���Զ���Ĳ��ɱ���
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//String�����ǲ������, ����һ��String����һ�����ɣ�����һֱ���ڣ����䣬ֱ����������
		//��������δ��룬�������ƺ��ı���str1���������ʵ��Ȼ�����ȵ�һ�У�����ʵ��new һ��String����
		//������"aaa",Ȼ�����str1ָ����������ֵΪ"bbb"ʱ����ʵ��new��һ������������"bbb", Ȼ����str1��ָ������µĵ�ַ
		//ԭ���ĵ�ַ��,������"aaa"�Ķ����Ǵ��ڵģ�ֻ��û�б���ָ�����ˡ� ���ֶ�����Ǳ��������յ��³���
		String str1 = "aaa";
		System.out.println(str1);
		str1 = "bbb";
		System.out.println(str1);
		
		//�ٿ�������
		//subString��ʵҲ����������һ��String����,Ȼ��str2�������ָ������
		String str2 = str1.substring(2);
		System.out.println(str2);
		//�����ʵ���Կ���String��Դ�룬���ĳ�Ա��������final�ģ�����ע������value��Ա����Ҳ��˵����
		//���ĳ�Ա����һ��ͨ�����캯�����ɣ��Ͳ����ٸ��ˡ�
	}

}
