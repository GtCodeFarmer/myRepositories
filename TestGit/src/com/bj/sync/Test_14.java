package com.bj.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test_14 {
	CountDownLatch latch=new CountDownLatch(5);
	void m1() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1() method");
	}
	
	void m2() {
		for(int i=0;i<10;i++) {
			if(latch.getCount() !=0) {
				System.out.println("latch count:"+latch.getCount());
				latch.countDown();
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m2() method:"+i);
		}
	}
	
	
	public static void main(String[] args) {
		final Test_14 t=new Test_14();
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
