package _12_java_collection_framework.exercises;

import other.BinaryTree;

public class TraversePostOrderBST<T extends Comparable<T>> {
    Node<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }
    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null)
            return new Node<>(value);

        if(value.compareTo(current.value) < 0)
            current.left = addRecursive(current.left,value);
        else if(value.compareTo(current.value)>0)
            current.right = addRecursive(current.right,value);

        return current;
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    class Node<T> {
        T value;
        TraversePostOrderBST.Node left;
        TraversePostOrderBST.Node right;

        Node(T value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}

class TestTraversePostOrderBST{
    public static void main(String[] args) {
        TraversePostOrderBST<Integer> bt= new TraversePostOrderBST<>();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.traversePostOrder(bt.root);
    }
}
