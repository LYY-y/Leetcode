/**404.左子叶之和
 * 计算给定二叉树的所有左叶子之和。*/
public class SumOfLeftLeaves {
    //递归100
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return sum;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l != null && l.left == null && l.right == null){
            sum += l.val;
        }
        sumOfLeftLeaves(l);
        sumOfLeftLeaves(r);
        return sum;
    }

    public static void main(String[] args){
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        TreeNode root = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
    }
}
