package com.bj.sync;

public class Test_03 implements Runnable{
	private int count =0;
	
	public static void main(String[] args) {
		Test_03 t=new Test_03();
		for(int i=0;i<5;i++) {
			new Thread(t,"Thread -"+i).start();
		}
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() +" count ="+count++);
	}
}
