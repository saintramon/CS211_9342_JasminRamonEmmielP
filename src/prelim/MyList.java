package prelim;

import java.util.*;

public interface MyList<E>{
    public int getSize();
    public void  insert(E data);
    public E getElement(E data);
    public boolean delete(E data);
    public int search(E data);
}
