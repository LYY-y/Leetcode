/**112.路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。*/
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum == 0){
            return true;
        }
        if (sum < 0){

        }
        int val = root.val;
        hasPathSum(root.left, sum - val);
    }
}
