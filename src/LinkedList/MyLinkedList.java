package LinkedList;

public class MyLinkedList<T>{
    private Node<T> head;
    public void print(){
        Node<T> current = head;
        while(current!=null){
            System.out.println(current.value + " ");
            current = current.next;
        }
    }
    public void addFirst(T value){
        Node<T> newNode = new Node<T>(value,head);
        head = newNode;
    }
    public void addLast(T value){
        Node<T> current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node<T>(value,null);
    }
    public void addAfter(Node<T> node,T value){
        Node<T> newNode = new Node<>(value, node.next);
        node.next = newNode;
    }
    public void add(int index,T value){
        Node<T> current = head;
        int counter = 0;
        while(current != null && counter < index){
            current = current.next;
            counter++;
        }
        if(counter != index)
            throw new IndexOutOfBoundsException("Listede yeterli eleman yok");
        Node<T> newNode = new Node<>(value, current.next);
        current.next = newNode;
    }
    public T removeFirst(){
        Node<T> toDelete = head;
        head = head.next;
        return toDelete.value;
    }
    public T removeLast(){
        Node<T> current = head;
        Node<T> previous = null;
        T returnValue;

        while (current.next!=null){
            previous = current;
            current = current.next;
        }
        if(previous != null){
            returnValue = previous.next.value;
            previous.next = null;
        }
        else{
            returnValue = head.value;
            head = null;
        }
        return returnValue;
    }

}
