package com.bj.sync;

public class Test_13 {
	String str1="hello";
	String str2="hello";
//	String str2=new String("hello");
//	Integer i1=new Integer(1);  //这是在堆中创建一个新对象
//	Integer i2=new Integer(1);
	Integer i1=1;  //这是在常量池中
	Integer i2=1;
	void m1() {
		synchronized (str1) {
			System.out.println("m1() start");
			while(true) {
				
			}
		}
	}
	
	void m2() {
		synchronized (str2) {
			System.out.println("m2() start");
		  while(true) {}	
		}
	}
	
	public static void main(String[] args) {
		final Test_13 t=new Test_13();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m1();
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m2();
			}
		}).start();
	}
}
