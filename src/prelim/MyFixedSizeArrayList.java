package prelim;

import java.util.*;

public class MyFixedSizeArrayList implements MyList<Object>{
    private final int size = 5;

    private final Object[] array = new Object[size];


    @Override
    public int getSize() {
        return size;
    }

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

    @Override
    public Object getElement(Object data) {
        for (int i = 0; i < this.array.length; i++){
            if (data.equals(array[i])){
                return array[i];
            }
        }
        throw new NoSuchElementException();
    }

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
