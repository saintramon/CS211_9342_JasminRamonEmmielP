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
        Node newNode = new Node(data);

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
            Node curr = this.head;
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

    @Override
    public void deleteAtHead() {
        if (this.head != null){
            Node oldHead = this.head;
            this.head = this.head.getNext();
            oldHead.setNext(null);
            --this.size;
        }
    }

    @Override
    public void deleteAtTail() {
        Node curr = this.head;

        if (this.head != null){
            while (curr.getNext().getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(null);
            this.tail = curr;
            --this.size;
        }
    }

    @Override
    public void deleteAtIndex(int index) {
        Node curr = this.head;
        int counter = 0;

        if (index == 0){
            this.head = this.head.getNext();
            if (this.size == 1){
                this.tail = null;
            }
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

    public String toString(){
        String s = "";
        Node curr = this.head;

        while (curr != null){
            s += curr.toString() + "->";
            curr = curr.getNext();
        }

        s+= "null";

        return s;
    }
}
