package com.bj.HbaseWC;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;


public class WCJob {
   public static void main(String[] args) {
	Configuration  conf=new Configuration();
	conf.set("fs.defaultFS", "hdfs://node1:8020");
	conf.set("hbase.zookeeper.quorum", "node1");
	
	try {
		Job job=Job.getInstance();
		job.setJarByClass(WCJob.class);
		
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		String tableName="wc";
		TableMapReduceUtil.initTableReducerJob(tableName, WCReduce.class, job);
		
		Path inputPath=new Path("/user/wc/input");
		FileInputFormat.addInputPath(job, inputPath);
		
		boolean flag=job.waitForCompletion(true);
		if(flag){
			System.out.println("succ .....");
		}
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
