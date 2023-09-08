package prelim;

public class MySinglyLinkedList<T> implements LinkedListInterface {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MySinglyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insertAtHead(Object data) {
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void insertAtTail(Object data) {
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void insertAtIndex(int index, Object data) {

    }

    @Override
    public void deleteAtHead() {
        this.head = this.head.getNext();
        --this.size;
    }

    @Override
    public void deleteAtTail() {
        Node curr = this.head;

        while (curr.getNext().getNext() != null){
            curr = curr.getNext();
        }

        curr.setNext(null);
        this.tail = curr;
        --this.size;
    }

    @Override
    public void deleteAtIndex(int index) {

    }

    public String toString(){
        String s = "";
        Node curr = this.head;

        while (curr != null){
            s += curr.toString() + "->";
        }

        s+= "->" + "null";

        return s;
    }
}
