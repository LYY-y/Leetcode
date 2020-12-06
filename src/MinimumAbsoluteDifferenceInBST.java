/**530. 二叉搜索树的最小绝对差
 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。



 示例：

 输入：

 1
 \
 3
 /
 2

 输出：
 1

 解释：
 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。


 提示：

 树中至少有 2 个节点。
 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同*/
public class MinimumAbsoluteDifferenceInBST {
    //100.00%,87.23%
    int minDiff = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }

    public void helper(TreeNode node){
        if (node==null){
            return;
        }
        helper(node.left);
        if (pre==-1){
            pre = node.val;
        }else {
            minDiff = Math.min(minDiff,node.val-pre);
            pre = node.val;
        }
        helper(node.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(7);

        TreeNode root2 = new TreeNode(236);
        root2.left=new TreeNode(104);
        root2.right=new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);
        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST=new MinimumAbsoluteDifferenceInBST();
        System.out.println(minimumAbsoluteDifferenceInBST.getMinimumDifference(root2));
    }
}
