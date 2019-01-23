package com.bj.sync;

import java.util.concurrent.TimeUnit;

public class Test_06 {
	public void m1() {
		System.out.println("m1 start");
		synchronized (this) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  m2();
		  System.out.println("m1 end");
		}
	}

	synchronized void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2 start");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2 end");
	}
	
	public static void main(String[] args) {
		Test_06 t6=new Test_06();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t6.m1();
			}
		}).start();
	}
}
