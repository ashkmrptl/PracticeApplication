package com.akp.innerclass;

class A {
	{
		new B();
	}

	static class B {
		{
			new A().new C();
		}
	}

	class C {
		{
			System.out.println("SUCCESS");
		}
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		new A();
	}
}
