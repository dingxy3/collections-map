package com.jdk;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : dxy
 * @version : 创建时间：2017-11-8 
 * @description :
 */
public class ImplLinkedList<E> {

	private static class Node<E>{
		E e;
		Node<E> next;
		Node<E> prev;
		
	Node(E e ,Node<E> next,Node<E> prev){
		 this.e = e ;
		 this.next = next ;
		 this.prev = prev ;
	 }	
	}
	
	private int size ;
	
	private Node<E> first;
	
	private Node<E> last ;

	public ImplLinkedList(){}
	
	public void add(E e){
	
	 //addlast(e);
	 addlast(e);
	}
	public void add(int index ,E e){

		if (index == size){
			Node<E> l =last ;
			Node<E> x = new Node<E>(e,null,last) ;
			if (l == null){
				first = x ;
				last = x ;
			}else {
				x = l.next ;
				last = x ;
			}
		}else{
          Node<E> x = node(index);
          Node<E> prev = x.prev ;
          Node<E> cur = new Node<E>(e,prev,x);
          if (prev ==null){
          	x.prev = cur ;
          	first = cur ;
		  }else {
          	prev.next = cur ;
            x.prev = cur ;
		  }
		}
		size ++ ;
	}
	public int size(){	return size ; }
	
	public E get(int index){//出错过
		rangeCheck(index);
		if(index < (size>>1)){
			Node<E> l = first ;
			for(int i = 0 ; i<index ; i++){
				l = l.next;
			}
			return l.e;
		}else{
			Node<E> l = last ;
			for(int p = size -1 ; p> index ; p--){
				l = l.prev ;
			}
			return l.e;
		}
	}
	//返回当前节点
	public  Node<E> node(int index){

		if (index<(size>>1)){//折半查找
			Node<E> x = first ;
			for (int i = 0 ; i<index ; i ++){
                 x = x.next ;
			}
			return  x ;
		}else {
			Node<E> x = last ;
			for (int i =size - 1 ; i > index ; i--){
                x = x.prev ;
			}
			return x ;
		}
	}
	public void addlast1(E e){
		Node<E> l = last ;
		Node<E> newNode = new Node<E>(e,null,l) ;

		last = newNode ;
		if(l == null){
			first = newNode;
		}else{
			l.next = newNode ;
		}
		size ++ ;
	}
	public void addlast(E e){
		Node<E> newNode = new Node<E>(e,null,last) ;
		if(last == null){
			last = newNode;
			first = newNode;
		}else{
			//
			last.next = newNode;
			last = newNode ;
		}
		size ++ ;
	}
	public void addFirst1(E e){//deleted
		Node<E> f = first ;
		Node<E> newNode = new Node<E>(e,f,null) ;
		first = newNode ;
		if(f == null){
			f = newNode;
		}else{
			f = newNode.next ;
		}
		size ++ ;
	}
	public void addFirst(E e){
		/*Node<E> newNode = new Node<E>(e,first,null) ;
		if(first == null){
			first = newNode ;
			last = newNode;
		}else{
			first.prev = newNode ;
			first = newNode ;
		}
		size ++ ;*/
		
		   Node<E> f = first;
		  Node<E> newNode = new Node<E>(e,first,null) ; 
	        first = newNode;
	        if (f == null)
	            last = newNode;
	        else
	        	f.prev = newNode ;
	            // first.prev = newNode;//error
	        	// f = newNode.next ;//error
	            //  newNode.next = f;//error
	        size++;
	}
	private void rangeCheck(int index){
		if(index > size-1 || index < 0){
			throw new IndexOutOfBoundsException("越界");
		}
	}

	//check ImplLinkedList contains O ？
	public  boolean contains(Object o) {
		if (null == o) {
			for (Node<E> e = first; e != null; e = e.next) {
				if (e.e == null) {
					return true;
				}
			}
		} else {
			for (Node<E> e = first; e != null; e = e.next) {
				if (o.equals(e.e)) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean remove(Object o){
		if (null ==  o){
          for (Node<E> x = first ; x != null ; x= x.next){
          	if (x.e == null){
				link(x);
			}
		  }
		}else {
			for (Node<E> x = first ; x != null ; x= x.next){
				if (o.equals(x.e)){
					link(x);
				}
			}

			size -- ;
		}
	   return  false ;
	}
	private  void link(Node<E> x){
		//prev -> x - > next 结构
		Node<E> prev = x.prev ;
		Node<E>  next = x.next ;
		//如果x.prev为空说明为head指针，只要将头指针移到下一个节点
		if (x.prev == null){
			first = next;

		}else {
			//如果不为空，将前一个指针的next指向下个节点，并将当前指针的prev 置为空
			prev.next = next ;
			x.prev = null ;
		}
		if (x.next ==null){
			last = prev ;
		}else {
			//如果不为空，将后一个节点（next）的prev指向上一个节点（prev），并将当前指针的next置为空
			next.prev = prev ;
			x.next = null ;
		}
		x.e = null ;
	}
	
	public static void main(String[] args){
		ImplLinkedList link = new ImplLinkedList();
		link.add("2");
		link.add("1");
		link.add("3");
		link.addlast("5") ;

		link.add(1,"6");
		
		/*System.out.println(link.size());*/
	    System.out.println("0::::::"+link.get(0));
		System.out.println(link.get(1));
		System.out.println(link.get(2));
		/*System.out.println(link.get(3));*/

		List jdk = new LinkedList<>();
		jdk.add("2");
		jdk.add("1");
		jdk.add("5");
		jdk.add(2,"6");
		System.out.println("jdk====="+jdk.get(0));
		System.out.println(jdk.get(1));
		System.out.println(jdk.get(2));
		System.out.println(jdk.get(3));
		
		
	}
}
