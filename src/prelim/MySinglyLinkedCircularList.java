package prelim;

import java.util.NoSuchElementException;

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
        Node<T> curr = this.head;
        int counter = 0;

        while (counter != index){
            curr = curr.getNext();
            ++counter;
        }

        if (curr == null){
            throw new NoSuchElementException();
        }

        return curr;
    }

    @Override
    public Object getElement(Object data) {
        Node<T> curr = this.head;

        while (curr != null){
            if (curr.getData().equals(data)){
                return curr;
            }
            curr = curr.getNext();
        }

        throw new NoSuchElementException();
    }

    @Override
    public int search(Object data) {
        Node<T> curr = this.head;

        for (int i = 0; i < this.size; i++){
            if (curr.getData().equals(data)){
                return i;
            }
            curr = curr.getNext();
        }

        return -1;
    }

    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(this.head);
        }else {
            newNode.setNext(this.head);
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
            this.tail.setNext(this.head);
        }else {
            this.tail.setNext(newNode);
            newNode.setNext(this.head);
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
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else {
                Node<T> oldHead = this.head;
                this.head = oldHead.getNext();
                this.tail.setNext(this.head);
                oldHead.setNext(null);
            }
        }
        --this.size;
    }

    @Override
    public void deleteAtTail() {
        if (this.head != null){
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else {
                Node<T> curr = this.head;
                while (curr.getNext() != this.tail){
                    curr = curr.getNext();
                }
                curr.setNext(this.head);
                this.tail = curr;
            }
        }
        --this.size;
    }

    @Override
    public void deleteAtIndex(int index) {

    }


}
