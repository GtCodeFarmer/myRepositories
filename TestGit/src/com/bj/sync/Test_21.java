package com.bj.sync;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_21 {
	private final int Max=10;
	private final LinkedList<String> list=new LinkedList<String>();
	
	private Lock lock=new ReentrantLock();
	private Condition producer=lock.newCondition();
	private Condition consumer=lock.newCondition();
	
	public void put(String str) {
		lock.lock();
		try {
			while(list.size() == Max) {
				System.out.println(Thread.currentThread().getName()+"等待 。。。。。");
				//进入等待队列
				producer.await();
			}
			list.add(str);
			//借助条件唤醒所有消费者
			consumer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public String get() {
		String result=null;
		lock.lock();
		try {
			while(list.size() == 0) {
				System.out.println(Thread.currentThread().getName()+"等待 。。。。。");
				//进入等待队列
				consumer.await();
			}
			result=list.removeFirst();
			//借助条件唤醒所有消费者
			producer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Test_21 t=new Test_21();
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<5;j++) {
						System.out.println(t.get());
					}
				}
			},"consumer"+i).start();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 25; j++){
						t.put("container value " + j); 
					}
				}
			}, "producer"+i).start();
		}
	}
}
