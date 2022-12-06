package BinaryHeap;

import Tree.BinarySearchTree;

public class main {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
        System.out.println(heap.elemanSayisi());
        heap.ekle(10);
        heap.ekle(21);
        heap.ekle(12);
        heap.ekle(16);
        heap.ekle(5);
        heap.ekle(8);
        heap.ekle(65);
        heap.ekle(81);
        heap.ekle(15);
        heap.ekle(4);
        heap.print();

    }
}
