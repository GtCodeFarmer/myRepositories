package com.bj.sync;
/**
 * ThreadLocal 线程本地变量 为每个使用该变量的线程分配一个独立的副本。每个线程都可以独立的改变自己的副本，而不影响其他线程的副本。
 * 就是一个Map。key - 》 Thread.getCurrentThread().  value - 》 线程需要保存的变量。
 * ThreadLocal.set(value) -> map.put(Thread.getCurrentThread(), value);
 * ThreadLocal.get() -> map.get(Thread.getCurrentThread());
 * 内存问题 ： 在并发量高的时候，可能有内存溢出。
 * 使用ThreadLocal的时候，一定注意回收资源问题，每个线程结束之前，将当前线程保存的线程变量一定要删除 。
 * ThreadLocal.remove();
 * */
public class Test_22 {
	private static String name="zhangsan";
    static ThreadLocal<String> sl=new ThreadLocal<String>();
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
				System.out.println(sl.get());
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name="lisi";
				Test_22.sl.set("wangwu");
			}
		}).start();
	}
}
