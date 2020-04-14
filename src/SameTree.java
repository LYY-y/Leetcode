import java.util.LinkedList;

/**100.相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
public class SameTree {
    //递归100 5.5
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
        //迭代 100 5.5
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> que1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> que2 = new LinkedList<TreeNode>();
        que1.add(p);
        que2.add(q);
        while (!que1.isEmpty() && !que2.isEmpty()){
            p = que1.poll();
            q = que2.poll();
            if (p == null && q == null){
                continue;
            }
            if (p == null || q == null || p.val != q.val){
                return false;
            }
            que1.add(p.left);
            que1.add(p.right);
            que2.add(q.left);
            que2.add(q.right);
        }
        return que1.isEmpty() && que2.isEmpty();
    }

    public static void main(String[] args){
        SameTree sameTree = new SameTree();
        TreeNode p = new AAATools().createTree(new Integer[]{1,2});
        TreeNode q = new AAATools().createTree(new Integer[]{1,null,2});
        System.out.println(sameTree.isSameTree(p,q));

        TreeNode p2 = new AAATools().createTree(new Integer[]{1,2,3});
        TreeNode q2 = new AAATools().createTree(new Integer[]{1,2,3});
        System.out.println(sameTree.isSameTree(p2,q2));

        TreeNode p3 = new AAATools().createTree(new Integer[]{});
        TreeNode q3 = new AAATools().createTree(new Integer[]{0});
        System.out.println(sameTree.isSameTree(p3,q3));
    }
}
