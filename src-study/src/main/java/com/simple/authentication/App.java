package com.simple.authentication;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;


public class App {
	public static void main(String[] args) {

		
		
		long d=1467009007465l;
		
		
		Date date = new Date();
		
		date.setTime(d);
		System.out.println(date);
		
		Calendar instance = Calendar.getInstance();
		System.out.println(instance.get(Calendar.YEAR));
		System.out.println("----------");
		Date addMinutes = DateUtils.addMinutes(instance.getTime(), 3);
		System.out.println(addMinutes);
		
		System.out.println(instance.getTime().compareTo(addMinutes) );
		System.out.println(addMinutes.compareTo(instance.getTime()));
		System.out.println(instance.getTime().compareTo(instance.getTime()));
		int minute = instance.get(Calendar.MINUTE);
		System.out.println(minute);
		System.out.println(instance.get(Calendar.DAY_OF_YEAR));
		System.out.println("=====================");
		System.out.println(minute/10*10);
		

	}
}
