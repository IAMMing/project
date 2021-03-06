package com.simple.src_study;

public class StringStudy2 {
	public static void main(String[] args) {
		long strStart = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {

			String str = "abc";
			str+="def";
		}
		long strEnd = System.currentTimeMillis();
		System.out.println("str=\"abc\"; 执行10000次耗时：" + (strEnd - strStart));

		long strStart1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {

			String str1 = new String("abc");
			str1+="edf";
		}
		long strEnd1 = System.currentTimeMillis();
		System.out.println("str=new String(\"abc\"); 执行10000次耗时：" + (strEnd1 - strStart1));

		long sbfStart = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {

			StringBuffer sbf = new StringBuffer("abc");
			sbf.append("edf");
		}
		long sbfEnd = System.currentTimeMillis();
		System.out.println("sbf=new StringBuffer(\"abc\"); 执行10000次耗时：" + (sbfEnd - sbfStart));

		long sbfStart1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			StringBuffer sbf1 = new StringBuffer();
			sbf1.append("abc");
			sbf1.append("edf");
		}
		long sbfEnd1 = System.currentTimeMillis();
		System.out.println("sbf.append(\"abc\"); 执行10000次耗时：" + (sbfEnd1 - sbfStart1));

		long sbdStart = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			StringBuilder sbd = new StringBuilder("abc");
			sbd.append("edf");
		}
		long sbdEnd = System.currentTimeMillis();
		System.out.println("sbd=new StringBuilder(\"abc\"); 执行10000次耗时：" + (sbdEnd - sbdStart));

		long sbdStart1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			StringBuilder sbd = new StringBuilder();
			sbd.append("abc");
			sbd.append("edf");
		}
		long sbdEnd1 = System.currentTimeMillis();
		System.out.println("sbd.append(\"abc\"); 执行10000次耗时：" + (sbdEnd1 - sbdStart1));

	}
}
