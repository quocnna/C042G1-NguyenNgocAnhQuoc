package _12_java_collection_framework.exercises;

public class SearchNodeInBST<T extends Comparable> extends TraversePreOrderBST {
    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, T value) {
        if (current == null)
            return false;
        if(value.compareTo((T)current.value)==0)
            return true;
        return value.compareTo((T)current.value)<0?containsNodeRecursive(current.left, value)
                :containsNodeRecursive(current.right, value);
    }
}
class TestSearchNodeInBST{
    public static void main(String[] args) {
        SearchNodeInBST<Integer> bt= new SearchNodeInBST<>();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.println(bt.containsNode(50));
    }
}
