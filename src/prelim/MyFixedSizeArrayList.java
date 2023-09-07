/**
 * PRELIM INDIVIDUAL PROJECT TASK 1
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

public class MyFixedSizeArrayList implements MyList<Object>{
    private final int size = 5;

    private final Object[] array = new Object[size];

    /**
     * This method returns the size of the list which is 5
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * This method inserts an object into the first available cell that is not already occupied.
     * @param data
     * @throws ListOverflowException
     */
    @Override
    public void insert(Object data) throws ListOverflowException{
        for (int i = 0; i < this.array.length; i++){
            if (array[i] == null){
                array[i] = data;
                return;
            }
        }

        throw new ListOverflowException();
    }

    /**
     * This method inserts the object in the specified index
     * @param index
     * @param data
     * @throws ListOverflowException
     */
    public void insert(int index, Object data) throws ListOverflowException{
        if(index >= array.length){
            throw new ListOverflowException();
        }

        array[index] = data;
    }

    /**
     * This method returns an object of the list if the input object is within the list
     * @param data
     * @return
     */
    @Override
    public Object getElement(Object data) {
        for (int i = 0; i < this.array.length; i++){
            if (data.equals(array[i])){
                return array[i];
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * This method returns the object in the specified index of the list
     * @param index
     * @return
     */
    public Object getElement(int index){
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * This method deleted the specified object within the list
     * @param data
     * @return
     */
    @Override
    public boolean delete(Object data) {
        for (int i = 0; i < this.array.length; i++){
            if (data.equals(array[i])){
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns a boolean which specifies if the object to be searched is within the list
     * @param data
     * @return
     */
    @Override
    public int search(Object data) {
        for (int i = 0; i < this.array.length; i++){
            if (data.equals(this.array[i])){
                return i;
            }
        }
        return -1;
    }

}
