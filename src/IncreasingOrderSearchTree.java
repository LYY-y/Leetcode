/**897. 递增顺序查找树
 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。



 示例 ：

 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

 5
 / \
 3    6
 / \    \
 2   4    8
 /        / \
 1        7   9

 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 \
 7
 \
 8
 \
 9


 提示：

 给定树中的结点数介于 1 和 100 之间。
 每个结点都有一个从 0 到 1000 范围内的唯一整数值。*/
public class IncreasingOrderSearchTree {
    //100.00%，95.78%
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node){
        if (node==null){
            return;
        }
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    //优秀解答 递归
   public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //获取当前树根，左子树创建出来的就是当前树的根
        TreeNode subRoot = increasingBST2(root.left);
        //如果左子树为空，则直接使用当前节点为子树根
        if (subRoot == null) {
            subRoot = root;
        } else {
            //如果左子树创建的树根不为空，则遍历最右侧的叶子节点，将当前的节点挂到最
            //右节点右子树上
            TreeNode subRootTemp = subRoot;
            while (subRoot.right != null) {
                subRoot = subRoot.right;
            }
            subRoot.right = root;
            subRoot = subRootTemp;
        }
        // 获取右子树处理好的根，并赋值给当前节点右子树
        root.right = increasingBST2(root.right);
        //清空当前节点的左子树
        root.left = null;
        //返回当前树的根
        return subRoot;
    }



    public static void main(String[] args){
        IncreasingOrderSearchTree increasingOrderSearchTree=new IncreasingOrderSearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        increasingOrderSearchTree.increasingBST2(root);
    }
}
