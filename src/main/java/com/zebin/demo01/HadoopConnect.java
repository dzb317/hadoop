package com.zebin.demo01;
import java.io.FileInputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/*
 * 客户端代码
 * 1.获取客户端对象
 * 2.执行相关对象
 *
 * */
public abstract class HadoopConnect {

    public static void main(String[] args) throws Exception{
        Configuration conf =new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.30.101:9000"),conf,"root");
        FileInputStream input = new FileInputStream("D:\\BigDataCode\\Idea_code\\hadoop\\src\\main\\resources\\aaa.txt");
        FSDataOutputStream output = fs.create(new Path("/bbb.cp.txt"));
        IOUtils.copyBytes(input, output, conf);
        IOUtils.closeStream(input);
        IOUtils.closeStream(output);

    }

}

