import java.util.LinkedList;
import java.util.List;

public class TreeTraversal {
    //二叉树前序遍历
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    //二叉树中序遍历
    List<Integer> list2 = new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            list2.add(root.val);
            inorderTraversal(root.right);
        }
        return list2;
    }

    //二叉树后序遍历
    List<Integer> list3 = new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list3.add(root.val);
        }
        return list3;
    }

    //二叉树的层次遍历
    List<List<Integer>> list4 = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<Integer> que = new LinkedList<Integer>();
        if (root == null){
            return list4;
        }
        Integer p = root.val;
        while (p != null){
            while (que != null) {
                if (root.left != null) {
                    que.add(root.left.val);
                }
                if (root.right != null) {
                    que.add(root.right.val);
                }
                que.poll();
            }
        }
        return list4;
    }
}
