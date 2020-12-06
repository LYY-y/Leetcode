/**剑指 Offer 54. 二叉搜索树的第k大节点
 给定一棵二叉搜索树，请找出其中第k大的节点。



 示例 1:

 输入: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 输出: 4
 示例 2:

 输入: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 输出: 4


 限制：

 1 ≤ k ≤ 二叉搜索树元素个数*/
public class Thek_thLargestNodeOfTheBinarySearchTreeLCOF {
    //100.00%,96.65%
    int kNode = 0;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        helper(root,k);
        return kNode;
    }

    public void helper(TreeNode node, int k){
        if (node.right != null){
            helper(node.right,k);
        }
        count++;
        if (count==k){
            kNode = node.val;
            return;
        }
        if (node.left != null){
            helper(node.left,k);
        }
    }

    public static void main(String[] args){
        Thek_thLargestNodeOfTheBinarySearchTreeLCOF thek_thLargestNodeOfTheBinarySearchTreeLCOF=new Thek_thLargestNodeOfTheBinarySearchTreeLCOF();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(4);
        treeNode.left.right=new TreeNode(2);
        System.out.println(thek_thLargestNodeOfTheBinarySearchTreeLCOF.kthLargest(treeNode,1));
    }

}
