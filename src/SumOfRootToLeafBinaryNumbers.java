import java.util.LinkedList;
import java.util.Queue;

/**1022. 从根到叶的二进制数之和
 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

 以 10^9 + 7 为模，返回这些数字之和。



 示例：



 输入：[1,0,1,0,1,0,1]
 输出：22
 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


 提示：

 树中的结点数介于 1 和 1000 之间。
 node.val 为 0 或 1 。*/
public class SumOfRootToLeafBinaryNumbers {
    //100.00%,96.86%
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root,0);
        return sum;
    }

    public void helper(TreeNode node, int val){
        if (node == null){
            return;
        }
        int temp = (val<<1)+node.val;
        if (node.left == null && node.right == null) {
            sum += temp;
        }
        helper(node.left,temp);
        helper(node.right,temp);
    }


    //队列
    public int sumRootToLeaf2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        nodeQueue.add(root);
        queue.add(root.val);
        while(!nodeQueue.isEmpty()){
            // 同时维护两个队列
            TreeNode node = nodeQueue.poll();
            int tmp = queue.poll();

            // 如果该节点是叶子节点，加到res中
            if(node.left==null && node.right==null){
                res += tmp;
            } else {
                // 左节点不为空时，左节点进入队列，左节点对应的值是当前节点tmp<<1+node.left.val
                if(node.left != null){
                    nodeQueue.add(node.left);
                    queue.add((tmp<<1) + node.left.val);
                }
                if(node.right != null){
                    nodeQueue.add(node.right);
                    queue.add((tmp<<1) + node.right.val);
                }
            }
        }
        return res;
    }



    public static void main(String[] args){
        SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(1);
        sumOfRootToLeafBinaryNumbers.sumRootToLeaf(treeNode);
    }

}
