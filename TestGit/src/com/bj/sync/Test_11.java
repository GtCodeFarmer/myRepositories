package com.bj.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test_11 {
	AtomicInteger count=new AtomicInteger(0);
	void m() {
		for(int i=0;i<1000;i++) {
//			count.getAndIncrement();
			count.incrementAndGet();
			System.out.println(Thread.currentThread().getName()+" count="+count);
		}
	}
	
	public static void main(String[] args) {
		Test_11 t=new Test_11();
		List<Thread> ls=new ArrayList<>();
		for(int i=0;i<10;i++) {
			ls.add(new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					t.m();
				}
			}));
		}
		
		
		for (Thread thread : ls) {
			thread.start();
		}
		
		for(Thread ts:ls) {
			try {
				ts.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(t.count.intValue());
	}
}
