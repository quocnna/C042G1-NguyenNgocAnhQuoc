package _12_java_collection_framework.exercises;

public class TraversePreOrderBST extends TraversePostOrderBST {
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
}
class TestTraversePreOrderBST{
    public static void main(String[] args) {
        TraversePreOrderBST bt = new TraversePreOrderBST();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.traversePreOrder(bt.root);
    }
}
