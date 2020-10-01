package binary_tree.traversal;

public class Demo {
    public static void main(String[] args) {
        //创建一个二叉树
        Node node5 = new Node(5,null,null);
        Node node4 = new Node(4,null,node5);
        Node node7 = new Node(7,null,null);
        Node node6 = new Node(6,null,node7);
        Node node3 = new Node(3,null,null);
        Node node2 = new Node(2,node3,node6);
        Node root = new Node(1,node4,node2);

        LinkedBinaryTree binaryTree = new LinkedBinaryTree(root);
        //BinaryTree binaryTree = new LinkedBinaryTree();
        //判断二叉树是否为空
        boolean empty = binaryTree.isEmpty();
        System.out.println(empty);


        //先序递归遍历 1 4 5 2 3 6 7
        binaryTree.preOrderedTraverse(root);
        System.out.println("先序遍历： " + binaryTree.getNodes());

        //中序递归遍历 4 5 1 3 2 6 7
        binaryTree.setNodes();
        binaryTree.inOrderedTraverse(root);
        System.out.println("中序遍历： " + binaryTree.getNodes());

        //后续递归遍历 5 4 3 7 6 2 1
        binaryTree.setNodes();
        binaryTree.postOrderedTraverse(root);
        System.out.println("后续遍历： " + binaryTree.getNodes());
        //中序非递归遍历(使用stack)


        //二叉树中的节点数量
        int size = binaryTree.size();
        System.out.println("二叉树节点数： " + size);

        //二叉树的高度
        int height = binaryTree.getHeight(root);
        System.out.println("二叉树高度: " + height);

        //在二叉树中查找某个节点
        System.out.println("节点: "+binaryTree.findKey(1));

        //按照层次遍历（借助队列） queue LinkedList
        binaryTree.setNodes();
        binaryTree.levelOrderedByStack();
        System.out.println("逐层遍历: " + binaryTree.getNodes());

        //中序遍历stack 4 5 1 3 2 6 7
        binaryTree.setNodes();
        binaryTree.inOrderedByStack();
        System.out.println("Stack中序遍历： " + binaryTree.getNodes());

        //前序遍历stack 1 4 5 2 3 6 7
        binaryTree.setNodes();
        binaryTree.preOrderedByStack();
        System.out.println("Stack前序遍历： " + binaryTree.getNodes());

        //后序遍历stack 5 4 3 7 6 2 1
        binaryTree.setNodes();
        binaryTree.postOrderedByStack();
        System.out.println("Stack后序遍历：" + binaryTree.getNodes());
    }
}
