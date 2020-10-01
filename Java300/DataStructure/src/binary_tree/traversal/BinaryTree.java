package binary_tree.traversal;

public interface BinaryTree {
    //是否是空树，即是否有根节点，有根节点的话，就不是空树
    boolean isEmpty();
    //返回树有多少个节点
    int size();
    //获取二叉树的高度
    int getHeight();
    //查询指定值的节点
    Node findKey(int value);

    /*递归遍历*/
    //前序递归遍历
    void preOrderedTraverse(Node root);
    //中序递归遍历
    void inOrderedTraverse(Node root);
    //后续递归遍历
    //void postOrderedTraverse();
    void postOrderedTraverse(Node node);

    /*非递归遍历*/
    //前序遍历的非递归操作
    /**
     *
     *
     * */
    void preOrderedByStack();

    //中序遍历的非递归操作
    void inOrderedByStack();

    //后续遍历的非递归操作
    void postOrderedByStack();

    //按照层次遍历二叉树
    void levelOrderedByStack();
}
