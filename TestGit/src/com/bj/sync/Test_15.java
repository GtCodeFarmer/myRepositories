package com.bj.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test_15 {
	public static void main(String[] args) {
		final Test_15_Container t=new Test_15_Container();
		final CountDownLatch latch=new CountDownLatch(1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(t.getSize() !=5) {
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("size = 5");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++) {
					System.out.println("add Object to Container " + i);
					t.add(new Object());
					if(t.getSize() == 5) {
						latch.countDown();
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}).start();
	}
}

class Test_15_Container{
	List<Object> container=new ArrayList<Object>();
	
	public void add(Object o) {
		container.add(o);
	}
	
	public int getSize() {
		return this.container.size();
	}
}
