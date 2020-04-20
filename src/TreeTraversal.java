import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {
    //二叉树前序遍历
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    //二叉树中序遍历
    List<Integer> list2 = new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            list2.add(root.val);
            inorderTraversal(root.right);
        }
        return list2;
    }

    //二叉树后序遍历
    List<Integer> list3 = new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list3.add(root.val);
        }
        return list3;
    }

    //二叉树的层次遍历
    //迭代
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list4 = new ArrayList<>();
        if (root == null){
            return list4;
        }
        int cur = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            list.add(p.val);
            cur--;
            if (p.left != null){
                queue.add(p.left);
                next++;
            }
            if (p.right != null){
                queue.add(p.right);
                next++;
            }
            if (cur == 0){
                cur = next;
                next = 0;
                list4.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return list4;
    }

    //递归
    List<List<Integer>> list5 = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(0, root);
        return list5;
    }

    private void helper(int level, TreeNode p){
        if (p == null){
            return;
        }
        if (level < list5.size()){
            list5.get(level).add(p.val);
        }else {
            list5.add(new ArrayList<>());
            list5.get(level).add(p.val);
        }
        helper(level+1, p.left);
        helper(level+1, p.right);
    }



    public static void main(String[] args){
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode treeNode = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
//        System.out.println(treeTraversal.levelOrder(treeNode));
        TreeNode treeNode2 = new AAATools().createTree(new Integer[]{1,2,null,3,null,4,null,5});
//        System.out.println(treeTraversal.levelOrder(treeNode2));
        TreeNode treeNode3 = new AAATools().createTree(new Integer[]{1,2,3,4,null,null,5});
        System.out.println(treeTraversal.levelOrder(treeNode3));
    }
}
