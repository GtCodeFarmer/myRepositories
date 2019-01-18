package com.bj.HbaseWC;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.jboss.netty.util.internal.StringUtil;


public class WCMapper extends Mapper<LongWritable, Text, Text,IntWritable>{
	//key  Æ«ÒÆÁ¿
   protected void map(LongWritable key, Text value, Context context) 
		   throws java.io.IOException ,InterruptedException 
   {
	   String str[]=StringUtil.split(value.toString(),' ');
	   for (String result : str) {
		context.write(new Text(result), new IntWritable(1));
	}
   };
}
