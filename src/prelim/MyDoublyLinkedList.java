/**
 * PRELIM INDIVIDUAL PROJECT TASK 4
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

public class MyDoublyLinkedList<T> implements LinkedListInterface {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * This constructor creates a doubly linked list object that sets its head and tail to null, size to 0.
     */
    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This method returns the current head of the linked list.
     * @return The head node of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * This method returns the current tail of the linked list.
     * @return The tail node of the linked list
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * This method returns the current size of the linked list.
     * @return The size of the linked list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * This method sets the head of the linked list.
     * @param head The new head node
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * This method sets the tail of the linked list.
     * @param tail The new tail node
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    /**
     * This method returns true if the linked list has no element, false otherwise.
     * @return True if the linked list is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * This method returns the node of the linked list at the chosen index.
     * @param index The index of the element to retrieve
     * @return The node at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
    @Override
    public Node<T> getElement(int index) throws NoSuchElementException {
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

    /**
     * This method returns the node of the linked list at the inputted object, returns null if invalid.
     * @param data The data of the element to retrieve
     * @return The node with the specified data
     * @throws NoSuchElementException if the element with the data is not found
     */
    @Override
    public Node<T> getElement(Object data) throws NoSuchElementException {
        Node<T> curr = this.head;

        while (curr != null) {
            if (curr.getData().equals(data)) {
                return curr;
            }
            curr = curr.getNext();
        }

        throw new NoSuchElementException();
    }

    /**
     * This method returns the index of the object to be searched, returns -1 if not found.
     * @param data The data of the element to search for
     * @return The index of the element with the specified data, or -1 if not found
     */
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

    /**
     * This method inserts a new node at the head of the linked list.
     * @param data The data of the element to be inserted
     */
    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(null);
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }

        ++size;
    }

    /**
     * This method inserts a new node at the tail of the linked list.
     * @param data The data of the element to be inserted
     */
    @Override
    public void insertAtTail(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;
        }

        ++size;
    }

    /**
     * This method inserts a new node at the chosen index of the linked list.
     * @param index The index at which to insert the element
     * @param data The data of the element to be inserted
     */
    @Override
    public void insertAtIndex(int index, Object data) {
        Node<T> newNode = new Node(data);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            ++size;
            return;
        }

        if (index == 0) {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            newNode.setPrev(null);
            this.head = newNode;
            ++size;
            return;
        }

        if (index == this.size) {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            newNode.setNext(null);
            this.tail = newNode;
            ++size;
            return;
        }

        Node<T> curr = this.head;
        int counter = 0;

        while (counter != index) {
            curr = curr.getNext();
            ++counter;
        }

        newNode.setNext(curr);
        newNode.setPrev(curr.getPrev());
        curr.getPrev().setNext(newNode);
        curr.setPrev(newNode);

        ++size;
    }

    /**
     * This method deletes the current head and sets a new head for the linked list.
     */
    @Override
    public void deleteAtHead() {
        if (this.head != null) {
            if (this.head.getNext() == null && this.tail.getPrev() == null) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> oldHead = this.head;
                this.head = this.head.getNext();
                this.head.setPrev(null);
                oldHead.setNext(null);
            }
        }
        --this.size;
    }

    /**
     * This method deletes the current tail and sets a new tail for the linked list.
     */
    @Override
    public void deleteAtTail() {
        if (this.head != null) {
            if (this.head.getNext() == null && this.head.getPrev() == null) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> oldTail = this.tail;
                this.tail = this.tail.getPrev();
                this.tail.setNext(null);
                oldTail.setPrev(null);
            }
            --this.size;
        }
    }

    /**
     * This method deletes a node at the specified index.
     * @param index The index of the element to be deleted
     */
    @Override
    public void deleteAtIndex(int index) {
        Node<T> curr = this.head;

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> oldHead = this.head;
            this.head = this.head.getNext();
            this.head.setPrev(null);
            oldHead.setNext(null);
            --this.size;
            return;
        }

        if (index == this.size - 1) {
            Node<T> oldTail = this.tail;
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            oldTail.setPrev(null);
            --this.size;
        }

        int counter = 0;

        while (counter != index) {
            curr = curr.getNext();
            counter++;
        }

        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());

        --size;
    }

    /**
     * This method returns a visual representation of the linked list.
     * @return A string representation of the linked list
     */
    @Override
    public String toString() {
        String s = "";
        Node<T> curr = this.head;

        s += "null <-> ";

        while (curr != null) {
            s += curr.toString() + " <-> ";
            curr = curr.getNext();
        }

        s += "null";

        return s;
    }
}
