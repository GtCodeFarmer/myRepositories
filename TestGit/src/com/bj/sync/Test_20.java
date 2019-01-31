package com.bj.sync;

import java.util.LinkedList;
/**
 * 生产者 消费者 
 * wait/notifyAll 经常和while配合使用，目的是避免多线程并发判断逻辑失效问题
 * */
public class Test_20 {
	private  int count=0;
	private final LinkedList<String> list=new LinkedList<>();
	private final int max=10;

	public synchronized void put(String obj) {
		while(list.size() == max) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(obj);
		count++;
		this.notifyAll();
	}
	
	public synchronized Object get() {
		Object ob=null;
		while(list.size() ==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		ob=list.removeFirst();
		count--;
		this.notifyAll();
		return ob;
	}
	
	public static void main(String[] args) {
		final Test_20 t2=new Test_20();
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<5;j++) {
						System.out.println(t2.get());
					}
				}
			},"consumer"+i).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 25; j++) {
						t2.put("container value"+j);
					}
				}
			},"producer"+i).start();
		}
	}
	
}
