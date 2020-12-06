import java.util.Stack;

/**剑指 Offer 27. 二叉树的镜像
 请完成一个函数，输入一个二叉树，该函数输出它的镜像。

 例如输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 镜像输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1



 示例 1：

 输入：root = [4,2,7,1,3,6,9]
 输出：[4,7,2,9,6,3,1]


 限制：

 0 <= 节点个数 <= 1000

 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/*/
public class MirrorOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //100.00%,94.67%
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode right = mirrorTree(root.right);
        TreeNode left = mirrorTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }



    //优秀解答
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }


    //利用栈
//    public TreeNode mirrorTree3(TreeNode root) {
//        if(root == null) return null;
//        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if(node.left != null) stack.add(node.left);
//            if(node.right != null) stack.add(node.right);
//            TreeNode tmp = node.left;
//            node.left = node.right;
//            node.right = tmp;
//        }
//        return root;
//    }



}
