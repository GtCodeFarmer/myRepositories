package com.bj.sync;
//��̬ͬ�������������ǵ�ǰ���͵�������ڱ���������Test_02
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
