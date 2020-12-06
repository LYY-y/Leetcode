/**面试题 04.04. 检查平衡性
 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


 示例 1:
 给定二叉树 [3,9,20,null,null,15,7]
 3
 / \
 9  20
 /  \
 15   7
 返回 true 。
 示例 2:
 给定二叉树 [1,2,2,3,3,null,null,4,4]
 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 返回 false 。*/
public class CheckBalanceLCCI {
    //100.00%,59.03%
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode node){
        if (node == null){
            return -1;
        }
        int h1 = helper(node.left);
        int h2 = helper(node.right);
        if (h1 == -1 || h2 == -1 || Math.abs(h1-h2)>2){
            return -1;
        }
        return Math.max(h1,h2)+1;
    }
}
