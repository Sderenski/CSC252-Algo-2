package algo.data.structures.BinaryTree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int height = 0;
    private int listCounter = 0;

    // -1 == Less than
    // 1 == greater than

    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (root != null) {
            transverse(newNode, root);
        } else {
            root = newNode;
        }
    }

    // Add Recurvise Transversal
    // Creating sub-trees
    private void transverse(Node<T> newNode, Node<T> root){
        // less
        if(newNode.getData().compareTo(root.getData()) == -1) {
            if (root.left == null){
                root.left = newNode;
                newNode.prev = root;
            } else {
                transverse(newNode, root.left);
            }
        } else if (newNode.getData().compareTo(root.getData()) >= 0){ // Greater
            if (root.right == null){
                root.right = newNode;
                newNode.prev = root;
            } else {
                transverse(newNode, root.right);
            }
        }
    }


    // Contains if a value is in it or not.
    public boolean contains(T val) {
        if(root != null){
            return contains(val, root);
        }
        return false;
    }

    private boolean contains(T val, Node<T> root){
        boolean result = false;
        if(val.compareTo(root.getData()) == 0){
            result = true;
        } else {
            // less
            if (val.compareTo(root.getData()) == -1 && root.left != null) {
                result = contains(val, root.left);
            } else if (val.compareTo(root.getData()) == 1 && root.right != null){
                result = contains(val, root.right);
            }
        }
        return result;
    }

    public void remove(T val) {
        if(root != null){
            removeTraV(root, val);
        } else if (count() == 1){
            root = null;
        }
    }

    private void removeTraV(Node<T> root, T val){
        if(val.compareTo(root.getData()) == 0){
            replaceLogic(root);
        } else{
            if(root.left != null && val.compareTo(root.getData()) == -1){
                removeTraV(root.left, val);
            } else if(root.right != null && val.compareTo(root.getData()) == 1){
                removeTraV(root.right, val);
            } else return;
        }
    }

    // TODO There is an issue with this is logic somewhere.... Why
    private void replaceLogic(Node<T> root){
        if(root.left == null && root.right == null){
            if(root.prev.left == root){
                root.prev.left = null;
            } else if (root.prev.right == root){
                root.prev.right = null;
            }
        } else if (root.left != null && root.right == null){
            root.prev = root.left;
        } else if (root.right != null && root.left == null){
            root.prev = root.right;
        } else {
            replaceLogicBoth(root);
        }
    }

    private void replaceLogicBoth(Node<T> root){
        Node<T> replace = leftMostReturn(root.right);
        if(replace.right != null) {
            replace.prev.left = replace.right;
            replace.right = root.right;
        }
        else if(replace != replace.prev.right) {
            replace.right = root.right;
            replace.prev.left = null;
        }
        if (root == this.root){
            replace.left = root.left;
            this.root = replace;
        } // Add a conditional
        else{
            if(root.prev.left == root){
                root.prev.left = replace;
            } else if (root.prev.right == root){
                root.prev.right = replace;
            }
            replace.left = root.left;
        }
    }

    private Node<T> leftMostReturn(Node<T> root){
        Node<T> current = null;
        if(root.left != null){
            current = leftMostReturn(root.left);
        } else{
            current = root;
        }
        return current;
    }

    public void clear() { root = null; }

    // Count Functions
    public int count(){
        if(root != null){
            return count(root);
        }
        return 0;
    }

    private int count(Node<T> root){
        int count = 0;
        if(root.left != null){
           count += count(root.left);
        }
        if (root.right != null){
            count += count(root.right);
        }
        return (count += 1);
    }

    public int height(){
        if(root != null) {
            int counter = 1;
            height(root, counter);
        }
        return height;
    }

    public void height(Node<T> root, int counter){
        if(root.left != null){
            height(root.left, (counter+1));
        }

        if (root.right != null){
            height(root.right, (counter+1));
        }
        if(counter > height){
            height = counter;
        }
    }

    public Object[] toArray(){
        Object[] result = new Object[count()];
        if(root != null){
            toArray(result, root);
        }
        return result;
    }

    // To keep track of where the index it, Might want to add a separate index to keep track
    // or return a smaller array back and add to the next on........ no Because the array is static not dynamic
    // What can I use to keep track.... Because I can pass the list as a reference......
    // PASS it as a reference and the counter for ittttttt
    private void toArray(Object[] array, Node<T> root){
        if(root.left != null){
            toArray(array,root.left);
        }
        array[listCounter] = root.getData();
        listCounter++;

        if (root.right != null){
            toArray(array,root.right);
        }
    }


    // Printing out as strings
    // l,root,r
    public String inorder(){
        if(root != null) {
            String result = inOrderTrV(root);
            return result.substring(0, result.length() - 2);
        }
        return "";
    }

    private String inOrderTrV(Node<T> root){
        String returnOrder = "";
        if(root.left != null){
            returnOrder += inOrderTrV(root.left);
        }
        returnOrder +=(root.getData()  + ", ");

        if (root.right != null){
            returnOrder += inOrderTrV(root.right);
        }

        return returnOrder;
    }

    // Root, L, R
    public String preorder() {
        if(root != null) {
            String result = preOrderTrV(root);
            return result.substring(0, result.length() - 2);
        }
        return "";
    }

    private String preOrderTrV(Node<T> root){
        String returnOrder = "";

        returnOrder +=(root.getData()  + ", ");

        if(root.left != null){
            returnOrder += preOrderTrV(root.left);
        }

        if (root.right != null){
            returnOrder += preOrderTrV(root.right);
        }

        return returnOrder;
    }

    // L, R, Root
    public String postorder() {
        if(root != null) {
            String result = postOrderTrV(root);
            return result.substring(0, result.length() - 2);
        }
        return "";
    }

    private String postOrderTrV(Node<T> root){
        String returnOrder = "";
        if(root.left != null){
            returnOrder += postOrderTrV(root.left);
        }

        if (root.right != null){
            returnOrder += postOrderTrV(root.right);
        }
        returnOrder +=(root.getData()  + ", ");

        return returnOrder;
    }
}
