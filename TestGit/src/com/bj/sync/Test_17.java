package com.bj.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_17 {
	Lock lock=new ReentrantLock();
	void m1() {
		lock.lock();
		try {
		for(int i=0;i<10;i++) {
			System.out.println("m1 method ...."+i);
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
		boolean islock=false;
		try {
			islock=lock.tryLock(5,TimeUnit.SECONDS);
			if(islock) {
				System.out.println("m2 method  sync");
			}else {
				System.out.println("m2 method not sync");
			}			
		}
			catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(islock)
			      lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Test_17 t=new Test_17();
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
