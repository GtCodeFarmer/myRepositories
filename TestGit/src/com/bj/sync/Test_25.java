package com.bj.sync;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
//ConcurrentLinkedQueue ���̰߳�ȫ�������ȳ��Ķ���,�ǰ�����ʱ��˳�������
public class Test_25 {
	public static void main(String[] args) {
		Queue<String> queue=new ConcurrentLinkedQueue<>();
		for(int i=1;i<=10;i++) {
			queue.offer("value:"+i);
		}
		System.out.println(queue);
		System.out.println(queue.size());
		// ��ȡ�����Ƴ��˶��е�ͷ
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//��ȡ���Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��
		System.out.println(queue.poll());
		System.out.println(queue.size());
		// ��ָ��Ԫ�ز���˶��е�β��
		System.out.println(queue.offer("value:12"));
		System.out.println(queue.offer("value:1"));
		System.out.println(queue);
	}
}
