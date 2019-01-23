package com.bj.sync;

import java.util.concurrent.TimeUnit;
/***?
 * /
 * @author lenovo
 * 线程锁的是不同的对象，但打印的是同一个对象。是Test_12这个对象创建的同一个Object对象地址
 */
public class Test_12 {
	Object o=new Object();
	
	void m() {
		System.out.println(Thread.currentThread().getName()+" start");
		synchronized (o) {
			while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() +" - "+o);
		}
	  }
	}
	
	public static void main(String[] args) {
		final Test_12 t=new Test_12();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
		},"Thread1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
		},"Thread2").start();
	}
	
}
