/**
 * PRELIM INDIVIDUAL PROJECT TASK 6
 * NAME: Jasmin, Ramon Emmiel P.
 */
package prelim;

import java.util.*;

/**
 * A circular doubly linked list implementation.
 *
 * @param <T> The type of elements stored in the list.
 */
public class MyDoublyLinkedCircularList<T> implements LinkedListInterface {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Initializes an empty circular doubly linked list.
     */
    public MyDoublyLinkedCircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Gets the head node of the linked list.
     *
     * @return The head node.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Gets the tail node of the linked list.
     *
     * @return The tail node.
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Gets the size of the linked list.
     *
     * @return The size of the linked list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Retrieves a node at a specific index.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     * @throws NoSuchElementException If the index is out of bounds.
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
     * Retrieves a node with a specific data value.
     *
     * @param data The data value to search for.
     * @return The node with the specified data.
     * @throws NoSuchElementException If the data is not found.
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
     * Searches for the index of a specific data value.
     *
     * @param data The data value to search for.
     * @return The index of the data value, or -1 if not found.
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
     * Inserts a new node at the head of the linked list.
     *
     * @param data The data to be inserted.
     */
    @Override
    public void insertAtHead(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
        } else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.head.setPrev(newNode);
            this.tail.setNext(newNode);
            this.head = newNode;
        }

        ++size;
    }

    /**
     * Inserts a new node at the tail of the linked list.
     *
     * @param data The data to be inserted.
     */
    @Override
    public void insertAtTail(Object data) {
        Node<T> newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
        } else {
            newNode.setNext(this.head);
            newNode.setPrev(this.tail);
            this.head.setPrev(newNode);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        ++size;
    }

    /**
     * Inserts a new node at the specified index of the linked list.
     *
     * @param index The index at which to insert the data.
     * @param data  The data to be inserted.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    @Override
    public void insertAtIndex(int index, Object data) throws IndexOutOfBoundsException {
        Node<T> newNode = new Node(data);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.head.setPrev(this.tail);
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
                curr.getNext().setPrev(newNode);
                newNode.setPrev(curr);
                curr.setNext(newNode);

                ++this.size;
            }
        }
    }

    /**
     * Deletes the node at the head of the linked list.
     */
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

    /**
     * Deletes the node at the tail of the linked list.
     */
    @Override
    public void deleteAtTail() {
        if (this.head != null) {
            if (this.head.getNext() == this.head) {
                this.head = null;
                this.tail = null;
            } else {
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

    /**
     * Deletes the node at the specified index of the linked list.
     *
     * @param index The index of the node to delete.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    @Override
    public void deleteAtIndex(int index) throws IndexOutOfBoundsException {
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

                while (counter != index) {
                    curr = curr.getNext();
                    ++counter;
                }

                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());
                --this.size;
            }
        }
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return A string representation of the linked list.
     */
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
