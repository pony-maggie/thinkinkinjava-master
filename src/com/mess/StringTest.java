package com.mess;

public class StringTest {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//�Ƚ������ַ���һ��Ҫ��equals������ֱ����==,��Ϊ���߱Ƚϵ������ã�����ʵ��ֵ
		String s1 = "abd";
		String s2 = "abd";
		
		String s3 = new String("123");
		String s4 = new String("123");
		
		//���s1��s2����ͬһ����������ֵ����ô��������==�Ƚϣ�������equals�����Ƚϣ����᷵��true
		//���String����ָ��ͬһ��������ʱ���ڶ��ڴ浱��ֻ��һ��Java����
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		//�������String�Ĺ��캯����String���͵����ø�ֵ����ôÿ����һ�ι��캯�����ڶ��ڴ浱�оͻ�����һ��String����
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		//���⣬��԰�ȫ�ԱȽϸߵ����ݣ�������char[]��������string, ��Ϊ�����ǲ��ɸ��ĵģ�ֱ�������գ��������ױ����֡�
		
		
		//String��StringBuilder�������Ǻ��߿��Ըı䣬
		//�����ÿ�ζ� String ���ͽ��иı��ʱ����ʵ����ͬ��������һ���µ� String ����Ȼ��ָ��ָ���µ� String �������Ծ����ı����ݵ��ַ�����ò�Ҫ�� String
		String S1 = "This is only a simple test";
		

		
		StringBuilder Sb = new StringBuilder("This is only a simple ").append("test");
		S1 += "aaa";
		
		System.out.println(S1);
		System.out.println(Sb);
		

	}

}
