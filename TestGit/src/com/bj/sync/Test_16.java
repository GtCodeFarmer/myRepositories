package com.bj.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_16 {
	Lock lock = new ReentrantLock();

	void m1() {
		lock.lock();
		try {
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("m1() method..... " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	void m2() {
		lock.lock();
		System.out.println("m2()  method .....");
		lock.unlock();
	}
	
	
	public static void main(String[] args) {
		Test_16 t=new Test_16();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m1();
			}
		}).start();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m2();
			}
		}).start();
	}
}
