/**572. 另一个树的子树
 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 示例 1:
 给定的树 s:

 3
 / \
 4   5
 / \
 1   2
 给定的树 t：

 4
 / \
 1   2
 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

 示例 2:
 给定的树 s：

 3
 / \
 4   5
 / \
 1   2
 /
 0
 给定的树 t：

 4
 / \
 1   2
 返回 false。

 通过次数52,410提交次数111,273*/
public class SubtreeOfAnotherTree {
    //77.92%,91.60%
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null && t==null){
            return true;
        }
        if (s==null || t == null){
            return false;
        }
        return helper(s,t);
    }

    public boolean helper(TreeNode s, TreeNode t){
        if (s==null) {
            return false;
        }
        return check(s,t) || helper(s.left,t) || helper(s.right,t);
    }

    public boolean check(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null || s.val != t.val){
            return false;
        }
        return check(s.left,t.left)&&check(s.right,t.right);
    }


    //优秀题解
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return p == null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args){
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        TreeNode node = TreeNode.generate(new Integer[]{3,4,5,1,2,null,null,0});
        TreeNode node2 = TreeNode.generate(new Integer[]{4,1,2});
        subtreeOfAnotherTree.isSubtree(node,node2);
    }
}
