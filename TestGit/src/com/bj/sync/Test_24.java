package com.bj.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Test_24 {
	public static void main(String[] args) {
//		final List<String> list=new ArrayList<>();
//		final List<String> list=new Vector<String>();
		final List<String> list=new CopyOnWriteArrayList<String>();
		Thread[] array=new Thread[100];
		final Random r=new Random();
		final CountDownLatch latch=new CountDownLatch(array.length);
		
		Long begin=System.currentTimeMillis();
		for(int i=0;i<array.length;i++) {
			array[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<1000;j++) {
						list.add("value"+r.nextInt(1000000));
					}
					latch.countDown();
				}
			});
		}
		
		for (Thread thread : array) {
			thread.start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long end=System.currentTimeMillis();
		System.out.println("运行时间为："+(end - begin)+"毫秒");
		System.out.println("List.size()"+list.size());
	}
}
