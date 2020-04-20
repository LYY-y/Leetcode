import java.util.LinkedList;

/**101.对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。*/
public class SymmetricTree {
    //100 12.5
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        helper(root.left, root.right);
        return flag;
    }

    public void helper(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return;
        }
        if (p == null || q == null){
            flag = false;
            return;
        }
        if (flag && p.val != q.val){
            flag = false;
        }
        helper(p.left, q.right);
        helper(p.right, q.left);
    }



    //迭代45.67 6.25
    public boolean isSymmetric2(TreeNode root) {
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()){
            TreeNode p = list.pollFirst();
            TreeNode q = list.pollLast();
            if (p == null && q == null){
                continue;
            }
            if (p == null || q == null || p.val != q.val){
                return false;
            }
            list.addFirst(p.right);
            list.addFirst(p.left);
            list.addLast(q.left);
            list.addLast(q.right);
        }
        return list.isEmpty();
    }

    //优秀解答100
    public boolean isSymmetric3(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && isSame(n1.left, n2.right) && isSame(n1.right, n2.left);
    }



    public static void main(String[] args){
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new AAATools().createTree(new Integer[]{1,2,2,3,4,4,3});
//        System.out.println(symmetricTree.isSymmetric(root));
        TreeNode root2 = new AAATools().createTree(new Integer[]{1,2,2,null,3,null,3});
//        System.out.println(symmetricTree.isSymmetric(root2));
        TreeNode root3 = new AAATools().createTree(new Integer[]{9,-42,-42,null,76,76,null,null,13,null,13});
        System.out.println(symmetricTree.isSymmetric(root3));
    }
}
