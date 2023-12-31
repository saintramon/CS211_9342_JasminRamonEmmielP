package prelim;

public interface LinkedListInterface<T> {
    public int getSize();
    public boolean isEmpty();

    public T getElement(int index);
    public T getElement(T data);

    public int search(T data);

    public void insertAtHead(T data);
    public void insertAtTail(T data);
    public void insertAtIndex(int index, T data);

    public void deleteAtHead();
    public void deleteAtTail();
    public void deleteAtIndex(int index);
}
