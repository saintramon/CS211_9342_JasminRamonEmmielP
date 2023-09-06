package prelim;

import java.util.*;

public class MyGrowingArrayList implements MyList{
    private final int INITIAL_SIZE = 5;

    private int size;

    private Object[] array;

    public MyGrowingArrayList(){
        this.array = new Object[INITIAL_SIZE];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void insert(Object data){
        if (size == array.length){
            int newSize = size * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
        array[size] = data;
        size++;
    }
    public void insert(int index, Object data){
        if (size == array.length){
            int newSize = size * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array,index,newArray,index+1,size-index);
            this.array = newArray;
        }else {
            System.arraycopy(this.array, index, this.array, index+1, this.size - index);
        }
        array[index] = data;
        size++;
    }

    @Override
    public Object getElement(Object data) {
        for (int i = 0; i < this.size; i++){
            if (data.equals(array[i])){
                return array[i];
            }
        }
        throw new NoSuchElementException();
    }
    public Object getElement(int index){
        return array[index];
    }

    @Override
    public boolean delete(Object data) {
        for (int i = 0; i < this.size; i++){
            if (data.equals(array[i])){
                System.arraycopy(this.array,i+1,this.array,i,this.size-i-1);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }
    public boolean delete(int index){
        if (index < size && index >= 0){
            System.arraycopy(this.array,index+1,this.array,index,this.size-index-1);
            array[--size] = null;
            return true;
        }
        return false;
    }

    @Override
    public int search(Object data) {
        for (int i = 0; i < this.size; i++){
            if (data.equals(array[i])){
                return i;
            }
        }
        return -1;
    }


}
