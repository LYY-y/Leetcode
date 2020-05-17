/**111.二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。*/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        //若为叶子结点，直接返回1
        if (root.left == null && root.right == null){
            return 1;
        }
        int depth1 = minDepth(root.left);
        int depth2 = minDepth(root.right);
        //若左右孩子有一个为空，则返回不为空的孩子的深度，此时depth1=0或depth2=0
        if (root.left == null || root.right == null){
            return depth1 + depth2 +1;
        }
        //左右子树都不为空，深度+1
        return Math.min(depth1, depth2)+1;
    }

    public static void main(String[] args){
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        System.out.println(minimumDepthOfBinaryTree.minDepth(new AAATools().createTree(new Integer[]{1,2})));
        System.out.println(minimumDepthOfBinaryTree.minDepth(new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7})));

    }
}
