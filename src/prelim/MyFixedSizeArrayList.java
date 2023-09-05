package prelim;

public class MyFixedSizeArrayList implements MyList<String>{

    private final int size = 5;

    private Object[] array = new Object[size];

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(String data) {

    }

    @Override
    public String getElement(String data) {
        return null;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }

    @Override
    public int search(String data) {
        return 0;
    }
}
