package com.test;

/**
 * 单向链表的实现
 * @author asus
 *
 */
public class LinkedListTest1 {

	Node head=null;	//头节点
	
	/*链表中的节点，data代表节点的值，next是指向下一个节点的引用*/
	class Node{
		Node next=null;//节点的引用，指向下一个节点
		int data;//节点的对象，即内容
		
		public Node(int data) {
			this.data=data;
		}
		
	}
	
	/*向链表中插入数据*/
	public void addNode(int d) {
		Node newNode =new Node(d);//实例化一个节点
		if(head==null) {
			head=newNode;
			return;
		}
		Node tmp=head;
		while(tmp.next != null) {
			tmp=tmp.next;
		}
		tmp.next=newNode;
	}
	
	/*返回节点长度*/
	public int length() {
		int length = 0;
		Node tmp=head;
		while(tmp != null) {
			length++;
			tmp=tmp.next;
		}
		return length;
	}
	
	/**indes:删除第index个节点,实际上就是把节点数据给覆盖掉，引用位置重新指向*/
	public boolean deleteNode(int index) {
		if(index < 1 || index > length()) {
			return false;
		}
		if(index == 1) {
			head =head.next;
			return true;
		}
		int i=1;
		Node preNode=head;
		Node curNode = preNode.next;
		while(curNode != null) {
			if(i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return false;
	}
	
	/**在不知道头指针的情况下删除指定节点*/
	public boolean deleteNodell(Node n) {
		if(n == null || n.next == null) {
			return false;
		}
		int tmp =n.data;
		n.data=n.next.data;
		n.next.data=tmp;
		n.next=n.next.next;
		System.err.println("删除成功");
		return true;
	}
	
	public void printList() {
		Node tmp=head;
		while(tmp != null) {
			System.err.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListTest1 list=new LinkedListTest1();
		list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        //System.out.println("linkLength:" + list.length());
       // System.out.println("head.data:" + list.head.data);
        //list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
       // list.printList();
	}
	
}
