package com.book.averagePrice;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Pattern;

public class MyAvergePriceMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split("\\^");
        String pattern = "^[1-9]\\d*.\\d*(\\元)|0.\\d*[1-9]\\d*(\\元)$";
        Pattern r = Pattern.compile(pattern);
        if (words.length == 10){
            try {
                String tag = words[1];
                boolean isMatch = Pattern.matches(pattern,words[6]);
                if (isMatch){
                    Float price =Float.parseFloat(words[6].replace("元",""));
                    context.write(new Text(tag),new FloatWritable(price));
                }
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
    }
}
