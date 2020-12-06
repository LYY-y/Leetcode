/**783. 二叉搜索树节点最小距离
 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。



 示例：

 输入: root = [4,2,6,1,3,null,null]
 输出: 1
 解释:
 注意，root是树节点对象(TreeNode object)，而不是数组。

 给定的树 [4,2,6,1,3,null,null] 可表示为下图:

 4
 /   \
 2      6
 / \
 1   3

 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。


 注意：

 二叉树的大小范围在 2 到 100。
 二叉树总是有效的，每个节点的值都是整数，且不重复。
 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同*/
public class MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;
    int pre = -1;
    //100.00%,71.59%
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root){
        inorder(root.left);
        if (root == null){
            return;
        }
        if (pre == -1){
            pre = root.val;
        }else {
            min = Math.min(root.val-pre,min);
            pre = root.val;
        }
        inorder(root.right);
    }

    public static void main(String[] args){
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        TreeNode root = TreeNode.generate(new Integer[]{90,69,null,49,89,null,52,null,null,null,null});
        binaryTreeTilt.findTilt(root);
    }
}
