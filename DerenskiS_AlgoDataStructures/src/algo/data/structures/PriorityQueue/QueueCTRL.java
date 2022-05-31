package algo.data.structures.PriorityQueue;

public class QueueCTRL {

    MaxHeapPriorityQueue<Integer> max = new MaxHeapPriorityQueue<>();

    public void run() {
        max.add(4);
        max.add(8);
        max.add(6);
        max.add(1);
        max.add(2);
        max.add(3);
//        max.add(9);
//        max.add(6);
//        max.add(8);
//        max.add(3);
//        max.add(2);
//        max.add(5);
//        max.add(4);
//        max.add(1);
//        max.add(2);
//        max.add(1);


        displayHeapArry();
        System.out.println("The Sorted List Decreasing: ");
        Object[] arr = max.toSortedArray();
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        max.add(20);
        System.out.println("\n\nAdding num 20: ");
        displayHeapArry();

        int removed = max.remove();
        System.out.println("\n\nAfter Removing the root node:");
        displayHeapArry();
        System.out.println("\n" + removed);

    }


    private void displayHeapArry() {
        System.out.println("The Heap Array: ");
        for(var ele : max.heapList){
            System.out.print(ele + ", ");
        }
        System.out.println();
    }
}
