package LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){}
    public int getSize(){
        return this.size;
    }
    public void print(){
        Node<T> node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public void reversePrint(){
        Node<T> node = tail;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.previous;
        }
        System.out.println();
    }
    public void addFirst(T value){
        Node<T> newNode = new Node<>(value,head,null);
        if(head!=null)
            head.previous = newNode;
        head = newNode;
        if(tail==null)
            tail = newNode;
        size++;
    }
    public void addLast(T value){
        Node<T> newNode = new Node<>(value,null,tail);
        if(tail!=null)
            tail.next = newNode;
        head = newNode;
        if(head==null)
            head = newNode;
        size--;
    }
    public T removeFirst(){
        T returnValue = head.value;
        head.next.previous = null;
        head = head.next;
        size--;
        return returnValue;
    }
    public T removeLast(){
        T returnValue = tail.value;
        tail.previous.next = null;
        tail = tail.previous;
        size--;
        return returnValue;
    }
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator=new Iterator<T>() {
            private Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node!=null;
            }
            @Override
            public T next() {
                T rval = node.value;
                node = node.next;
                return rval;
            }
        };
        return iterator;
    }
}
