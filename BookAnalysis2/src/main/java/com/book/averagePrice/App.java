package com.book.averagePrice;

import com.book.util.DBUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.File;

/*
* 不同类型图书的平均价格
*
* */
public class App {
    //配置连接数据库的相关参数
    public static String driverClass = DBUtil.driverClass;
    public static String dbUrl = DBUtil.dbUrl;
    public static String userName = DBUtil.userName;
    public static String passwd = DBUtil.passwd;
    public static String tableName = "book_avg_price";
    //    public static String [] fields = {"name","rating","url","author","publisher","publish_date","price","commentNum","tag"};
    public static String [] fields = {"type","price"}; //  类型，价格

    public static void main(String[] args) throws Exception{
//        String localProjectPath = new File("").getAbsolutePath();
//        System.setProperty("hadoop.home.dir", localProjectPath + "/hadoopdir");
//        System.load(localProjectPath + "/hadoopdir/bin/hadoop.dll");
        Configuration conf = new Configuration();
        DBConfiguration.configureDB(conf,driverClass,dbUrl,userName,passwd);
        //获取job信息
        Job job = Job.getInstance(conf);

        job.setJarByClass(com.book.averagePrice.App.class);
        //设置map输出数据类型
        job.setMapOutputValueClass(FloatWritable.class);
        job.setMapOutputKeyClass(Text.class);

        //只用mapper即可完成分析，所以设置reduce为0
//        job.setNumReduceTasks(0);

        //关联自定义的mapper reducer
        job.setMapperClass(MyAvergePriceMapper.class);
        job.setReducerClass(MyAvergePriceReducer.class);

        // 添加mysql数据库jar
        //job.addArchiveToClassPath(new Path("/jar/mysql-connector-java-5.1.41.jar"));

        //设置数据输入和输出文件的路径
        FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.100.10:9000/book/bookinfo.txt"));
        //FileOutputFormat.setOutputPath(job, new Path(localProjectPath + "/output/avgPrice"));
        DBOutputFormat.setOutput(job,tableName,fields);

        //提交代码
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);

    }
}
