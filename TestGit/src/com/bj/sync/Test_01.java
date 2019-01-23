package com.bj.sync;

import java.util.concurrent.TimeUnit;

public class Test_01 {
	private int count=2;
	private Object obj=new Object();
	
	public void testsync1() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+" count="+count++);
		}
	}
	
	public void testsync2() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+ " count="+count++);
		}
	}
	
	public synchronized void testsync3() {
		System.out.println(Thread.currentThread().getName()+ " count="+count++);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final Test_01 t=new Test_01();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.testsync3();
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.testsync3();
			}
		}).start();
	}
	
}
