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
    public Node<T> getElement(int index) {
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
    public Node<T> getElement(Object data) {
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
        Node<T> newNode = new Node(data);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }else {
            if (index == 0){
                insertAtHead(data);
            } else if (index == this.size) {
                insertAtTail(data);
            }else {
                Node<T> curr = this.head;
                int counter = 0;

                while (counter < index - 1){
                    curr = curr.getNext();
                    ++counter;
                }
                //NEEDS FIXING
                newNode.setNext(curr.getNext());
                curr.setNext(newNode);
                curr.getNext().setPrev(newNode);
                newNode.setPrev(curr);
            }
        }

        ++size;
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
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Your chosen index is not within range of the linked list size");
        }

        if (this.head != null){
            if (index == 0){
                deleteAtHead();
            } else if (index == this.size - 1) {
                deleteAtTail();
            }else {
                Node<T> curr = this.head;
            }
        }
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
