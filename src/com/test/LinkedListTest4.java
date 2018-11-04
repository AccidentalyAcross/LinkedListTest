package com.test;

/**
 * 双向链表测试
 * @author asus
 *
 */
public class LinkedListTest4 {
	/**链表测试*/
	public static void main(String[] args) {
		try {
			LinkedListTest3<String> myList1=new LinkedListTest3();
			myList1.addToHead("ppp");
			myList1.addToHead("ssd");
			myList1.addToHead("sdf");
			myList1.addToHead("so");
			myList1.addToHead("123");
			myList1.addToHead("ggg");
			
			System.out.println("-------------正向遍历测试-----------");
			myList1.printListFromHead();
			System.out.println("-------------反向遍历测试-----------");
			
			System.out.println("-------------删除测试-----------");
			myList1.delete("ppp");
			myList1.printListFromHead();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
