package prelim;

import javax.print.attribute.standard.Sides;
import java.util.NoSuchElementException;

public class MyDoublyLinkedCircularList<T> implements LinkedListInterface{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDoublyLinkedCircularList(){
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

    @Override
    public int getSize() {
        return size;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Object getElement(int index) {
        Node<T> curr = this.head;
        int counter = 0;

        while (counter != index) {
            curr = curr.getNext();
            ++counter;
        }

        if (curr == null) {
            throw new NoSuchElementException();
        }

        return curr;
    }

    @Override
    public Object getElement(Object data) {
        Node<T> curr = this.head;

        while (curr != null) {
            if (curr.getData().equals(data)) {
                return curr;
            }
            curr = curr.getNext();
        }

        throw new NoSuchElementException();
    }

    @Override
    public int search(Object data) {
        Node<T> curr = this.head;

        for (int i = 0; i < this.size; i++) {
            if (curr.getData().equals(data)) {
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
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
        }else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.head.setPrev(newNode);
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
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
        }else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.head.setPrev(newNode);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        ++size;
    }

    @Override
    public void insertAtIndex(int index, Object data) {

    }

    @Override
    public void deleteAtHead() {
        if (this.head != null) {
            if (this.head.getNext() == this.head) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> oldHead = this.head;
                this.head = oldHead.getNext();
                this.head.setPrev(this.tail);
                this.tail.setNext(this.head);
                oldHead.setNext(null);
                oldHead.setPrev(null);
            }
            --this.size;
        }
    }

    @Override
    public void deleteAtTail() {
        if (this.head != null){
            if (this.head.getNext() == this.head){
                this.head = null;
                this.tail = null;
            }else {
                Node<T> oldTail = this.tail;
                this.tail = this.tail.getPrev();
                this.tail.setNext(this.head);
                this.head.setPrev(this.tail);
                oldTail.setNext(null);
                oldTail.setPrev(null);
            }
            --this.size;
        }
    }

    @Override
    public void deleteAtIndex(int index) {

    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "Empty Doubly Circular Linked List";
        }

        StringBuilder result = new StringBuilder("...<->");
        Node<T> current = this.head;

        boolean firstNode = true;

        do {
            if (firstNode) {
                result.append("HEAD: ");
                firstNode = false;
            } else if (current == this.tail) {
                result.append("TAIL: ");
            }

            result.append(current.getData().toString());

            if (current != this.tail) {
                result.append(" <-> ");
            }

            current = current.getNext();
        } while (current != this.head);

        result.append("<->...");

        return result.toString();
    }
}
