package com.pojo;

public class Pojo_B {
	public static void main(String[] args) {
		Pojo_A a=new Pojo_A();
		int age = a.getAge();
		System.out.println(age);
		a.setAge(22);
		int value=a.getAge();
		System.out.println(value);
	}
	
    

}
