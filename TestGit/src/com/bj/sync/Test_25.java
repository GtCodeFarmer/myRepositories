package com.bj.sync;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
//ConcurrentLinkedQueue 是线程安全的先入先出的队列,是按插入时间顺序排序的
public class Test_25 {
	public static void main(String[] args) {
		Queue<String> queue=new ConcurrentLinkedQueue<>();
		for(int i=1;i<=10;i++) {
			queue.offer("value:"+i);
		}
		System.out.println(queue);
		System.out.println(queue.size());
		// 获取但不移除此队列的头
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//获取并移除此队列的头，如果此队列为空，则返回 null。
		System.out.println(queue.poll());
		System.out.println(queue.size());
		// 将指定元素插入此队列的尾部
		System.out.println(queue.offer("value:12"));
		System.out.println(queue.offer("value:1"));
		System.out.println(queue);
	}
}
