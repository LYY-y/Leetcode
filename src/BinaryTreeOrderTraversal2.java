/**107.二叉树的层次遍历2
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeOrderTraversal2 {
    //BFS 36.17 7.41
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++){
                TreeNode p = que.poll();
                list.add(p.val);
                if (p.left != null){
                    que.add(p.left);
                }
                if (p.right != null){
                    que.add(p.right);
                }
            }
            ans.addFirst(list);
        }
        return ans;
    }

    //DFS 99.64 7.41
    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        helper(root, 1);
        return res;
    }
    public void helper(TreeNode p, int level){
        if (p == null){
            return;
        }
        if (level > res.size()){
            res.addFirst(new LinkedList<Integer>());
        }
        res.get(res.size()-level).add(p.val);
        helper(p.left, level+1);
        helper(p.right, level+1);
    }

    public static void main(String[] args){
        BinaryTreeOrderTraversal2 b = new BinaryTreeOrderTraversal2();
        TreeNode root = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(b.levelOrderBottom(root));
    }
}
