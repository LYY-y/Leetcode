/**110.平衡二叉树 同剑指 Offer 55 - II. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1*/
public class BalancedBinaryTree {
    //自顶向下
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if (root == null){
            return  -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //自底向上，将高度保存在当前结点
    public boolean isBalanced2(TreeNode root) {
        if (root == null){
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)){
            int left = -1;
            if (root.left != null){
                left = root.left.val;
            }
            int right = -1;
            if (root.right != null){
                right = root.right.val;
            }
            if (Math.abs(left - right) < 2){
                root.val = left > right ? left + 1 : right + 1;
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    //优化
    // -1代表不是平衡树 否则是这个子树的高度 记得结算树高度是两个子树的高度最大值+1
    public boolean isBalanced3(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int h1 = helper(root.left);
        int h2 = helper(root.right);
        if (h1 == -1 || h2 == -1 || Math.abs(h1 - h2) > 1){
            return -1;
        }
        return Math.max(h1, h2) + 1;
    }



    public static void main(String[] args){
        BalancedBinaryTree b = new BalancedBinaryTree();
        TreeNode root1 = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
        TreeNode root2 = new AAATools().createTree(new Integer[]{1,2,2,3,3,null,null,4,4});
        System.out.println(b.isBalanced3(root1));
        System.out.println(b.isBalanced3(root2));
    }
}
