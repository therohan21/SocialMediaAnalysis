package com.spnotes.kafka.simple;
import java.io.*;
import java.util.concurrent.TimeUnit;
public class FileReadDemo {
	
	public static void main(String[] argv)throws Exception {
		File file = new File("/Users/therohan_21/Desktop/text");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine()) != null) {
			System.out.println(st);
			TimeUnit.SECONDS.sleep(5);
		}
		
	}
	
	
}
