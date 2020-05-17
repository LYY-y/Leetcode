/**257.二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。*/
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    //递归2.0 91.94 7.69
    List<String> list2 = new LinkedList<String>();
    public List<String> binaryTreePaths2(TreeNode root) {
        helper2(root, "", list2);
        return list2;
    }

    public void helper2(TreeNode root, String str, List<String> list){
        if (root != null){
            str += String.valueOf(root.val);
            //若为叶子结点直接加入List中；否则继续添加到str中，继续遍历
            if (root.left == null && root.right == null){
                list.add(str);
            }
            str += "->";
            helper2(root.left, str, list);
            helper2(root.right, str, list);
        }
    }

    //递归22.49 7.69
    List<String> list = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return list;
        }
        return helper(root, root.val + "");
    }

    public List<String> helper(TreeNode root, String str){
        if (root.right == null && root.left == null){
            list.add(str);
            return list;
        }
        String temp = str;
        if (root.left != null) {
            helper(root.left, str += "->" + root.left.val);
        }
        if (root.right != null) {
            helper(root.right, temp += "->" + root.right.val);
        }
        return list;
    }

    public static void main(String[] args){
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = new AAATools().createTree(new Integer[]{1,2,3,null,5});
//        System.out.println(binaryTreePaths.binaryTreePaths(root).toString());
        TreeNode root2 = new AAATools().createTree(new Integer[]{1,2,3,4,5,6,7,8,9,null,10});
        System.out.println(binaryTreePaths.binaryTreePaths2(root2).toString());
    }

}
