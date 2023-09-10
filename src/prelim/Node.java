package prelim;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(){
        this.data = null;
        this.next = null;
        this.prev = null;
     }
     public Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
     }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
