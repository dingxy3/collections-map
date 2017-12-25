package com.jdk;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
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
	  return indexOf(o)>-1;
  }
   /**
	 * 获得元素的位置，不存在返回-1
	 * @param o
	 * @return
	 */
  public int indexOf(Object o ){
	  if(null == o){//对null进行校验，否则当null为空时，用o.equals方法报空指针错误
		  for(int i = 0 ; i <size ; i++){//遍历是否在等于o的元素
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
		  for(int i = 0 ; i < size ; i++){
			  if(null == elementData[i]){
				  System.arraycopy(elementData, i+1, elementData, i, size-i-1);
				  elementData[--size] = null ;
				  return true ;
			  }
		  }
	  }else{
		  for(int i = 0 ; i < size ; i++){//0
			  if(o.equals(elementData[i])){//{0,1,2,3,4,5,6}
                  //System.arraycopy(elementData, 1, elementData, 0, 6);
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
	  checkRangeForAdd(index);//校验长度
	  ensureCapacity(size+1);//保证容量
	  System.arraycopy(elementData, index, elementData, index+1, size-index);
	  elementData[index] = e;
	  size++;
	  
  }
  //addAll
  public void addAll(Collection<? extends E> o){
	  Object[] var2 = o.toArray();
	  int length = var2.length;
	  ensureCapacity(size+length);//{0,1,2,3,4,5,6} {7,8,9}
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
   private class ImplIterator  implements Iterator<E> {

  	  private  int cur = 0 ;
  	  @Override
	  public  boolean hasNext(){
  	  	return cur<size();
	  }
	  @Override
	  public E next(){
  	  	return (E)elementData[cur++] ;
	  }
	  @Override
	  public void remove(){
	  	ImplArrayList.this.remove(--cur);
	  }
   }
    public Iterator<E> iterator() {
        return new ImplIterator();
    }

}
