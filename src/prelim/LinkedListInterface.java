package prelim;

public interface LinkedListInterface<T> {
    public int getSize();
    public boolean isEmpty();

    public void insertAtHead(T data);
    public void insertAtTail(T data);
    public void insertAtIndex(int index, T data);

    public void deleteAtHead();
    public void deleteAtTail();
    public void deleteAtIndex(int index);
}
