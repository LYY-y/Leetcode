import java.util.LinkedList;
import java.util.Queue;

/**226.翻转二叉树
 * 翻转一棵二叉树。*/
public class InvertBinaryTree {
    //递归 先序遍历100
    public TreeNode invertTree1(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode treeNode = root.left;
        root.left = invertTree1(root.right);
        root.right = invertTree1(treeNode);
        return root;
    }



    //迭代100
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode l = p.left;
            p.left = p.right;
            p.right = l;
            if (p.left != null){
                queue.offer(p.left);
            }
            if (p.right != null){
                queue.offer(p.right);
            }
        }
        return root;
    }
}
