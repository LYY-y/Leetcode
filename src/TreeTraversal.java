import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list4 = new LinkedList<>();
        if (root == null){
            return list4;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        int count = 0;
        int circle = 1;
        int nullNum = 0;
        TreeNode p = root;
        while (p != null || !que.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<Integer>();
            while (count < circle) {
                count++;
                if (p == null) {
                    p = que.poll();
                    continue;
                }
                temp.add(p.val);
                if (p.left == null){
                    nullNum++;
                }else {
                    que.add(p.left);
                }
                if (p.right == null){
                    nullNum++;
                }else {
                    que.add(p.right);
                }
                p = que.poll();
            }
            circle = circle*2-nullNum;
            count = 0;
            list4.add(temp);
        }
        return list4;
    }

    public static void main(String[] args){
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode treeNode = new AAATools().createTree(new Integer[]{3,9,20,null,null,15,7});
//        System.out.println(treeTraversal.levelOrder(treeNode));
        TreeNode treeNode2 = new AAATools().createTree(new Integer[]{1,2,null,3,null,4,null,5});
        System.out.println(treeTraversal.levelOrder(treeNode2));
    }
}
