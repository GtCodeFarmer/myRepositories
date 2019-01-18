package com.bj.HbaseWC;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class WCReduce extends TableReducer<Text, IntWritable, ImmutableBytesWritable>{
    protected void reduce(Text arg0, Iterable<IntWritable> arg1, 
    		Context arg2) throws java.io.IOException ,InterruptedException {
    	int sum=0;
    	for(IntWritable sus:arg1){
    		sum+=sus.get();
    	}
    	Put put1=new Put(arg0.getBytes());
    	put1.add("cf1".getBytes(), "wc".getBytes(), (sum+"").getBytes());
    	
    	arg2.write(null,put1);
    };
}
