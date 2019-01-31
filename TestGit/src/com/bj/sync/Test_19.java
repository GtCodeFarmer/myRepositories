package com.bj.sync;

import java.util.concurrent.locks.ReentrantLock;

public class Test_19 {
	public static void main(String[] args) {
		TestReentrantlock tls=new TestReentrantlock();
		Thread t1=new Thread(tls);
		Thread t2=new Thread(tls);
		t1.start();
		t2.start();
	}
}

class TestReentrantlock extends Thread {
	private static ReentrantLock rl = new ReentrantLock(true);

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			rl.lock();
			try {
				System.out.println(Thread.currentThread().getName() + " get lock");
			} finally {
				rl.unlock();
			}
		}
	}
}

class Testsync extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " get lock in TestSync");
			}
		}
	}
}