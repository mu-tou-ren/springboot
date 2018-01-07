package com.neo.springBoot;

public class Test {
	
	public static void main(String[] args) {
		int m = 0;
		for (int i = 0; i < args.length; i++) {
			m = ++m;
		}
		System.out.println(m);
	}
}
