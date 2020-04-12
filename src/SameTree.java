/**100.相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
public class SameTree {
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
    }

    public static void main(String[] args){
        SameTree sameTree = new SameTree();
        TreeNode p = new AAATools().createTree(new Integer[]{1,2,3});
        TreeNode q = new AAATools().createTree(new Integer[]{1,2,3});
        System.out.println(sameTree.isSameTree(p,q));
    }
}
