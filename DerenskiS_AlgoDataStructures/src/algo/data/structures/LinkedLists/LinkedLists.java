package algo.data.structures.LinkedLists;

public class LinkedLists<T> {
    protected Node<T> head;


    public int count(){
        if(head != null) {
            var current = head;
            int counter = 1;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
                counter++;
            }
            return counter;
        }
        return 0;
    }

    public T remove(){
        if(head != null){
            var data = head.getData();
            head = head.next;
            return data;
        }
        return null;
    }

    public int search(T val){
        if(head != null) {
            var current = head;
            int counter = 0;
            // Traverse to the last node
            while (current.next != null) {
                if (current.getData() == val) {
                    return counter;
                }
                current = current.next;
                counter++;
            }
            if (current.getData() == val) {
                return counter;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public String toString() {
        String finalStr = "";
        if (head != null) {
            var current = head;
            finalStr = String.valueOf(head.getData());

            while (current.next != null) {
                current = current.next;
                finalStr = finalStr + ", " + current.getData();
            }
        }
        return finalStr;
    }
}
