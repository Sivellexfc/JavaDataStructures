package Tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private BTNode<T> root;
    public BinarySearchTree(BTNode<T> root){
        this.root = root;
    }
    public BinarySearchTree() { }
    public BTNode<T> getRoot(){return root;}
    public BTNode<T> find(BTNode<T>node, T value){
        if(node == null || node.value == value)
            return node;
        else if (value.compareTo(node.value)<0) {
            return find(node.left,value);
        }
        else return find(node.right,value);
    }
    public boolean contains(T value){
        return find(root,value)!=null;
    }
    public void add(T value){
        add(root,value);
    }
    private void add(BTNode<T> node, T value) {
        if(root==null) {
            root = new BTNode<>(value, null, null);
            return;
        }
        if(value.compareTo(node.value)<0) {
            if(node.left==null)
                node.left = new BTNode<>(value, null, null);
            else
                add(node.left, value);
        }
        else if(value.compareTo(node.value)>0){
            if(node.right==null)
                node.right=new BTNode<>(value, null, null);
            else
                add(node.right, value);
        }
        else throw new RuntimeException("Eleman ağaçta mevcut!");
    }

    public String inOrder(BTNode<T> node) {
        if (node==null)
            return "";
        String l=inOrder(node.left);
        String r=inOrder(node.right);
        return l+(l.equals("")?"":" ")+node.value+(r.equals("")?"":" ")+r;
    }
    public BTNode<T> successor(T value) {
        BTNode<T> node=find(getRoot(), value);
        if(node==null || node.right==null)
            return null;
        node=node.right;
        while (node.left!=null)
            node=node.left;
        return node;
    }
}
