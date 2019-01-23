package com.bj.sync;

import java.util.ArrayList;
import java.util.List;

public class Test_10 {
	 int count =0;
	synchronized void m() {
		for (int i = 0; i < 1000; i++) {
			count++;
		}
	}
	
	public static void main(String[] args) {
		final Test_10 t=new Test_10();
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
		
		for (Thread thread : ls) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(t.count);
	}
}
