/**112.路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。*/
public class PathSum {
    boolean flag = false;
    int front = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum == 0){
            return true;
        }
        if (root == null){
            return flag;
        }
        if (sum - root.val  > 0) {
            front = sum - root.val;
        }
        hasPathSum(root.left, front);
        hasPathSum(root.right, front);
        return flag;
    }

    public static void main(String[] args){
        PathSum pathSum = new PathSum();
        TreeNode treeNode1 = new AAATools().createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(pathSum.hasPathSum(treeNode1,22));
    }
}
