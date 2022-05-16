package algo.data.structures.BinaryTree;

public class Node<T> {
    private T data;
    protected Node<T> prev;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T val){
        this.data = val;
    }

    public T getData() { return this.data; }
}
