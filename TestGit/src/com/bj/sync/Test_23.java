package com.bj.sync;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class Test_23 {
	public static void main(String[] args) {
//		final Map<String,String> map=new Hashtable<>();
//		final Map<String,String> map=new ConcurrentHashMap<String, String>();
		final Map<String,String> map=new ConcurrentSkipListMap<>();
		final Random r=new Random();
		Thread[] array=new Thread[100];
		final CountDownLatch countDown=new CountDownLatch(array.length);
		
		
		long begin=System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			array[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						map.put("key"+r.nextInt(100000), "value"+r.nextInt(100000));
					}
					countDown.countDown();
				}
			});
		}
		
		for (Thread thread : array) {
			thread.start();
		}
		
		try {
			countDown.await();//�����̵߳ȴ������߳���ɺ��Լ��ڹ���
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		System.out.println("ִ��ʱ��Ϊ��"+(end - begin) + "����");
	}
}
