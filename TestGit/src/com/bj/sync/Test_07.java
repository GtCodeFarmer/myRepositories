
package com.bj.sync;
public class Test_07 {
	synchronized void m1() {
		System.out.println("super start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("super end");
	}
public static void main(String[] args) {
	new Sub_Test().m1();
}
	
}

class Sub_Test extends Test_07{
	synchronized void m1() {
		System.out.println("son start");
		try {
			Thread.sleep(2000);
			super.m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("son end");
	}
}