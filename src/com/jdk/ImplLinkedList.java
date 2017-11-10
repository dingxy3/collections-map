package com.jdk;
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
	  addFirst(e);
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
	            // first.prev = newNode;
	        	// f = newNode.next ;//error
	           //  newNode.next = f;//error
	        size++;
	}
	private void rangeCheck(int index){
		if(index > size-1 || index < 0){
			throw new IndexOutOfBoundsException("越界");
		}
	}

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
	
	public static void main(String[] args){
		ImplLinkedList link = new ImplLinkedList();
		link.add("2");
		link.add("1");
		link.add("3");
		//link.addFirst("3");
		//link.addFirst("4");
		//link.addlast("5") ;
		
		/*System.out.println(link.size());*/
	    System.out.println("0::::::"+link.get(0));
		System.out.println(link.get(1));
		System.out.println(link.get(2));
	
		
		
		
		
	}
}
