package linear_structure.arrayList_sample;

import linear_structure.List;

import java.util.Arrays;

public class ArrayList implements List {
    //底层是一个数组
    private  Object[] elementData;
    private int size; //元素的个数

    public ArrayList() {
        this(4);
       //elementData = new Object[]{};
    }

    /*
    * @param initialCapacity 指定数组的长度
    * */
    public ArrayList(int initialCapacity) {
        //指定数组长度
        elementData = new Object[initialCapacity];
        /*//指定元素个数
        size = 0;*/

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(i < 0 || i >= elementData.length){
            throw new RuntimeException("组索引越界异常： " + i);
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(Object e) {
        add(size,e);
   /*     if(e == null)
            return;
        if(size == elementData.length){
            grow();
        }
        elementData[size] = e;
        size++;*/
    }

    @Override
    public void add(int i, Object e) {
        if(i < 0 || e == null || i > size)
            throw new RuntimeException("索引不能为负,也不能超过数组的长度，插入的对象不能为空");
        //扩容
        if( size == elementData.length || (i + size) >= elementData.length) {
            System.out.println("Grow called");
            grow();
        }
        //后移i及其后面的元素，从最后一个元素开始
        for (int j = size; j > i ; j--) {
            System.out.println("J: " + j);
            elementData[j] = elementData[j-1];
        }
        elementData[i] = e;
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    void grow(){
        /*
        Object[] temp = new Object[elementData.length * 2];
        System.arraycopy(elementData, 0, temp, 0, elementData.length);
        elementData = temp;
        */
        elementData = Arrays.copyOf(elementData,elementData.length + elementData.length /2);
    }

    @Override
    public String toString() {
        return size ==0 ? "" : "ArrayList:" + Arrays.toString(elementData);
    }
}
