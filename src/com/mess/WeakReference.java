package com.mess;

import java.lang.ref.*;

public class WeakReference 
{

	/**
	 * @param args
	 * ����java��������
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//����˵����ǿ�������Ǻ��������ջ�����ص�.
		//���ֳ������÷���ǿ���ã�Ҳ���Ǳ���str1���������һ��string�����ǿ�����ϡ�
		//ǿ������������ʹ��ʱ�������ʱ���ǲ��ᱻ�������������յģ����ڴ󲿷�������ǶԵġ�
		//�������ڴ�ռ䲻��ʱ������������ͷ�ǿ���õĶ���ռ�õĿռ䣬����ѡ���׳��쳣��
		//��Ȼ����������Զ�����������統���str1 = nullʱ���������������ǻᴦ����
		//ֻ����Ϊһ��GC�����ԣ����ǲ��ع���һ��������ʲôʱ�򱻻��յġ�
		String str1 = new String("abc");
		
		//�����þͲ�ͬ�ˣ���ʹ������һ������������Ҳ�п��ܱ����յ���
		//��ô����������ʲô�����أ�����ռ�ô������ݵĶ��󣬶��ұ����պ����ܺܿ촴����
		//����һ���û��ʲ��������������������û���Ϣ(�ܶ�����)�����ÿ�����Ϊ�����ã��������û���ʱ�䲻����Ӧ��ʱ������������ڴ����������ط���
		//����jdk���WeakHashMap,����
		//����Ĵ���չʾ��ζ���һ��������, һ������ö���һ��ʹ�ã�������������ö�������������������Ϊ
		//������ʱ�������Զ��������ö��У��������Լ��ں��ʵ�ʱ��������
		//���������ʵ"hello"����ͬʱ�߱�ǿ���ú������ã�
		//�������ö��еĴ����Ͳ���˵�ˣ�����Ȥ�Ŀ���ȥ������һ��������ݡ�
		String str2 = new String("hello");
		ReferenceQueue<String> rQueue = new ReferenceQueue<String>();
		java.lang.ref.WeakReference<String> wf = new java.lang.ref.WeakReference<String>(str2, rQueue);

	}

}