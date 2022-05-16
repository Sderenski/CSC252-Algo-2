package algo.data.structures.LinkedLists;

public class Node<T> {
    private T data;
    protected Node<T> next;
    protected Node<T> prev;

    public Node(T val){
        this.data = val;
    }

    public T getData(){
        return this.data;
    }
}
