package binary_tree.traversal;
// data leftChild rightChild
public class Node {
     Object value; //节点的值
     Node leftChild; //节点的左子树
     Node rightChild;//节点的右子树

    public Node() {
    }

    public Node(Object value){
        this();
        this.value = value;
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        this(value);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
