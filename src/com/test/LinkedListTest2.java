package com.test;

/**
 * 双端链表的实现
 * @author asus
 *
 */
public class LinkedListTest2 {
	 private Node head;  //头结点
	    private Node tail;  //尾结点
	    private int size;  //链表长度，即链表中结点数量
	    
	    public LinkedListTest2(){
	        head = null;  //头结点
	        tail = null;  //尾结点
	        size = 0;  //链表长度，即链表中结点数量
	    }
	    
	    //私有内部类，代表链表每个结点
	    private class Node{
	        private Object data;  //链表结点的值
	        private Node next;  //指向的下一个结点
	        public Node(Object data){
	            this.data = data;
	        }
	    }
	    
	    //判断链表是否为空
	    public boolean isEmpty(){
	        return size==0?true:false;
	    }
	    
	    //返回链表长度
	    public int size(){
	        return size;
	    }
	    
	    //查看链表头结点，不移除
	    public Object headNode(){
	        if(size == 0) return null;
	        return head.data;
	    }
	    
	    //查看链表尾结点，不移除
	    public Object tailNode(){
	        if(size == 0) return null;
	        return tail.data;
	    }
	    
	    
    //在链表表头插入一个节点
    public void insertInHead(Object obj) {
    	Node newNode=new Node(obj);
    	if(size==0) {
    		head = newNode;
    		tail = newNode;
    	}else {
    		newNode.next = head;
    		head = newNode;
    	}
    	size++;
    }
	    
	  //在链表表尾插入一个节点
    public void insertInTail(Object obj) {
    	Node newNode=new Node(obj);
    	if(size==0) {
    		head = newNode;
    		tail = newNode;
    	}else {
    		tail.next = newNode;
    		tail = newNode;
    	}
    	size++;
    }
    
    public static void main(String[] args) {
		LinkedListTest2 link=new LinkedListTest2();
		link.insertInHead(0);
		link.insertInHead(1);
		link.insertInHead(2);
		link.insertInHead(3);        
	}
	    
}
