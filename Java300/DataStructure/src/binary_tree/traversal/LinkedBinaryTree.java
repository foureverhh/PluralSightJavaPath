package binary_tree.traversal;


import java.util.*;

public class LinkedBinaryTree implements BinaryTree {
    private Node root;
    private List<Integer> nodes;


    public LinkedBinaryTree() {
        nodes = new ArrayList<>();
    }

    public LinkedBinaryTree(Node root) {
        this();
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return  root == null;
    }

    @Override
    public int size() {

        return size(root);
    }

    private int size(Node root) {
        if(root == null)
            return 0;

        int sizeLeft = 0, sizeRight = 0;
        if (root.leftChild != null) {
            sizeLeft = size(root.leftChild);
        }
        if (root.rightChild != null) {
            sizeRight = size(root.rightChild);
        }
        return sizeLeft + sizeRight + 1;

      /*
        if(root == null){
            return 0;
        }else {
            //返回左子树节点数
            int left = size(root.leftChild);
            //返回右子树节点数
            int right = size(root.rightChild);
            //返回左右子树节点数+1
            return left + right + 1;
        }
          */
    }
    @Override
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(Node root){
        int left = 0,right = 0;
        //左子树高度
        if(root.leftChild != null) {
           left = getHeight(root.leftChild);
        }
        //右子树高度
        if(root.rightChild != null) {
            right = getHeight(root.rightChild);
        }
        return Math.max(left,right)+1;
     /*
        if(root == null){
            return 0;
        }else{
            //左子树高度
            int left = getHeight(root.leftChild);
            //右子树高度
            int right = getHeight(root.rightChild);
            return left > right ? left+1: right +1;
        }
          */
    }

    @Override
    public Node findKey(int value) {
        return findKey(value,root);
    }

    private Node findKey(int value, Node root){
        if(root == null) //根节点为空,直接返回空；或者到了叶子节点 //递归结束条件1
            return null;
        else if((Integer)root.value == value){ //找到了节点 //递归结束条件2
            return root;
        }else { //递归体
            //查找左子树
            Node left = findKey(value,root.leftChild);
            //查找右子树
            Node right = findKey(value,root.rightChild);
            if(left != null) {
                return left;
            }
            return right;
        }
    }

    @Override
    public void preOrderedTraverse(Node root) {
        if(root == null)
            return;
        nodes.add((Integer) root.value);
        //遍历左树
        preOrderedTraverse(root.leftChild);
        //遍历右树
        preOrderedTraverse(root.rightChild);
//       if(root == null){
//            return;
//       }
//
//       nodes.add((Integer) root.value);
//       if(root.leftChild != null) {
//           LinkedBinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
//           leftTree.preOrderedTraverse();
//       }
//
//       if(root.rightChild != null) {
//           LinkedBinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
//           rightTree.preOrderedTraverse();
//       }
   /*    //输出根节点的值
        if(root == null)
            return;

        //System.out.println(root.value);
        nodes.add(((Integer)root.value));

        Node left = root.leftChild;

        Node right = root.rightChild;

        //对左子树进行先序遍历
        if(left != null){
           root = left;
           System.out.println("left: "+root.value);
           preOrderedTraverse();
        }

        //对右子树进行先序遍历
        if(right != null){
            root = right;
            System.out.println("right: "+root.value);
            preOrderedTraverse();
        }*/
    }

    @Override
    public void inOrderedTraverse(Node root) {
        if(root == null){
            return;
        }
        inOrderedTraverse(root.leftChild);
        nodes.add((Integer) root.value);
        inOrderedTraverse(root.rightChild);
    }

    @Override
    public void postOrderedTraverse(Node root) {
        if(root == null)
            return;
        postOrderedTraverse(root.leftChild);
        postOrderedTraverse(root.rightChild);
        nodes.add((Integer) root.value);
    }

    @Override
    public void preOrderedByStack() {
        if(root == null) return;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() != 0){
            Node current = stack.pop();
            nodes.add((Integer) current.value);
            if(current.rightChild != null){
                stack.push(current.rightChild);
            }
            if(current.leftChild != null){
                stack.push(current.leftChild);
            }
        }

    }

    @Override
    public void inOrderedByStack() {
        inOrderedByStack(root);
    }

    private void inOrderedByStack(Node root){
        if(root == null) return;
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || stack.size() != 0){
            while(current != null ){
                stack.push(current);
                current = current.leftChild;
            }
            if(stack.size() != 0){
                current = stack.pop();
                nodes.add((Integer) current.value);
                current = current.rightChild;
            }
        }
      /*  stack.push(root);
        while (stack.size()!=0){
            for (int i = 0; i <stack.size() ; i++) {
                Node temp = stack.pop();
                nodes.add((Integer) temp.value);
                if(temp.leftChild!=null) {
                    stack.push(temp.leftChild);

                };
                if(temp.rightChild!=null) stack.push(temp.rightChild);
            }
        }*/
    }
    @Override
    public void postOrderedByStack() {
        if(root==null) return;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size()!=0){
            Node current = stack.pop();
            nodes.add((Integer) current.value);
            if(current.leftChild != null){
                stack.push(current.leftChild);
            }
            if(current.rightChild != null){
                stack.push(current.rightChild);
            }
        }
        Collections.reverse(nodes);
    }

    //逐层遍历 LinkedList
    @Override
    public void levelOrderedByStack() {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0){
            int len = queue.size();
            //遍历队列
            for (int i = 0; i < len; i++) {
                //获取当前队列头的元素，并移除出队列
                Node temp = queue.poll();
                nodes.add((Integer) temp.value);
                //将当前头元素的左侧节点假如队尾
                if(temp.leftChild != null)
                    queue.offer(temp.leftChild);
                //将当前头元素的右侧节点假如队尾
                if(temp.rightChild != null)
                    queue.offer(temp.rightChild);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> getNodes() {
        return nodes;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public void setNodes() {
        this.nodes = new ArrayList<>();
    }

    public void setNodes(List<Integer> nodes) {
        this.nodes = nodes;
    }
}
