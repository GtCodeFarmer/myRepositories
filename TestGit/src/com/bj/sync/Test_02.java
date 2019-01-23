package com.bj.sync;
//静态同步方法，锁的是当前类型的类对象，在本代码中是Test_02
public class Test_02 {
	private static int count=2;
	
	public static synchronized void test04() {
		System.out.println(Thread.currentThread().getName()+" count="+ count++);
	}
	
	public void test05() {
		synchronized (Test_02.class) {
			System.out.println(Thread.currentThread().getName()+" count="+count++);
		}
	}
}
