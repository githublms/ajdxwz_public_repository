package com.example.exer;

public class BaseTest {
	public static void main(String[] args) {
		
		Base base = new Sub(); // ��̬
		base.add(1,2,3); // ������õ������൱�е�add���� , ��  int ... arr ��int[] arr ������һ���Ĳ��� 	��������   sub-1
		
		Sub sub = (Sub)base; // ����ת��
		sub.add(1, 2, 3);  // ����ȷ���ķ��� �������������� ��������   sub-2
		
	}

}

class Base {
	public void add(int a,int ... arr) {
		System.out.println("base1");
	}
}
class Sub  extends Base { // add(int a,int[] arr) ��add(int a,int b,int c) ������   ���ع�ϵ
	public void add(int a,int[] arr) {  // ��ˣ�base���õ��������  add (int a,int[] arr)
		System.out.println("sub-1");
	}
	public void add(int a,int b,int c) {
		System.out.println("sub-2"); 
	}
}





