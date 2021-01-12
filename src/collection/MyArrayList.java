package collection;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList(int capacity){
        if (capacity<0){
            throw new RuntimeException("capacity is number greater than zero");
        }else if (capacity == 0){
            elementData = new Object[DEFALT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0 ? true : false ;
    }

    public void add(E element){
        if (size == elementData.length){
            Object[] newArray = new Object[(elementData.length+(elementData.length>>1))];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    public void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("index illegal :" + index);
        }
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(int index , E element){
        checkRange(index);
        elementData[index] = element;
    }

    public void remove(int index){
        int numMoved = elementData.length-index-1;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
    }

    public void remove(E element){
        for (int i=0; i<size;i++){
            if(element.equals(get(i))){
                remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0;i<size;i++){
            stringBuilder.append(elementData[i]+",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i=0;i<21;i++){
            myArrayList.add("number"+i);
        }
        myArrayList.set(10,"ok");
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(20));

        myArrayList.remove(2);
        myArrayList.remove("number9");
        System.out.println(myArrayList);
        System.out.println(myArrayList.size);
        System.out.println(myArrayList.isEmpty());
    }
}
