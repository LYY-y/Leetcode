/**112.路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。*/
public class PathSum {
    //递归100 6.56
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return helper(root, sum, root.val);
    }

    boolean flag = false;
    public boolean helper(TreeNode root, int sum, int temp){
        if (root.left == null && root.right == null){
            if (sum == temp) {
                flag = true;
            }
            return flag;
        }
        if (root.left != null) {
            helper(root.left, sum, temp + root.left.val);
        }
        if (root.right != null) {
            helper(root.right, sum, temp + root.right.val);
        }
        return flag;
    }

    //优化递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val==sum;
        }
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }


    public static void main(String[] args){
        PathSum pathSum = new PathSum();
        TreeNode treeNode1 = new AAATools().createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(pathSum.hasPathSum(treeNode1,22));
        TreeNode treeNode2 = new AAATools().createTree(new Integer[]{1,2});
//        System.out.println(pathSum.hasPathSum(treeNode2,1));
    }
}
