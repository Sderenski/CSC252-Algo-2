package algo.data.structures.PriorityQueue;

import javafx.util.Pair;

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

    // Issue, there a 20 wasn't added to the top of the list....
    // Let's try this recursively...
    public void add(T value){
        heapList.add(value);

        Comparable[] addedArr = toArray();

        resortAddV2(addedArr, addedArr.length-1);

        heapList.clear();
        for (var obj : addedArr) heapList.add((T) obj);
    }

    private void resortAddV2(Comparable[] arr, int root) {
        // In here we are going to think of this like the remove method...
        // Math Operators
        int i = root + 1;
        int j = (i / 2) - 1;

        // Conditionals
        if(j >= 0){
            if(arr[root].compareTo(arr[j]) > 0){
                swapLogic(arr, root, j);
                resortAddV2(arr, j);
            }
        }
    }

    // Might break this up? Maybe not depending on what happens with the rest of this....
    private void swapLogic(Comparable[] list, int i, int j) {
        Comparable tempValue = list[j];
        list[j] = list[i];
        list[i] = tempValue;
    }

//    private void sizeSmall(Comparable[] list){
//        if(heapList.size() > 2) {
//            if(heapList.get(2).compareTo(heapList.get(1)) > 0 && heapList.get(2).compareTo(heapList.get(0)) > 0) swapLogic(list, 2, 0);
//            else if (heapList.get(1).compareTo(heapList.get(2)) < 0 && heapList.get(1).compareTo(heapList.get(0)) > 0) swapLogic(list, 1, 0);
//        }
//        if (heapList.size() > 1) {
//            if (heapList.get(1).compareTo(heapList.get(0)) > 0) swapLogic(list, 1, 0);
//        }
//    }

    public T peek() {
        return heapList.get(0);
    }


    // TODO Implement the remove functions for the class object......
    // Return the removed node
    public void remove() {
        // Swap the first and last nodes first and reduce the size of the array
        // Have to turn it into an array list first then go from there
        Comparable[] initArr = toArray();
        swapLogic(initArr, 0, (initArr.length-1));

        // Next Step:
        // remove the last element in the list
        Comparable removedNode = initArr[initArr.length-1];
        heapList.clear();
        for (var obj : initArr) heapList.add((T) obj);

        heapList.remove(heapList.size()-1);
        Comparable[] reducedArr = toArray();

        // Time to shuffle the nodes around....
        // This will be recursive to go where the root node is
        resortRm(reducedArr, 0);
        heapList.clear();
        for (var obj : reducedArr) heapList.add((T) obj);
    }

    private void resortRm(Comparable[] arr, int root) {
        // Math Comparing/Operations
        int i = root + 1;
        int jL = (2 * i) - 1;
        int jR = (2 * i);

        // Starts at the root
        // Grab both of the nodes if they EXIST
        // Then compare them together, finally to the root node.
        // Swap from there.
        if(jR < arr.length){
            if(arr[jR].compareTo(arr[jL]) > 0 && arr[jR].compareTo(arr[root]) > 0){
                swapLogic(arr, root, jR);
                resortRm(arr, jR);
            } else if(arr[jL].compareTo(arr[jR]) > 0 && arr[jL].compareTo(arr[root]) > 0){
                swapLogic(arr, root, jL);
                resortRm(arr, jL);
            }
        } else if (jL < arr.length) {
            if(arr[jL].compareTo(arr[root]) > 0) {
                swapLogic(arr, root, jL);
            }
        } else {
            return;
        }
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
