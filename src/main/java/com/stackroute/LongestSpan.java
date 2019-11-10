package com.stackroute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class LongestSpan {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
    	
    	int count;
    	int[] numInt;
    	Scanner s= new Scanner(System.in);
    	count = s.nextInt();
    	numInt = new int[count];
    	for(int i=0;i<count;i++) {
    		
    		numInt[i] = s.nextInt();
    	}
    	String result = findLongestSpan(numInt);
    	if(result== "-1"){
    		System.out.println("EmptyArray");
    	}else {
    	System.out.println(result);}
	}

	public static String findLongestSpan(int[] numbers) {
		String span = "-1";
		List<Integer> pInt = new ArrayList<Integer>();
		
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		if(null != numbers && numbers.length>0) {
			
			for(int i=0;i<numbers.length;i++) {
				//int count=0;
				for(int j=1;j<numbers.length;j++) {
					if(numbers[i]==numbers[j]) {
						
						numMap.put(numbers[j], j);
					}
				}
				
			}
			Set<Entry<Integer,Integer>> en = numMap.entrySet();
			for(Entry<Integer,Integer> entry : en) {
				if(entry.getKey().equals(numbers[0])) {
					result.put(entry.getKey(), entry.getValue()+1);
				}
			}
		}
		else {
			return span;
		}
		
		Set<Entry<Integer,Integer>> en = result.entrySet();
		//System.out.println("Out " + result);
		//for(int i=0;i<result.size();i++) {
		int size = 0;
		int key = 0;
		String out = "";
		for(Entry<Integer,Integer> entry : en) {
			int val = entry.getValue();
			int lkey = entry.getKey();
			if(val >  size) {
				//out = String.valueOf(key)+":"+String.valueOf(val);
				key = lkey;
				size = val;
			}else if(val == size) {
				if(key < lkey) {
					key = lkey;
				}
			}
		}
		out = String.valueOf(key) + ":" + String.valueOf(size);
		
		//}
		
		return out;
	}
}
