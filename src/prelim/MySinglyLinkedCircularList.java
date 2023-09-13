/**
 * PRELIM INDIVIDUAL PROJECT TASK 5
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.NoSuchElementException;

public class MySinglyLinkedCircularList<T> implements LinkedListInterface {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    /**
     * This constructor creates a new singly circular linked list that sets the head and tail to null, and size to 0
     */
    public MySinglyLinkedCircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This method returns the current head of the linked list
     * @return The head node of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * This method returns the current tail of the linked list
     * @return The tail node of the linked list
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * This method returns the size of the linked list
     * @return The size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the head of the linked list to the specified node
     * @param head The new head node
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Sets the tail of the linked list to the specified node
     * @param tail The new tail node
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    /**
     * Checks if the linked list is empty
     * @return True if the linked list is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * This method retrieves an element at the specified index in the linked list
     * @param index The index of the element to retrieve
     * @return The element at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
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

    /**
     * This method retrieves the first occurrence of an element with the given data in the linked list
     * @param data The data of the element to retrieve
     * @return The element with the specified data
     * @throws NoSuchElementException if the element with the data is not found
     */
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

    /**
     * This method searches for the index of the first occurrence of an element with the given data in the linked list
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
     * Inserts an element at the head of the linked list
     * @param data The data of the element to be inserted
     */
    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(this.head);
        } else {
            newNode.setNext(this.head);
            this.tail.setNext(newNode);
            this.head = newNode;
        }

        ++size;
    }

    /**
     * Inserts an element at the tail of the linked list
     * @param data The data of the element to be inserted
     */
    @Override
    public void insertAtTail(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(this.head);
        } else {
            this.tail.setNext(newNode);
            newNode.setNext(this.head);
            this.tail = newNode;
        }

        ++size;
    }

    /**
     * Inserts an element at the specified index in the linked list
     * @param index The index at which to insert the element
     * @param data The data of the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void insertAtIndex(int index, Object data) {
        Node<T> newNode = new Node(data);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Your chosen index is not within range of the linked list size");
        }

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(this.head);
        } else {
            if (index == 0) {
                insertAtHead(data);
            } else if (index == this.size) {
                insertAtTail(data);
            } else {
                Node<T> curr = this.head;
                int counter = 0;

                while (counter < index - 1) {
                    curr = curr.getNext();
                    ++counter;
                }

                newNode.setNext(curr.getNext());
                curr.setNext(newNode);
            }
        }

        ++size;
    }

    /**
     * Deletes the element at the head of the linked list
     */
    @Override
    public void deleteAtHead() {
        if (this.head != null) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> oldHead = this.head;
                this.head = oldHead.getNext();
                this.tail.setNext(this.head);
                oldHead.setNext(null);
            }
        }
        --this.size;
    }

    /**
     * Deletes the element at the tail of the linked list
     */
    @Override
    public void deleteAtTail() {
        if (this.head != null) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                Node<T> curr = this.head;
                while (curr.getNext() != this.tail) {
                    curr = curr.getNext();
                }
                curr.setNext(this.head);
                this.tail = curr;
            }
        }
        --this.size;
    }

    /**
     * Deletes the element at the specified index in the linked list
     * @param index The index of the element to be deleted
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Your chosen index is not within range of the linked list size");
        }

        if (this.head != null) {
            if (index == 0) {
                deleteAtHead();
            } else if (index == this.size - 1) {
                deleteAtTail();
            } else {
                Node<T> curr = this.head;
                int counter = 0;

                while (counter < index - 1) {
                    curr = curr.getNext();
                    ++counter;
                }

                curr.setNext(curr.getNext().getNext());
            }
        }
        --size;
    }

    /**
     * This method generates a string representation of the linked list
     * @return A string representation of the linked list
     */
    @Override
    public String toString() {
        Node<T> curr = this.head;

        if (isEmpty()) {
            return "Empty List";
        }

        String result = "";

        result += "HEAD: " + this.head.toString() + " --> ";
        curr = curr.getNext();

        while (curr != this.head) {
            if (curr == this.tail) {
                result += "TAIL: " + curr.toString() + " --> ";
                break;
            } else {
                result += curr.toString() + " --> ";
                curr = curr.getNext();
            }
        }

        result += "HEAD: " + this.head.toString() + " --> ...";

        return result;
    }
}
