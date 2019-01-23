package com.bj.sync;

public class Test_04 {
	Object o=new Object();
	public synchronized void m1() {
		System.out.println("m1 start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1 stop");
	}
	
	public void m2() {
		System.out.println("m2 start");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2 stop");
	}
	
	public void m3() {
		synchronized (o) {
			System.out.println("m3 start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m3 stop");
		}
	}
	
	public void m4() {
		synchronized (this) {
			System.out.println("m4 start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m4 stop");
		}
	}
	
	public static class MyThread implements Runnable{
		int i=0;
		Test_04 t=null;
		public MyThread(int i,Test_04 t) {
			this.i=i;
			this.t=t;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(i ==1) {
				t.m1();
			}else if(i ==2) {
				t.m2();
			}else if(i ==3){
				t.m3();
			}else if(i ==4) {
				t.m4();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Test_04 te=new Test_04();
		new Thread(new Test_04.MyThread(1, te)).start();
		new Thread(new Test_04.MyThread(2, te)).start();
		new Thread(new Test_04.MyThread(3, te)).start();
//		new Thread(new Test_04.MyThread(4, te)).start();
	}
}
