package com.example.exer;

public class BaseTest {
	public static void main(String[] args) {
		
		Base base = new Sub(); // 多态
		base.add(1,2,3); // 这里调用的是子类当中的add方法 , 将  int ... arr 和int[] arr 当成了一样的参数 	输出结果是   sub-1
		
		Sub sub = (Sub)base; // 向下转型
		sub.add(1, 2, 3);  // 调用确定的方法 ，有三个参数的 输出结果是   sub-2
		
	}

}

class Base {
	public void add(int a,int ... arr) {
		System.out.println("base1");
	}
}
class Sub  extends Base { // add(int a,int[] arr) 与add(int a,int b,int c) 构成了   重载关系
	public void add(int a,int[] arr) {  // 因此，base调用的是子类的  add (int a,int[] arr)
		System.out.println("sub-1");
	}
	public void add(int a,int b,int c) {
		System.out.println("sub-2"); 
	}
}





