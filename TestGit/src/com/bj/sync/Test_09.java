package com.bj.sync;

public class Test_09 {
  volatile boolean f=true;
   void m() {
	   System.out.println("m start");
	   while(f) {};
	   System.out.println("m stop");
   }
   
   public static void main(String[] args) {
	Test_09 t=new Test_09();
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			t.m();
		}
	}).start();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("sleep end");
	t.f=false;
}
}
