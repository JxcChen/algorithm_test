//package binary_tree_test;
//
//import javax.swing.tree.TreeNode;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author JJJJ
// * @Title:
// * @date 2022/3/198:43 上午
// * @Description:
// */
//public class easy_test {
//    public static void main(String[] args) {
//
//    }
//
//    List<String> resList = new ArrayList();
//    String routeStr = "";
//    public List<String> binaryTreePaths(TreeNode root) {
//        findAllRoute(root);
//        return resList;
//    }
//
////    static void findAllRoute(TreeNode root){
////        // 需要在前序的时候加上字符串 在后续的时候减去
////        // 当到叶子节点时就将字符串添加到list里面
////        if(root == null){
////            return;
////        }
////        // 在前序中添加该节点到字符串中
////        String rootStr = root.val + "->";
////        routeStr = routeStr + rootStr;
////        // 判断是否为叶子结点
////        if(root.left == root.right){
////            // 去掉最后一个箭头后 加入列表
////            resList.add(routeStr.substring(0,routeStr.length()-2));
////            // 将当前节点删掉
////            routeStr = routeStr.replace(rootStr,"");
////            return;
////        }
////        findAllRoute(root.left);
////        findAllRoute(root.right);
////        // 在后续中删除该节点字符
////        routeStr = routeStr.replace(rootStr,"");
////    }
//
//}
