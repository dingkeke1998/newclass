package com.book.averagePrice;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyAvergePriceReducer extends Reducer<Text, FloatWritable, ReceiveTable, NullWritable> {

    protected void reduce(Text key, Iterable<FloatWritable> values,
                          Reducer<Text, FloatWritable, ReceiveTable, NullWritable>.Context context)
            throws IOException, InterruptedException {
        float sum = 0;
        int num =0;
        for(FloatWritable v : values) {
            //将数据存入数据库
            sum+=Float.parseFloat(v.toString());
            num++;
        }
        ReceiveTable receiveTable = new ReceiveTable(key.toString(), sum/num);

        System.out.println(key.toString()+"----"+(sum/num));
        context.write(receiveTable,null);


    }
}
