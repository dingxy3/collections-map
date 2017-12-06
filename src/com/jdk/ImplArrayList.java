package com.jdk;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/**
 * @author : dxy
 * @version : 创建时间：2017-11-6 
 * @description :实现ArrayList
 */
public class ImplArrayList<E>implements RandomAccess,Cloneable,Serializable {
	
 
   private static final long serialVersionUID = 1L;
   
   private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

   private static final int DEFAUT_CAPACITY = 10 ;
  
   private  Object[] elementData ;
   
   private  Object[] defaultElementData = {};
   
   private  int size = 0;
  
  
   public ImplArrayList(){
	  this(DEFAUT_CAPACITY);
  
  }

  
  public ImplArrayList(int defautCapacity) {
	 // TODO Auto-generated constructor stub
	 if(defautCapacity < 0){
		throw new IllegalArgumentException("默认大小"+defautCapacity);
	
	 }else{
		elementData = new Object[defautCapacity];
	
	 }
  }
  //add e to list
  public boolean add(E e){
	  ensureCapacity(size + 1);//保证容量
	  elementData[size++] = e ;//元素追加到数组后面
	  
	  return true;
  }
 
  //Returns the number of elements in this list.
  public int size(){ return size; }
  
  //Returns <tt>true</tt> if this list contains the specified element.
  //null.equals() will throw NullPointerException
  public boolean contains(Object o){
	  if(null == o){
		  for(int i = 0 ; i <size ; i++){
			  if(null == elementData[i]){
				  return  true ;	
			  }
		  }  
	  }else{
	     for(int i = 0 ; i<= size ; i++){
		   if(o.equals(elementData[i])){
			  return true;
		   }
	   }
	 }
	 // return indexOf(o)>-1;
	  return false;
  }
  // Returns <tt>index</tt> in  list where it contains the specified element.
  public int indexOf(Object o ){
	  if(null == o){
		  for(int i = 0 ; i <size ; i++){
			  if(null == elementData[i]){
				  return i ;	
			  }
		  }  
	  }else{
		  for(int i = 0 ; i <size ; i++){
			  if(o.equals(elementData[i])){
				  return i ;	
			  }
		  }
	  }
	  return -1;
  }
  //get element by index if exists
  public Object get(int i ){
	  rangeCheck(i);
	  return elementData[i];
  }
  //return "true" if the list has no element
  public boolean isEmpty(){
	if(size == 0){
		return true ;
	}
	  return false ;
	 //jdk return size ==0
  }
  //remove by o
  public boolean remove(Object o){
	  if(null == o ){
		  for(int i = 0 ; i <= size ; i++){
			  if(null ==elementData[i]){
				  System.arraycopy(elementData, i+1, elementData, i, size-i-1);
				  elementData[--size] = null ;
				  return true ;
			  }
		  }
	  }else{
		  for(int i = 0 ; i <= size ; i++){
			  if(o.equals(elementData[i])){
				  System.arraycopy(elementData, i+1, elementData, i, size-i-1);
				  elementData[--size] = null ;//Gc do work
				  return true ;
			  }
		  }
	  }
	
	  return false ;
  }
  //remove by index 
  public boolean remove(int i){
    rangeCheck(i);
	return remove(elementData[i]);
	  
  }

  //toArray()
  public Object[] toArray(){
	  
	  return Arrays.copyOf(elementData, size);
  }
  //add
  public void add(E e , int index){
	  checkRangeForAdd(index);
	  ensureCapacity(size+1);
	  System.arraycopy(elementData, index, elementData, index+1, size-index);
	  elementData[index] = e;
	  size++;
	  
  }
  //addAll
  public void addAll(Collection<? extends E> o){
	  Object[] var2 = o.toArray();
	  int length = var2.length;
	  ensureCapacity(size+length);//
	  System.arraycopy(o, 0, elementData, size, length);//o 源数组
	  size += length;
	  
  }
  private void rangeCheck(int i){
	  if(i >= size || i < 0){
		  throw new IndexOutOfBoundsException("index"+i+",ImplArraylist Size"+size);
	  }
  }
  public void ensureCapacity(int size){
	  if(size > DEFAUT_CAPACITY){
		  explicitCapacity(size);
	  }
	  if(size <0 ){
		  throw new OutOfMemoryError();
	  }
  }
  
  private void explicitCapacity(int size){
	  if(elementData == defaultElementData){
		  size = Math.max(DEFAUT_CAPACITY,size);
	  }
	  if(size - elementData.length > 0){
		  grow(size);
	  }
  }
  
  private void grow(int size){
	 int oldLength = elementData.length ;
	 int newLength = oldLength +(oldLength >> 1);
	 if(newLength - size < 0){
		 newLength = size ;
	
	 }
	 if(newLength - MAX_ARRAY_SIZE > 0){
		 newLength =(size>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:MAX_ARRAY_SIZE ;
	     elementData =	 Arrays.copyOf(elementData, newLength)	 ;
	
	 }
  }
  
  private void checkRangeForAdd(int index){
	  if(index > size || index <0 ){
		  throw new IndexOutOfBoundsException("index"+index +",size"+size);
		  
	  }
  }
  
	public static void main (String[] args){
		
		ImplArrayList list = new ImplArrayList<>();
		
		list.add("1");
		list.add("2");
		System.out.println(list.contains("2"));
		System.out.println(list.indexOf("2"));
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.isEmpty());
		System.out.println(list.remove("2"));
		System.out.println(list.contains("2"));
		System.out.println("list的长度"+list.size());
		
	}
  
} 
