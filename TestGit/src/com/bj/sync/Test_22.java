package com.bj.sync;
/**
 * ThreadLocal �̱߳��ر��� Ϊÿ��ʹ�øñ������̷߳���һ�������ĸ�����ÿ���̶߳����Զ����ĸı��Լ��ĸ���������Ӱ�������̵߳ĸ�����
 * ����һ��Map��key - �� Thread.getCurrentThread().  value - �� �߳���Ҫ����ı�����
 * ThreadLocal.set(value) -> map.put(Thread.getCurrentThread(), value);
 * ThreadLocal.get() -> map.get(Thread.getCurrentThread());
 * �ڴ����� �� �ڲ������ߵ�ʱ�򣬿������ڴ������
 * ʹ��ThreadLocal��ʱ��һ��ע�������Դ���⣬ÿ���߳̽���֮ǰ������ǰ�̱߳�����̱߳���һ��Ҫɾ�� ��
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
