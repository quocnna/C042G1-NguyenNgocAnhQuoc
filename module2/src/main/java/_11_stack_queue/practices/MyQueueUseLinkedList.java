package _11_stack_queue.practices;

public class MyQueueUseLinkedList {
    private Node head;
    private Node tail;

    public MyQueueUseLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }

    class Node {
        public int key;
        public Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
        public int getKey(){
            return key;
        }
    }
}

class TestMyQueueUseLinkedList{
    public static void main(String[] args) {
        MyQueueUseLinkedList queue = new MyQueueUseLinkedList();
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.dequeue();
        System.out.println("Dequeued item is " + queue.dequeue().getKey());
    }
}