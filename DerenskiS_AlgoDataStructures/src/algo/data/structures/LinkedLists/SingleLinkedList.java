package algo.data.structures.LinkedLists;

public class SingleLinkedList<T> extends LinkedLists<T> {


    public void add(T val){
        // Add a new node with data = val
        // Add it to the list?
        Node<T> newNode = new Node<T>(val);

        // Do an edge case for the head
        if(head == null) {
            head = newNode;
            return;
        }
        var current = getLastNode();
        current.next = newNode;
    }

    public void insert(T val, int index){
        if(head != null) {
            Node<T> newNode = new Node<T>(val);
            var current = head;

            // Testing for edge cases

            if (index >= 0 && index < count()) {

                // Verifying that the index is 0 or higher
                if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    Node<T> prevNode = null;
                    int counter = 0;
                    while (current.next != null) {
                        if (counter == index - 1) {
                            prevNode = current;
                        } else if (counter == index) {
                            break;
                        }
                        counter++;
                        current = current.next;
                    }
                    prevNode.next = newNode;
                    newNode.next = current;
                }
            } else {
                // Throw in Index out of Bounds error when the index is higher than count or smaller than 0
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public T get(int index) {
        if(head != null) {
            if(index >= 0 && index < count()) {
                var current = head;
                int counter = 0;
                // Traverse to the last node
                while (current.next != null) {
                    if (counter == index) {
                        break;
                    }
                    current = current.next;
                    counter++;
                }
                return current.getData();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    // Add a conditional for when the index is at zero
    public T removeAt(int index){
        if(head != null){
            if(index >= 0 && index < count()) {
                if(index == 0){
                    return remove();
                } else {
                    var current = head;
                    int counter = 0;
                    Node<T> prevNode = null;
                    // Traverse to the last node
                    while (current.next != null) {
                        if (counter == index - 1) {
                            prevNode = current;
                        } else if (counter == index) {
                            break;
                        }
                        current = current.next;
                        counter++;
                    }
                    prevNode.next = current.next;
                    return current.getData();
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    public T removeLast() {
        if(head != null){
            var current = head;
            int counter = 0;
            // Traverse to the last node
            while(current.next != null) {
                if(counter == count() - 2){
                    break;
                }
                current = current.next;
                counter++;
            }
            var returnData = current.next.getData();
            current.next = null;
            return returnData;
        }
        return null;
    }

    public void clear(){
        this.head = null;
    }

    // Loops though the Nodes to the last index
    private Node<T> getLastNode() {
        var current = head;

        // Traverse to the last node
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }
}
