package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/310:06 下午
 * @Description: 二叉搜索树
 */
public class BinarySearchTree {
    // 声明根节点
    Node tree;

    // 插入元素
    public void insert(int value){
        // 空判断
        if (tree == null){
           tree = new Node(value);
           return;
        }
        Node current = tree;
        while (true){
            if (current.data == value){
                return;
            }
            if (current.data > value){
                // 遍历左子树
                // 如果左子树为空的情况下 直接插入到左子树中
                if(current.left == null){
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            }
            if  (current.data < value){
                // 遍历右子树
                // 如果左子树为空的情况下 直接插入到左子树中
                if(current.right == null){
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            }
        }
    }
    // 查找节点
    public Node findByValue(int value){
        if (tree == null) return null;
        Node current = tree;
        while (current != null){
            if (current.data > value){
                // 遍历右子树
                current = current.left;
            }else if(current.data < value){
                // 遍历左子树
                current = current.right;
            }else {
                return current;
            }
        }
        // 没有找到对应节点
        return null;
    }
    // 删除节点
    public void delete(int value){
        if (tree == null) return;
        // 声明当前节点
        Node current = tree;
        // 声明父节点
        Node parent = null;
        // 先找到目标节点
        while(current != null && current.data != value){
            parent = current;
            if(current.data > value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        // 没找到待删除的节点
        if (current == null){
            return;
        }
        // 当待删除节点左右子节点都不为空时
        if (current.left != null && current.right != null){
            // 需要找到右子树最小的值 对待删元素值进行替换
            Node temC = current.right;
            Node temP = null;
            while (temC.left != null){
                temP = temC;
                temC = temC.left;
            }
            // 将被删除节点的值替换成 右子树中最小的值
            current.data = temC.data;
            // 右子树最小节点还需要进行拼接
            current = temC;
            parent = temP;
        }
        Node child;
        // 当只有一个左子树或者右子树的情况
        if(current.left != null){
            child = current.left;
        }else if(current.right != null){
            child = current.right;
        }else {
            child = null;
        }
        // 进行拼接
        if(parent == null){
            // 父节点为空说明没进入循环 即要删除的为根节点
            tree = child;
        }
        else if(parent.right == current){
            // 如果右节点等于待删除元素 则将节点拼接在右节点上
            parent.right = child;
        }else if(parent.left == current){
            // 如果左节点等于待删除元素 则将节点拼接在左节点上
            parent.left = child;
        }

    }

    // 前序遍历
    public void printPre(Node node){
        if (node == null) return;
        System.out.println(node.data);
        printPre(node.left);
        printPre(node.right);
    }
    // 中序遍历
    public void printMiddle(Node node){
        if (node == null) return;
        printMiddle(node.left);
        System.out.println(node.data);
        printMiddle(node.right);
    }
    // 后序遍历
    public void printAfter(Node node){
        if (node == null) return;
        printAfter(node.left);
        printAfter(node.right);
        System.out.println(node.data);
    }
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] data = new int[] {1,2,4,6,3,5,9};
        for (int i:data
             ) {
            binarySearchTree.insert(i);
        }
        System.out.println(binarySearchTree.findByValue(3).data);
        binarySearchTree.delete(5);
        System.out.println(binarySearchTree.findByValue(5));
        System.out.println("==========前序遍历============");
        binarySearchTree.printPre(binarySearchTree.tree);
        System.out.println("==========中序遍历============");
        binarySearchTree.printMiddle(binarySearchTree.tree);
        System.out.println("==========后序遍历============");
        binarySearchTree.printAfter(binarySearchTree.tree);
    }
}
