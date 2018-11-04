package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 双向链表的实现
 * 该列表是否可以存放异构对象，去掉本类的泛型是否可以；结论：将T设为Object时，该列表可以存放异构对象， 
 * @author asus
 *
 */
@SuppressWarnings("unchecked")
public class LinkedListTest3<T> {
	//是否可以先建立一个内部类，在内部类中定义节点属性;结果：新建了一个节点类，把节点单独作为一个对象使用；使用内部类也是可以的；
    
	public MyNode head = new MyNode(null);
	public MyNode last = new MyNode(null);
	
    public LinkedListTest3() {
    	head.previous=null;
    	head.next=last;
    	last.previous=head;
    	last.next=null;
    }
    
    //从头部开始添加
	public void addToHead(T value) {
    	MyNode node = new MyNode(value);
    	head.next.previous=node;
    	node.next=head.next;
    	node.previous=head;
    	head.next=node;
    }
    
    //从尾部开始添加
    public void addToLast(T value) {
    	MyNode node=new MyNode(value);
    	last.previous.next=node;
    	node.previous=last.previous;
    	node.next=last;
    	last.previous=node;
    }
    
    //删除节点，使用value，如果加上下标的话，就变成hash表了；删除第一个相同的value
    public void delete(T value) throws Exception {
    	MyNode node=head.next;
    	while(node != null && node != last) {
    		if(node.getValue() == value) {
    			//删除
    			node.previous.next=node.next;
    			node.next.previous=node.previous;
    			node=null;
    			break;
    		}
    		node=node.next;
    	}
    	boolean isTheLast = node==last;
    	if(isTheLast) {
    		throw new Exception("链表中不存在："+value);
    	}
    }
    
    //链表的双向遍历
    public void printListFromHead() throws Exception {
    	MyNode node=head.next;
    	if(node == last) {
    		throw new Exception("链表为空");
    	}
    	while (node != null && node != last) {
    		System.out.println(node.getValue()+"");
    		node=node.next;
		}
    }
	public void printListFromLast() throws Exception {
    	MyNode node =last.previous;
    	if(node == head) {
    		throw new Exception("链表为空");
    	}
    	while (node != null && node != head) {
    		System.out.println(node.getValue()+"");
    		node=node.previous;
		}
    }

	public MyNode getHead() {
		return head;
	}

	public void setHead(MyNode head) {
		this.head = head;
	}

	public MyNode getLast() {
		return last;
	}

	public void setLast(MyNode last) {
		this.last = last;
	}
}


/**链表节点类*/
class MyNode<T>{
	public T value;	//节点值
	public MyNode<T> previous;//前一个，如果没有这个参数的话，不好从后向前遍历
	public MyNode<T> next;
	
	public MyNode(T value) {
		this.value=value;
		this.next=null;
		this.previous=null;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public MyNode<T> getPrevious() {
		return previous;
	}
	public void setPrevious(MyNode<T> previous) {
		this.previous = previous;
	}
	public MyNode<T> getNext() {
		return next;
	}
	public void setNext(MyNode<T> next) {
		this.next = next;
	}
	
	
	
}

