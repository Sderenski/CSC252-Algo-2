package algo.data.structures.BinaryTree;


import static org.junit.Assert.assertEquals;

public class TestingBST {

    public static void main(String[] args){
        issuesCode();


    }

    private static void myTests(){
        BinarySearchTree<Integer> bST = new BinarySearchTree<>();
        // Max Height of 5
        bST.add(32);
        bST.add(21);
        bST.add(11);
        bST.add(2);
        bST.add(765);
        bST.add(435);
        bST.add(785);
        bST.add(87);
        bST.add(56);
        bST.add(98);
        bST.add(542);
        bST.add(476);
        bST.add(486);
        System.out.println("Count of Nodes: " + bST.count());
        System.out.println("InOrder: " + bST.inorder());
        System.out.println("ToArray-inOrder: ");
        Object[] bSTint = bST.toArray();
        for (var ele : bSTint) {
            System.out.print(ele + " ");
        }
        System.out.println();

        System.out.println("PreOrder: " + bST.preorder());
        System.out.println("PostOrder: " + bST.postorder());

        System.out.println("Contains 435: " + bST.contains(435));
        System.out.println("Contains 3213: " + bST.contains(3213));

        System.out.println("Height of Tree: " + bST.height());

        System.out.println("Before 435 was removed: " + bST.inorder());
        bST.remove(87);
        System.out.println("After 435 was removed: " + bST.inorder());
    }


    private static void issuesCode(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);
        System.out.println("Inorder Printout: " + bst.inorder());

        bst.remove(1337);

        System.out.println("After RM Inorder Printout: " + bst.inorder());

        System.out.println("Expected Count: " + expectedCount);
        System.out.println("Actual Count: " + bst.count());

    }
}
