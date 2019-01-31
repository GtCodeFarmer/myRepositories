package com.bj.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_18 {
	Lock lock=new ReentrantLock();
	void m1() {
		lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
				System.out.println("m1 method ....."+i);
				Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
		}
	}
	
	void m2() {
		try {
			lock.lockInterruptibly();
			System.out.println("m2 method......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("m2 method interrupted");
		}finally {
			if(lock.tryLock())
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Test_18 t=new Test_18();
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
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m2();
			}
		});
		
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.interrupt();
	}
}
