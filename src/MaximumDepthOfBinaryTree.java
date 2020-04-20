import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。*/
public class MaximumDepthOfBinaryTree {
    //自底向上的递归法100 5.75
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    //自顶向下的递归法 100 5.75
    int ans = 0;
    public int maxDepth2(TreeNode root) {
        helper(root, 1);
        return ans;
    }

    private void helper(TreeNode p, int depth){
        if (p == null){
            return;
        }
        ans = Math.max(ans, depth);
        helper(p.left, depth+1);
        helper(p.right, depth+1);
    }

    //BFS 9.67  9.2
    public int maxDepth3(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int level = 0;
        while (!que.isEmpty()){
            level++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = que.poll();
                if (p.left != null) {
                    que.add(p.left);
                }
                if (p.right != null) {
                    que.add(p.right);
                }
            }
        }
        return level;
    }

    //非递归DFS 6.16 5.75
    public int maxDepth4(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null){
            return 0;
        }
        int depth = 1;
        stack.add(new Pair<>(root,depth));
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> cur = stack.pop();
            root = cur.getKey();
            int cur_dep = cur.getValue();
            if (root != null){
                depth = Math.max(depth, cur_dep);
                stack.push(new Pair<>(root.left,cur_dep+1));
                stack.push(new Pair<>(root.right,cur_dep+1));
            }
        }
        return depth;
    }

    public static void main(String[] args){
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        TreeNode root = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(m.maxDepth4(root));
    }

}
