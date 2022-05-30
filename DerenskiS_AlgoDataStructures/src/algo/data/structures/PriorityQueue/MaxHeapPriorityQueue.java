package algo.data.structures.PriorityQueue;

import java.util.ArrayList;

public class MaxHeapPriorityQueue<T extends Comparable<? super T>>{

    public ArrayList<T> heapList = new ArrayList<>();

    /*
        MATH PROPERTIES
            left child of node j is at [ 2j ]
            right child of node j is at [ 2j + 1 ]
            Parent of node j is at [ j / 2 ]

        Each time we add or remove, heapify the list. Meaning you have to resort it.
        Add to the list. Then call a resort function on it that goes top down...


        WHEN SORTING:
            1.) Insert the new element at last position in heap
            2.) Compare it with its parent and, if it violates heap condition, exchange them
            3.) Continue comparing the new element with nodes up the tree until the heap condition is satisfied
     */

    public void add(T value){
        heapList.add(value);
        resortAdd();
    }

    private void resortAdd(){
        // Fuck it lets try and do it iterately
        // Add a break point to stop to check the root....
        Comparable[] list = toArray();
        for(int i = heapList.size() - 1; i > -1; i--){
            System.out.println("i: " + i);
            System.out.println("Modulo i % 2: " + ( i % 2));
            if(i > 3) {
                if (i % 2 == 0) {
                    int j = i / 2;
                    if (heapList.get(i).compareTo(heapList.get(j)) > 0) {
                        swapLogic(list, i, j);
                    }
                } else {
                    int j = (i / 2) - 1;
                    if (heapList.get(i).compareTo(heapList.get(j)) > 0) {
                        swapLogic(list, i, j);
                    }
                }
            }
        }
        sizeSmall(list);
        heapList.clear();
        for (var obj : list) heapList.add((T) obj);
    }

    // Might break this up? Maybe not depending on what happens with the rest of this....
    private void swapLogic(Comparable[] list, int i, int j) {
        Comparable tempValue = list[j];
        list[j] = list[i];
        list[i] = tempValue;
    }

    private void sizeSmall(Comparable[] list){
        if(heapList.size() > 2) {
            if(heapList.get(2).compareTo(heapList.get(1)) > 0 && heapList.get(2).compareTo(heapList.get(0)) > 0) swapLogic(list, 2, 0);
            else if (heapList.get(1).compareTo(heapList.get(2)) < 0 && heapList.get(1).compareTo(heapList.get(0)) > 0) swapLogic(list, 1, 0);
        }
        if (heapList.size() > 1) {
            if (heapList.get(1).compareTo(heapList.get(0)) > 0) swapLogic(list, 1, 0);
        }
    }

    public T peek() {
        return heapList.get(0);
    }


    // TODO Implement the remove functions for the class object......
    public void remove() {

    }

    private void resortRm() {

    }

    public int count() {
        return heapList.size() - 1;
    }

    public Object[] toSortedArray() {
        Comparable[] sortedList = toArray();

        insertionSort(sortedList);
        reverseArray(sortedList);

        return sortedList;
    }

    private Comparable[] toArray(){
        Comparable[] arr = new Comparable[heapList.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = heapList.get(i);
        }
        return arr;
    }

    private void insertionSort(Comparable[] arr){
        for(int i = 1; i < arr.length; i++) {
            Comparable v = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(v) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = v;
        }
    }

    private void reverseArray(Comparable[] arr){
        for (int i = 0; i < (arr.length/2); i++) {
            Comparable temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
