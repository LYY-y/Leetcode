import java.util.LinkedList;
import java.util.Queue;

/**235.二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class LowestCommonAncestorOfABinarySearchTree {
    //递归99.89
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    //迭代法 99.89
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int p_val = p.val;
        int q_val = q.val;
        TreeNode treeNode = root;
        while (treeNode != null){
            int val = treeNode.val;
            //若p的值比treeNode的值大，则进入右子树；若q的值比treeNode的值小，则进入左子树；否则，则证明p、q分别在两颗子树上，直接返回结点
            if (p_val > val && q_val > val){
                treeNode = treeNode.right;
            } else if (p_val < val && q_val < val ){
                treeNode = treeNode.left;
            }else {
                return treeNode;
            }
        }
        return null;
    }

    public static void main(String[] args){
        LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new AAATools().createTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        System.out.println("6 " + l.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println("2 " + l.lowestCommonAncestor(root, root.left, root.left.right).val);
        System.out.println("2 " + l.lowestCommonAncestor(root, root.left, root.left.right.right).val);
        System.out.println("2 " + l.lowestCommonAncestor(root, root.left, root.left.right.left).val);
        System.out.println("6 " + l.lowestCommonAncestor(root, root.left.right, root.right.left).val);
    }
}
