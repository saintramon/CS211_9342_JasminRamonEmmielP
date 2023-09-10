package prelim;

import java.util.*;

public class MyDoublyLinkedList<T> implements LinkedListInterface {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDoublyLinkedList(){
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
    public Node<T> getElement(int index) throws NoSuchElementException{
        Node<T> curr = this.head;
        int counter = 0;

        while (counter != index){
            curr = curr.getNext();
        }

        if (curr == null){
            throw new NoSuchElementException();
        }

        return curr;
    }
    @Override
    public Node<T> getElement(Object data) throws NoSuchElementException{
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
        return 0;
    }

    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setPrev(null);
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
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
        }else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;
        }

        ++size;
    }

    @Override
    public void insertAtIndex(int index, Object data) {
        Node<T> newNode = new Node(data);

        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            ++size;
            return;
        }

        if (index == 0){
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            newNode.setPrev(null);
            this.head = newNode;
            ++size;
            return;
        }



        if (index == this.size-1){
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;
            ++size;
            return;
        }

        Node<T> curr = this.head;
        int counter = 0;

        while (counter != index){
            curr = curr.getNext();
            ++counter;
        }

        newNode.setNext(curr);
        newNode.setPrev(curr.getPrev());
        curr.getPrev().setNext(newNode);
        curr.setPrev(newNode);

        ++size;
    }

    @Override
    public void deleteAtHead() {
        if (this.head != null){
            Node<T> oldHead = this.head;
            this.head = this.head.getNext();
            this.head.setPrev(null);
            oldHead.setNext(null);
            --this.size;
        }
    }

    @Override
    public void deleteAtTail() {
        if (this.head != null){
            Node<T> oldTail = this.tail;
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            oldTail.setPrev(null);
            --this.size;
        }
    }

    @Override
    public void deleteAtIndex(int index) {
        Node<T> curr = this.head;

        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            Node<T> oldHead = this.head;
            this.head = this.head.getNext();
            this.head.setPrev(null);
            oldHead.setNext(null);
            --this.size;
            return;
        }

        if (index == this.size - 1){
            Node<T> oldTail = this.tail;
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            oldTail.setPrev(null);
            --this.size;
        }

        int counter = 0;

        while (counter != index){
            curr = curr.getNext();
            counter++;
        }

        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());

        --size;
    }

    @Override
    public String toString() {
        String s = "";
        Node<T> curr = this.head;

        s+= "null <-> ";

        while (curr != null){
            s += curr.toString() + " <-> ";
            curr = curr.getNext();
        }

        s+= "null";

        return s;
    }
}
