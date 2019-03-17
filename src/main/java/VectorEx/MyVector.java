package VectorEx;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyVector implements List {
    Object[] data = null;
    int capacity = 0;
    int size = 0;

    public MyVector(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("유효하지 않은 값입니다. :"+capacity);
        }
        this.capacity=capacity;
        this.data=new Object[capacity];
    }
    public MyVector(){
        this(10);
    }

    public int capacity(){
        return this.capacity;
    }

    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity-this.data.length>0){
            setCapacity(minCapacity);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data,0,result,0,size);
        return result;
    }

    @Override
    public boolean add(Object obj) {
        ensureCapacity(size+1);
        data[size++]=obj;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        for(int i=0;i<size;i++){
            if(obj.equals(data[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            data[i]=null;
        }
        size=0;
    }

    @Override
    public Object get(int index) {
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException("범위를 벗어났습니다. :"+index);
        }
        return data[index];
    }

    @Override
    public Object remove(int index) {
        Object oldObj = null;

        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("범위를 벗어났습니다. :"+index);
        }
        oldObj = data[index];
        if(index != size-1){
            System.arraycopy(data,index+1,data,index,size-index-1);
        }

        data[size-1]=null;
        size--;
        return oldObj;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return null;
    }

    public void trimToSize() {
        setCapacity(this.size);
    }

    private void setCapacity(int capacity){
        if(this.capacity==capacity) return;
        Object[] tmp = new Object[capacity];
        System.arraycopy(data,0,tmp,0,size);
        data=tmp;
        this.capacity=capacity;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator unaryOperator) {

    }

    @Override
    public void sort(Comparator comparator) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
