package LinkedList;

public class main {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.add(1,100);
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.print();

    }
}
