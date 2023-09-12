package prelim;

public class MySinglyLinkedCircularList<T> implements LinkedListInterface{

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public MySinglyLinkedCircularList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    @Override
    public Object getElement(int index) {
        return null;
    }

    @Override
    public Object getElement(Object data) {
        return null;
    }

    @Override
    public int search(Object data) {
        return 0;
    }

    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.head = newNode;
        }

        ++size;
    }

    @Override
    public void insertAtTail(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.head.setPrev(newNode);
            this.tail = newNode;
        }

        ++size;

    }

    @Override
    public void insertAtIndex(int index, Object data) {

    }

    @Override
    public void deleteAtHead() {
        if (this.head !=null){
            if (this.head.getNext() == null && this.tail.getNext() == null){
                this.head = null;
                this.tail = null;
            }else {
                Node<T> oldHead = this.head;
                this.head = oldHead.getNext();
                this.head.setPrev(this.tail);
                this.tail.setNext(this.head);
                oldHead.setNext(null);
            }
        }
        --this.size;
    }

    @Override
    public void deleteAtTail() {

    }

    @Override
    public void deleteAtIndex(int index) {

    }


}
