package com.book.test;

import java.util.*;
import java.util.Map.Entry;

import com.book.util.CountryUtil;

public class Main {

	public static void main(String[] args) {
		String line = "https://book.douban.com/subject/1770782/^小说^追风筝的人^[阿富汗]卡勒德·胡赛尼^8.8^269893^29.00元^上海人民出版社^2006-5^75057";
		//按照^字符对数据进行分割
		String[] words = line.toString().split("\\^"); 
		if(words.length == 10) {//等于10表明数据长度正常
			try {
				String url = words[0];
				String tag = words[1];
				String name = words[2];
				String author = words[3];  //这是第四个字段，是作者，此字符串前面有国家
				Float rating = Float.valueOf(words[4]);
				String price = words[6];
				String publisher = words[7];
				String publish_date = words[8];
				int commentNum = Integer.parseInt(words[9]);
				
				//提取国家
				int previousIndex = author.indexOf("[");
				int laterIndex = author.indexOf("]");
				
				System.out.println(author.substring(previousIndex+1, laterIndex));
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
			
	}
	
	 
	public static void main5() {
		 // creating tree map 
	      TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
	            
	      // populating tree map
	      treemap.put(2, "two");
	      treemap.put(1, "one");
	      treemap.put(3, "three");
	      treemap.put(6, "six");
	      treemap.put(new Integer(5), "five");      
	      treemap.put(new Integer(5), "sss");      
	      
	      System.out.println(treemap);
	      
	      // removing value at key 5
	      System.out.println(treemap.remove(treemap.firstKey()));
	      
	      System.out.println(treemap);


	}
	public static void main4() {
		TreeMap<String, Integer> map=new TreeMap<String,Integer>();
        map.put("a", 1);
        map.put("b", 2); 
        map.put("c", 3);
        map.put("e", 4);
        map.put("f", 5);
        
        List<Entry<String,Integer>> list =new ArrayList<Entry<String,Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {

           public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        	// TODO Auto-generated method stub
        	return o2.getValue().compareTo(o1.getValue());
        }
        });
        for(Entry<String, Integer> aEntry:list) {
            System.out.println(aEntry.getKey()+":"+aEntry.getValue());
        }
        int v = map.remove("c");
        System.out.println("------"+v);
        for(Entry<String, Integer> aEntry:list) {
            System.out.println(aEntry.getKey()+":"+aEntry.getValue());
        }
        System.out.println("------"+v);
        System.out.println(map);

	}
	
	public static void main3() {
		TreeMap<Float,String> map = new TreeMap<Float,String>(new Comparator<Float>() {
			public int compare(Float o1, Float o2) {
				if(o2>o1) {
					return 1;
				}else if(o2 == o1) {
					return 0;
				}else {
					return -1;
				}
			}
		});
        map.put(1f, "a");
        map.put(2f, "b");
        map.put(3f, "c");
        map.put(4f, "d");
        map.put(5f, "e");
        if(map.size()>4) {
        	map.remove(map.lastKey());
        }
        map.put(6f, "f");
        if(map.size()>4) {
        	map.remove(map.lastKey());
        }
        map.put(7f, "g");
        System.out.println(map);
        System.out.println(map.remove(map.firstKey()));
        
        System.out.println(map);
		
	}
	
	public static void main1() {
		Map  map = new TreeMap<Integer, String>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		map.put(111,"bcd");
		map.put( 444,"ffg");
		map.put(222,"efg");
	
		System.out.println(map);
	}
	
	public static void main2() {
		 
	}
	
}
