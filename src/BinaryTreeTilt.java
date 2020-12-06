public class BinaryTreeTilt {
    //41.47%,84.73%
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        sum += Math.abs(leftSum-rightSum);
        return leftSum+rightSum+root.val;
    }
    public static void main(String[] args){
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        TreeNode root = TreeNode.generate(new Integer[]{21,7,14,1,1,2,2,3,3});
        binaryTreeTilt.findTilt(root);
    }
}
