import java.util.LinkedList;
import java.util.List;

/**剑指 Offer 55 - I. 二叉树的深度
 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

 例如：

 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。



 提示：

 节点总数 <= 10000
 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/*/
public class DepthOfBinaryTree {
    //100.00%,97.90%
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        return depthCount(root,0);
    }

    public int depthCount(TreeNode node, int depth){
        if (node == null){
            maxDepth = Math.max(maxDepth,depth);
            return maxDepth;
        }
        depth++;
        depthCount(node.left,depth);
        depthCount(node.right,depth);
        return depth;
    }

    //优秀解答 树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    //层序遍历（BFS）
    //树的层序遍历 / 广度优先搜索往往利用 队列 实现。
    //关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }



    public static void main(String[] args){
        TreeNode treeNode=new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        DepthOfBinaryTree depthOfBinaryTree=new DepthOfBinaryTree();
        depthOfBinaryTree.maxDepth(treeNode);
    }
}
