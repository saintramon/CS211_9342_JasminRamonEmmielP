/**
 * PRELIM INDIVIDUAL PROJECT TASK 2
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

public class MyGrowingArrayList implements MyList<Object>{
    private final int INITIAL_SIZE = 5;

    private int size;

    private Object[] array;

    /**
     * This constructor will initialize the MyGrowingArrayList object with an initial capacity of 5 and the size will depend on how many elements are in
     * the current list.
     */
    public MyGrowingArrayList(){
        this.array = new Object[INITIAL_SIZE];
        size = 0;
    }

    /**
     * This method returns the current size of the list.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * These methods insert the passed Object in the list.
     * The capacity of the list will then double but the size will only increment by 1.
     * @param data
     */
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

    /**
     * These methods will return the key object or the corresponding object within the given index.
     * @param data
     * @return
     */
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

    /**
     * These methods delete the passed object or the object corresponding to the passed index in the list.
     * @param data
     * @return
     */
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

    /**
     * This method returns the index of the object to be found if the passed key is within the list, -1 otherwise.
     * @param data
     * @return
     */
    @Override
    public int search(Object data) {
        for (int i = 0; i < this.size; i++){
            System.out.println("Comparing data: " + data.toString() + " with array[" + i + "]: " + array[i].toString());
            if (data.equals(array[i])){
                return i;
            }
        }
        return -1;
    }


}
