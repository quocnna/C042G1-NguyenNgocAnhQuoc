package _12_java_collection_framework.exercises;

public class DeleteNoteInBST<T extends Comparable<T>> extends TraversePostOrderBST {
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, T value) {
        if (current == null)
            return null;
        if(value.compareTo((T)current.value)==0){
            if (current.left == null && current.right == null) {
                return null;
            }

            if(current.right==null)
                return current.left;
            if(current.left==null)
                return current.right;

            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if(value.compareTo((T)current.value)<0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);


        return current;
    }
    private T findSmallestValue(Node root) {
        return root.left == null ? (T)root.value : findSmallestValue(root.left);
    }
}
class TestDeleteNoteInBST{
    public static void main(String[] args) {
        DeleteNoteInBST bt = new DeleteNoteInBST();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.delete(6);
        bt.traversePostOrder(bt.root);
    }
}
