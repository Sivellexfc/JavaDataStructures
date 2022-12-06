package Tree;

public class main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(50);
        binarySearchTree.add(40);
        binarySearchTree.add(70);
        binarySearchTree.add(60);
        binarySearchTree.add(80);

        System.out.println("Successor = " + binarySearchTree.successor(50).value);
        System.out.println("Root = " + binarySearchTree.getRoot().value);
        System.out.println(binarySearchTree.inOrder(binarySearchTree.getRoot()));;
    }
}
