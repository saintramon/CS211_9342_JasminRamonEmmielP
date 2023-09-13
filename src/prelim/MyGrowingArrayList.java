/**
 * PRELIM INDIVIDUAL PROJECT TASK 2
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

public class MyGrowingArrayList implements MyList<Object> {
    private final int INITIAL_SIZE = 5;

    private int size;

    private Object[] array;

    /**
     * This constructor initializes the MyGrowingArrayList object with an initial capacity of 5, and the size depends on how many elements are in the current list.
     */
    public MyGrowingArrayList() {
        this.array = new Object[INITIAL_SIZE];
        size = 0;
    }

    /**
     * This method returns the current size of the list.
     *
     * @return The current size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * These methods insert the passed Object in the list. The capacity of the list will double if necessary, but the size will only increment by 1.
     *
     * @param data The data to insert into the list
     */
    @Override
    public void insert(Object data) {
        if (size == array.length) {
            int newSize = size * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
        array[size] = data;
        size++;
    }

    /**
     * This method inserts an object at the specified index in the list. The capacity of the list will double if necessary, but the size will only increment by 1.
     *
     * @param index The index at which to insert the object
     * @param data  The data to insert into the list
     */
    public void insert(int index, Object data) {
        if (size == array.length) {
            int newSize = size * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index, newArray, index + 1, size - index);
            this.array = newArray;
        } else {
            System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        }
        array[index] = data;
        size++;
    }

    /**
     * These methods return the object with the specified data or the object at the given index.
     *
     * @param data The data to search for in the list
     * @return The object with the specified data
     * @throws NoSuchElementException if the element with the data is not found
     */
    @Override
    public Object getElement(Object data) throws NoSuchElementException {
        for (int i = 0; i < this.size; i++) {
            if (data.equals(array[i])) {
                return array[i];
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * This method returns the object at the specified index in the list.
     *
     * @param index The index of the element to retrieve
     * @return The object at the specified index
     */
    public Object getElement(int index) {
        return array[index];
    }

    /**
     * These methods delete the object with the specified data or the object at the given index in the list.
     *
     * @param data The data of the element to be deleted
     * @return true if the element was found and deleted, false otherwise
     */
    @Override
    public boolean delete(Object data) {
        for (int i = 0; i < this.size; i++) {
            if (data.equals(array[i])) {
                System.arraycopy(this.array, i + 1, this.array, i, this.size - i - 1);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * This method deletes the object at the specified index in the list.
     *
     * @param index The index of the element to be deleted
     * @return true if the element was found and deleted, false otherwise
     */
    public boolean delete(int index) {
        if (index < size && index >= 0) {
            System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
            array[--size] = null;
            return true;
        }
        return false;
    }

    /**
     * This method returns the index of the object with the specified data if it is in the list, -1 otherwise.
     *
     * @param data The data to search for in the list
     * @return The index of the element with the specified data, or -1 if not found
     */
    @Override
    public int search(Object data) {
        for (int i = 0; i < this.size; i++) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
