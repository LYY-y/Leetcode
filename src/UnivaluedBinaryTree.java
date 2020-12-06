import java.util.HashSet;
import java.util.Set;

/**965. 单值二叉树
 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。



 示例 1：



 输入：[1,1,1,1,1,null,1]
 输出：true
 示例 2：



 输入：[2,2,2,5,2]
 输出：false


 提示：

 给定树的节点数范围是 [1, 100]。
 每个节点的值都是整数，范围为 [0, 99] 。*/
public class UnivaluedBinaryTree {
    //100.00%,99.08%
    int a=0;
    boolean isUnival = true;
    public boolean isUnivalTree(TreeNode root) {
        a = root.val;
        dfs(root);
        return isUnival;
    }

    public void dfs(TreeNode node){
        if (node==null){
            return;
        }
        if (node.val != a){
            isUnival = false;
        }
        if (isUnival){
            dfs(node.left);
            dfs(node.right);
        }
    }

    //优秀解答
    Set<Integer> set = new HashSet();
    public boolean isUnivalTree3(TreeNode root) {
        if(root == null){
            return true;
        }
        set.add(root.val);
        isUnivalTree(root.left);
        isUnivalTree(root.right);
        if(set.size() > 1){
            return false;
        }
        return true;
    }


    public boolean isUnivalTree2(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }


}
