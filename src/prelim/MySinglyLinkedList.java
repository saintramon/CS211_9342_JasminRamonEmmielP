/**
 * PRELIM INDIVIDUAL PROJECT TASK 3
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements LinkedListInterface {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * This method creates a linked list that sets the size to 0, head node to null, and tail node to null.
     */
    public MySinglyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns the head of the linked list.
     * @return
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * This method returns the tail of the linked list.
     * @return
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * This method sets the head of the linked list.
     * @param head
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * This method sets the tail of the linked list.
     * @param tail
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    /**
     * This method returns the size of the linked list.
     * @return
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * This method returns true if the linked list has no nodes, false otherwise.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * This method returns as node of the linked list based on the given index.
     * @param index
     * @return
     */
    @Override
    public Node<T> getElement(int index) {
        int currCounter = 0;
        Node<T> curr = this.head;

        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        while (currCounter != index){
            curr = curr.getNext();
            currCounter++;
        }

        if (curr == null){
            throw new NoSuchElementException();
        }

        return curr;
    }

    /**
     * This method returns a Node of the linked list in accordance to the inputted object.
     * @param data
     * @return
     */
    @Override
    public Node<T> getElement(Object data) throws NoSuchElementException {
        Node<T> curr = this.head;

        while (curr != null){
            if (curr.getData().equals(data)){
                return curr;
            }
            curr = curr.getNext();
        }

        throw new NoSuchElementException();
    }

    /**
     * This method returns the index of the key node if it is in the linked list, returns -1 if not found.
     * @param data
     * @return
     */
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

    /**
     * This method inserts a new node at the head of the linked list.
     * @param data
     */
    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * This method inserts a node at the tail of the linked list.
     * @param data
     */
    @Override
    public void insertAtTail(Object data) {
        Node<T> newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * This method inserts a node at the chosen index of the user.
     * @param index
     * @param data
     */
    @Override
    public void insertAtIndex(int index, Object data) {
        Node<T> newNode = new Node(data);

        if (index == 0){
            newNode.setNext(this.head);
            this.head = newNode;

            if (this.tail == null){
                this.tail = newNode;
            }

            ++size;
        }

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            ++size;
        }else {
            Node<T> curr = this.head;
            int counter = 0;

            while (counter + 1 != index){
                curr = curr.getNext();
                counter++;
            }

            if (curr == null){
                throw new IndexOutOfBoundsException();
            }

            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            ++size;

            if (newNode.getNext() == null){
                this.tail = newNode;
            }
        }
    }

    /**
     * This method deletes the head of the linked list and assigns the next node of the previous head as the head of the linked list.
     */
    @Override
    public void deleteAtHead() {
        if (this.head != null){
            Node<T> oldHead = this.head;
            this.head = this.head.getNext();
            oldHead.setNext(null);
            --this.size;
        }
    }

    /**
     * This method deletes the tail of the linked list and assigns the previous node as the new tail of the linked list.
     */
    @Override
    public void deleteAtTail() {
        Node<T> curr = this.head;

        if (this.head != null){
            while (curr.getNext().getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(null);
            this.tail = curr;
            --this.size;
        }
    }

    /**
     * This method deletes a node at the chosen index of the user.
     * @param index
     */
    @Override
    public void deleteAtIndex(int index) {
        Node<T> curr = this.head;
        int counter = 0;

        if (index == 0){
            this.head = this.head.getNext();
            if (this.size == 1){
                this.tail = null;
            }
            return;
        }

        while (counter + 1 != index){
            curr = curr.getNext();
            counter++;
        }

        curr.setNext(curr.getNext().getNext());

        if (curr.getNext() == null){
            this.tail = curr;
        }

        --size;
    }

    /**
     * This method returns a String representation of the linked list.
     * @return
     */
    public String toString(){
        String s = "";
        Node<T> curr = this.head;

        while (curr != null){
            s += curr.toString() + " -> ";
            curr = curr.getNext();
        }

        s+= "null";

        return s;
    }
}
