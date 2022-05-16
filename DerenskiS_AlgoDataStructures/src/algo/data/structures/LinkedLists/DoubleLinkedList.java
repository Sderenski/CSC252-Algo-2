package algo.data.structures.LinkedLists;

public class DoubleLinkedList<T> extends LinkedLists<T> {

    // All the singly Linked List methods are done, Now how to apply them to the double....
    private Node<T> tail;

    public void add(T val){
        // Add a new node with data = val
        // Add it to the list?
        Node<T> newNode = new Node<T>(val);

        // Do an edge case for the head
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else if (count() == 1){
            tail = newNode;
            tail.prev = head;
            head.next = tail;
            return;
        }
        tail.next = newNode;
        Node<T> tailPre = tail;

        // Assigning the new tail with the new information...
        tail = tail.next;
        tail.prev = tailPre;
    }

    // Check for edge cases
    // If the index is under or above the halfway point
    // If above, Start from the tail
    // If below, Start from the head.
    public void insert(T val, int index){
        if(head != null){
            Node<T> newNode = new Node<>(val);
            if(index >= 0 && index < count()) {
                Node<T> prevNode = null;
                if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else if (index > count() / 2) {
                    // Tail Function
                    insertTail(newNode, index);
                } else {
                    // Head Function
                    insertHead(newNode, index);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public T get(int index){
        if(head != null){
            // Checking if the index is on the values.....
            if(index >= 0 && index < count()) {
                if(index > count()/2){
                    return getTail(index, 0).getData();
                } else{
                    return getHead(index).getData();
                }
            } else{
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    // Add a conditional for when the index is at zero
    public T removeAt(int index){
        if(head != null){
            if(index >= 0 && index < count()){
                if(index == 0){
                    var removed = getHead(index);
                    head = removed.next;
                    head.prev = null;
                    return removed.getData();
                } else if (index == count() - 1) {
                    var removed = getTail(index, 1);
                    tail = removed.prev;
                    tail.next = null;
                    return removed.getData();
                } else if(index > count() / 2){
                    var current = getTail(index, 1);
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return current.getData();
                } else{
                    var current = getHead(index);
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return current.getData();
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    public T removeLast(){
        if(head != null) {
            var current = tail;
            tail = tail.prev;
            tail.next = null;
            return current.getData();
        }
        return null;
    }

    public void clear(){
        head = null;
        tail = null;
    }


    // Helper Functions for the insert Function to break it up, logically...

    private void insertTail(Node<T> newNode, int index){
        var current = getTail(index, 1);
        newNode.prev = current.prev;
        newNode.next = current;
        newNode.prev.next = newNode;
        current.prev = newNode;
    }

    private void insertHead(Node<T> newNode, int index){
        var current = getHead(index);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
    }


    private Node<T> getTail(int index, int offset){
        if(index == (count() - 1)) {
            return tail;
        } else {
            var current = tail;
            int counter = count();
            while (current.prev != null) {
                if (counter == index + offset) {
                    break;
                }
                current = current.prev;
                counter--;
            }
            return current;
        }
    }

    private Node<T> getHead(int index){
        if(index == 0){
            return head;
        } else {
            var current = head;
            int counter = 0;
            while (current.next != null) {
                if (counter == index) {
                    break;
                }
                current = current.next;
                counter++;
            }
            return current;
        }
    }
}
