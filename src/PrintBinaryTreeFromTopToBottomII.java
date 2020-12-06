/**剑指 Offer 32 - II. 从上到下打印二叉树 II
 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]


 提示：

 节点总数 <= 1000*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTreeFromTopToBottomII {
    //93.44%,71.61%
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if( node == null)
            return;
        if( res.size() == depth){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
}