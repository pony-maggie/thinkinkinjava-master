package com.mess;

import java.lang.ref.*;

public class WeakReference 
{

	/**
	 * @param args
	 * 关于java的弱引用
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//首先说明，强弱引用是和垃圾回收机制相关的.
		//这种常见的用法是强引用，也就是变量str1被用来存放一个string对象的强引用上。
		//强引用在你正在使用时这个对象时，是不会被垃圾回收器回收的，这在大部分情况下是对的。
		//当出现内存空间不足时，虚拟机不会释放强引用的对象占用的空间，而是选择抛出异常。
		//当然不可能是永远不清理，比如当你把str1 = null时，垃圾回收器还是会处理。
		//只是作为一种GC的语言，我们不必关心一个对象是什么时候被回收的。
		String str1 = new String("abc");
		
		//弱引用就不同了，即使它还和一个变量关联，也有可能被回收掉。
		//那么弱引用用在什么场合呢？比如占用大量内容的对象，而且被回收后又能很快创建。
		//比如一个用户资产管理的软件，关联到用户信息(很多数据)的引用可以置为弱引用，这样当用户长时间不触发应用时，清理掉这块内存用在其它地方。
		//比如jdk里的WeakHashMap,就是
		//下面的代码展示如何定义一个弱引用, 一般和引用队列一起使用，这样当这个引用对象被垃圾回收器打描标记为
		//垃圾的时候，它会自动加入引用队列，方便你自己在合适的时候清理。
		//这个代码其实"hello"对象同时具备强引用和弱引用，
		//后面引用队列的处理就不多说了，有兴趣的可以去网上找一下相关内容。
		String str2 = new String("hello");
		ReferenceQueue<String> rQueue = new ReferenceQueue<String>();
		java.lang.ref.WeakReference<String> wf = new java.lang.ref.WeakReference<String>(str2, rQueue);

	}

}
