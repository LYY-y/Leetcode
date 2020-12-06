public class MergeTwoBinaryTrees {
    //100.00%,90.46%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode mergeNode = new TreeNode(t1.val+t2.val);
        mergeNode.left = mergeTrees(t1.left,t2.left);
        mergeNode.right = mergeTrees(t1.right,t2.right);
        return mergeNode;
    }

    //优秀解答 迭代
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        //如果 t1和t2中，只要有一个是null，函数就直接返回
        if(t1==null || t2==null) {
            return t1==null? t2 : t1;
        }
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        while(queue.size()>0) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if(r1.left!=null && r2.left!=null){
                queue.add(r1.left);
                queue.add(r2.left);
            }
            else if(r1.left==null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if(r1.right!=null && r2.right!=null) {
                queue.add(r1.right);
                queue.add(r2.right);
            }
            else if(r1.right==null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }



    public static void main(String[] args){
        TreeNode t1=new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        MergeTwoBinaryTrees mergeTwoBinaryTrees=new MergeTwoBinaryTrees();
        mergeTwoBinaryTrees.mergeTrees(t1,t2);
    }


}
