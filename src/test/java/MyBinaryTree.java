
/**
 * @author JJJJ
 * @Title:
 * @date 2022/10/189:22 上午
 * @Description: 二叉树的实现  使用链表实现
 */
public class MyBinaryTree<T> {
    private static class Node<T> {
        T val;
        Node<T> left;
        Node<T> right;

        Node(T val) {
            this.val = val;
        }
    }

    // 表示根节点
    private Node<T> root;

    // 创建一个空的二叉树
    public MyBinaryTree() {
        root = new Node<>(null);
    }

    // 创建一个以t为根节点的二叉树
    public MyBinaryTree(T t) {
        root = new Node<>(t);
    }

    /**
     * 在parent节点下插入左节点
     *
     * @param left   左子节点元素
     * @param parent 父节点
     * @return 是否插入成功
     */
    public boolean insertLeft(T left, Node<T> parent) {
        // 先判断parent是否为空
        if (parent == null) return false;
        // 判断左子节点是否为空
        Node<T> lNode = new Node<>(left);
        if (parent.left != null) {
            lNode.left = parent.left;
            parent.left = lNode;
        } else {
            parent.left = lNode;
        }
        return true;
    }

    /**
     * 在parent节点下插入右节点 如果当前节点已经有了右子节点 就在右子节点下插入右子节点
     *
     * @param right  右子节点元素
     * @param parent 父节点
     * @return 是否插入成功
     */
    public boolean insertRight(T right, Node<T> parent) {
        // 先判断parent是否为空
        if (parent == null) return false;
        // 判断左子节点是否为空
        Node<T> rNode = new Node<>(right);
        if (parent.right != null) {
            rNode.right = parent.right;
            parent.right = rNode;
        } else {
            parent.right = new Node<>(right);
        }
        return true;
    }

    /**
     * 删除parent下的左节点
     *
     * @param parent 父节点
     * @return 是否删除成功
     */
    public boolean deleteLeft(Node<T> parent) {
        // 先判断parent是否为空
        if (parent == null) return false;
        parent.left = null;
        return true;
    }

    /**
     * 删除parent下的右节点
     *
     * @param parent 父节点
     * @return 是否删除成功
     */
    public boolean deleteRight(Node<T> parent) {
        // 先判断parent是否为空
        if (parent == null) return false;
        parent.right = null;
        return true;
    }

    /**
     * 查找对应元素
     *
     * @param x 需要查找的元素
     * @return 是否存在
     */
    public boolean search(T x) {
        if (root == null) return false;
        if (root.val == x) return true;
        preOrder(root.left);
        preOrder(root.right);
        return true;
    }


    /**
     * 按某种方式遍历当前二叉树的全部节点
     *
     * @param i 方式
     */
    public void traversal(int i) {
        switch (i) {
            case 0:
                preOrder(this.root);
                break;
            case 1:
                midOrder(this.root);
                break;
            case 2:
                postOrder(this.root);
                break;
            default:
                levelOrder();
        }
    }

    /**
     * 获取当前节点下树的高度
     *
     * @param parent 当前节点
     * @return 数的高度
     */
    public int getHeight(Node<T> parent) {
        int leftHeight,rightHeight,max;
        // 进行遍历
        if (parent != null){
            leftHeight = getHeight(parent.left);
            rightHeight = getHeight(parent.right);
            // 判断左右子树的高度大小
            max = Math.max(leftHeight, rightHeight);
            return max + 1;
        }
        return 0;
    }

    /**
     * 前序遍历
     *
     * @param root 树根节点
     */
    public void preOrder(Node<T> root) {
        // 进行非空判断
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root 树根节点
     */
    public void midOrder(Node<T> root) {
        // 进行非空判断
        if (root == null) return;
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }

    /**
     * 后续遍历
     *
     * @param root 树根节点
     */
    public void postOrder(Node<T> root) {
        // 进行非空判断
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public void levelOrder() {
        // 层级遍历需要借助队列
        Node<T>[] queue = new Node[100];
        // 声明对手指针和队尾指针
        int front, rear;
        front = -1;
        rear = 0;
        // 将二叉树根节点放入队列
        queue[rear] = this.root;
        while (rear != front) {
            front++;
            System.out.println(queue[front].val);
            // 判断左右子节点是否为空
            if (queue[front].left != null) {
                queue[++rear] = queue[front].left;
            }
            if (queue[front].right != null) {
                queue[++rear] = queue[front].right;
            }
        }
    }

}
