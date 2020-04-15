import java.util.LinkedList;

/**101.对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。*/
public class SymmetricTree {
    public boolean isSymmetric2(TreeNode root) {
        if (root.left == null){
            return true;
        }

        return false;
    }



    //迭代45.67 6.25
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root.left);
        que.add(root.right);
        while (!que.isEmpty()){
            TreeNode p = que.pollFirst();
            TreeNode q = que.pollLast();
            if (p == null && q == null){
                continue;
            }
            if (p == null || q == null || p.val != q.val){
                return false;
            }
            que.addFirst(p.right);
            que.addFirst(p.left);
            que.addLast(q.left);
            que.addLast(q.right);
        }
        return que.isEmpty();
    }



    public static void main(String[] args){
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new AAATools().createTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(symmetricTree.isSymmetric(root));
        TreeNode root2 = new AAATools().createTree(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(symmetricTree.isSymmetric(root2));
        TreeNode root3 = new AAATools().createTree(new Integer[]{9,-42,-42,null,76,76,null,null,13,null,13});
        System.out.println(symmetricTree.isSymmetric(root3));
    }
}
