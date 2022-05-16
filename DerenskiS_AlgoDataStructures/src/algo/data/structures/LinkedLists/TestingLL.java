package algo.data.structures.LinkedLists;

import java.util.Random;

public class TestingLL {

    public static void main(String[] args){

        // Single Linked List Works, Time to take it to the Doubly Linked List
//        singleTests();

        // Double Linked List Tests
        doubleTests();
    }

    private static void singleTests(){
        SingleLinkedList<Integer> mySLL = new SingleLinkedList<>();
        Random ran = new Random();
        for(int i = 0; i < 15; i++){
            mySLL.add(ran.nextInt(18));
        }
        mySLL.insert(100, 1);
        System.out.println("Before the clear Function: " + mySLL);
        System.out.println("Count: " + mySLL.count());

        System.out.println("Position of val 100: " + mySLL.search(100));
        System.out.println("The value at index 7: " + mySLL.get(0));
        var rmData = mySLL.remove();
        System.out.println("RmData: " + rmData);
        System.out.println("After the remove: " + mySLL);
        var rmDataLast = mySLL.removeLast();
        System.out.println("RmDataLast: " + rmDataLast);
        System.out.println("After the last remove: " + mySLL);
        var rmDataAt = mySLL.removeAt(8);
        System.out.println("RmDataAt: " + rmDataAt);
        System.out.println("After the remove at 8: " + mySLL);


        mySLL.clear();
        System.out.println("After the clear Function: " + mySLL);
        System.out.println("Count: " + mySLL.count());
    }

    private static void doubleTests(){
        DoubleLinkedList<Integer> myDLL = new DoubleLinkedList<>();
        Random ran = new Random();
        System.out.println("OG Double Array: ");
        for(int i = 0; i < 15; i++){
            int inNum = ran.nextInt(56);
            System.out.print(inNum + " ");
            myDLL.add(inNum);
        }
        System.out.println();
        myDLL.insert(100, 3);
        System.out.println("Before the clear Function: " + myDLL);
        System.out.println("Count: " + myDLL.count());

        System.out.println("Position of val 100: " + myDLL.search(100));
        System.out.println("The value at index 7: " + myDLL.get(6));
        var rmData = myDLL.remove();
        System.out.println("RmData: " + rmData);
        System.out.println("After the remove: " + myDLL);
        var rmDataLast = myDLL.removeLast();
        System.out.println("RmDataLast: " + rmDataLast);
        System.out.println("After the last remove: " + myDLL);
        var rmDataAt = myDLL.removeAt(8);
        System.out.println("RmDataAt: " + rmDataAt);
        System.out.println("After the remove at 8: " + myDLL);


        myDLL.clear();
        System.out.println("After the clear Function: " + myDLL);
        System.out.println("Count: " + myDLL.count());
    }


}
