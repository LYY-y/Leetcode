import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    public static TreeNode generate(Integer[] a) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(a[0]);
        queue.add(root);
        for (int i =1;i<a.length;i+=2) {
            TreeNode treeNode = queue.remove();
            if (a[i] != null) {
                treeNode.left = new TreeNode(a[i]);
                queue.add(treeNode.left);
            }
            if (i + 1 < a.length && a[i + 1] != null) {
                treeNode.right = new TreeNode(a[i + 1]);
                queue.add(treeNode.right);
            }
        }
        return root;
    }

}
