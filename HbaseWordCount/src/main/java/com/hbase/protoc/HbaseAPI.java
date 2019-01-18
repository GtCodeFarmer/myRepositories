package com.hbase.protoc;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HbaseAPI {
       HBaseAdmin   hba;
       HTable htb;
       String tableName="phone";
       @Before
       public void init() throws Exception{
    	   Configuration cfg=new Configuration();
    	   cfg.set("hbase.zookeeper.quorum", "hadoop2,hadoop3,hadoop4");
    	   hba=new HBaseAdmin(cfg);
    	   htb=new HTable(cfg, tableName);
       }
       
       @Test
       public void createTable() throws Exception{
    	   if(hba.tableExists(tableName)){
    		   hba.disableTable(tableName);
    		   hba.deleteTable(tableName);
    	   }
    	   HTableDescriptor htd=new HTableDescriptor(TableName.valueOf(tableName));
    	   HColumnDescriptor hcd=new HColumnDescriptor("cf".getBytes());
    	   htd.addFamily(hcd);
    	   hba.createTable(htd);
       }
       @Test
       public void insertTable() throws Exception{
    	   String rowKey="101";
    	   Put put=new Put(rowKey.getBytes());
    	   put.add("cf".getBytes(), "name".getBytes(), "xiaohong".getBytes());
    	   put.add("cf".getBytes(), "age".getBytes(), "12".getBytes());
    	   put.add("cf".getBytes(), "sex".getBytes(), "gril".getBytes());
    	   htb.put(put);
       }
       
       @Test
       public void getTable() throws IOException{
           String rowkey="101";
    	   Get get=new Get(rowkey.getBytes());
    	   get.addColumn("cf".getBytes(), "name".getBytes());    //有选择性的将某些列获取到
    	   
    	    Result  result=  htb.get(get);  //这样是获取到全部列，有时候是没必要的
    	    Cell name= result.getColumnLatestCell("cf".getBytes(), "name".getBytes());
    	    Cell age=result.getColumnLatestCell("cf".getBytes(), "age".getBytes());
//    	    Cell sex=result.getColumnLatestCell("cf".getBytes(), "sex".getBytes());
//    	    
       	System.out.println(new String(CellUtil.cloneValue(name)));
       	System.out.println(new String(CellUtil.cloneValue(age)));
//       	System.out.println(new String(CellUtil.cloneValue(sex)));
       }
       
       @After
       public void distory() throws Exception{
    	   if(hba !=null){
    		   hba.close();
    	   }
       }
}
