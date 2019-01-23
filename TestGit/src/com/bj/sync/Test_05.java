package com.bj.sync;

import java.util.concurrent.TimeUnit;

public class Test_05 {
  private double d=0.0;
  public  void m1(double dt) {
	  try {
		TimeUnit.SECONDS.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  this.d=dt;
  }
  
  public double m2() {
	  return this.d;
  }
  
  public static void main(String[] args) {
	final Test_05 t5=new Test_05();
    new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		   t5.m1(100);	
		}
	}).start();
    System.out.println(t5.m2());
    try {
		TimeUnit.SECONDS.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(t5.m2());
}
}
