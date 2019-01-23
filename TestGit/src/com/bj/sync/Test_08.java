package com.bj.sync;

public class Test_08 {
	private int count=0;
	
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+" - start");
		while(true) {
			count++;
			System.out.println(Thread.currentThread().getName()+" - count="+count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count == 5) {
				count=count / 0;
			}
		}
	}
	
	public static void main(String[] args) {
		final Test_08 t=new Test_08();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
		},"t1").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
		},"t2").start();
	}
}
