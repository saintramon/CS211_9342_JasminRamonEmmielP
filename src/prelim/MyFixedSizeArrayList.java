/**
 * PRELIM INDIVIDUAL PROJECT TASK 1
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

public class MyFixedSizeArrayList implements MyList<Object> {
    private final int size = 5;

    private final Object[] array = new Object[size];

    /**
     * This method returns the size of the list which is 5.
     *
     * @return The size of the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * This method inserts an object into the first available cell that is not already occupied.
     *
     * @param data The data to insert into the list
     * @throws ListOverflowException if the list is already full
     */
    @Override
    public void insert(Object data) throws ListOverflowException {
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                return;
            }
        }

        throw new ListOverflowException();
    }

    /**
     * This method inserts an object into the specified index in the list.
     *
     * @param index The index at which to insert the object
     * @param data  The data to insert into the list
     * @throws ListOverflowException if the index is out of bounds
     */
    public void insert(int index, Object data) throws ListOverflowException {
        if (index >= array.length) {
            throw new ListOverflowException();
        }

        array[index] = data;
    }

    /**
     * This method returns an object from the list if the input object is within the list.
     *
     * @param data The data to search for in the list
     * @return The object with the specified data
     * @throws NoSuchElementException if the element with the data is not found
     */
    @Override
    public Object getElement(Object data) throws NoSuchElementException {
        for (int i = 0; i < this.array.length; i++) {
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
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Object getElement(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * This method deletes the specified object within the list.
     *
     * @param data The data of the element to be deleted
     * @return true if the element was found and deleted, false otherwise
     */
    @Override
    public boolean delete(Object data) {
        for (int i = 0; i < this.array.length; i++) {
            if (data.equals(array[i])) {
                array[i] = null;
                return true;
            }
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
        for (int i = 0; i < this.array.length; i++) {
            System.out.println("Comparing data: " + data.toString() + " with array[" + i + "]: " + array[i].toString());
            if (data.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }
}
