package com.akp.innerclass;

public class StaticInnerClassExample {
	private static int a = 10;
	private int b = 20;
	static int c = 30;
	int d = 40;
	
	public static class InnerClass{
		private int e = 50;
		int f = 60;
		private static int g = 70;
		static int h = 80;
		public void addAll() {
			StaticInnerClassExample sice = new StaticInnerClassExample();
			System.out.println(a+sice.b+c+sice.d+e+f+g+h);
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerObject = new InnerClass();
		innerObject.addAll();
	}
}
