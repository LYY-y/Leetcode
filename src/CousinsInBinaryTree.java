import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**993. 二叉树的堂兄弟节点
 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。



 示例 1：


 输入：root = [1,2,3,4], x = 4, y = 3
 输出：false
 示例 2：


 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 输出：true
 示例 3：



 输入：root = [1,2,3,null,4], x = 2, y = 3
 输出：false


 提示：

 二叉树的节点数介于 2 到 100 之间。
 每个节点的值都是唯一的、范围为 1 到 100 的整数。*/
public class CousinsInBinaryTree {
    //64.97%,90.87%
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y){
            return false;
        }
        int xFather = -1;
        int yFather = -1;
        Queue<TreeNode> queue  = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        xFather = node.val;
                    }
                    if (node.left.val == y) {
                        yFather = node.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xFather = node.val;
                    }
                    if (node.right.val == y) {
                        yFather = node.val;
                    }
                }
                if (xFather != -1 && yFather != -1 && xFather != yFather) {
                    return true;
                }
                size--;
            }
            xFather = -1;
            yFather=-1;
        }
        return false;
    }

    //优秀解答
    public boolean isCousins2(TreeNode root, int x, int y) {
        // 判空和特殊情况返回false
        if(root == null || x == root.val || y == root.val){
            return false;
        }
        // 层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 和x值相等的节点
        TreeNode xNode = null;
        // 和y值相等的节点
        TreeNode yNode = null;
        // 和x值相等的节点的父节点
        TreeNode xFatherNode = null;
        // 和y值相等的节点的父节点
        TreeNode yFatherNode = null;
        // 头结点入队列
        queue.add(root);
        // 开始层序遍历
        while(!queue.isEmpty()){
            // 当前层的结点数量
            int size = queue.size();
            // 当前层有几个结点就遍历几次
            while(size>0){
                // 出队列
                TreeNode tempNode = queue.poll();
                // 当前层的结点数量-1
                size--;
                // 先看左子树
                if(tempNode.left != null){
                    // 入队列
                    queue.add(tempNode.left);
                    // 找目标结点和目标结点的父结点
                    if(tempNode.left.val == x){
                        xNode = tempNode.left;
                        xFatherNode = tempNode;
                    }
                    if(tempNode.left.val == y){
                        yNode = tempNode.left;
                        yFatherNode = tempNode;
                    }
                }
                // 再看右子树
                if(tempNode.right != null){
                    // 入队列
                    queue.add(tempNode.right);
                    // 找目标节点和目标结点的父结点
                    if(tempNode.right.val == x){
                        xNode = tempNode.right;
                        xFatherNode = tempNode;
                    }
                    if(tempNode.right.val == y){
                        yNode = tempNode.right;
                        yFatherNode = tempNode;
                    }
                }
                // 如果两个目标结点此次遍历都没找到不操作，等待下一次遍历
                if(xNode == null && yNode == null){

                }
                // 如果此次遍历两个节点都找到了，判断是不是堂兄弟结点
                else if(xNode != null && yNode != null){
                    // 在这个for循环里面遍历保证了在同一层，只要不是一个父结点就是堂兄弟结点
                    return xFatherNode != yFatherNode;
                }
                // 如果这一层都遍历完了，还没找到两个目标结点，说明已经不满足堂兄弟结点在同一层（深度）的要求的，就算下面有目标结点也不满足题意了，返回false
                else if(size == 0){
                    return false;
                }
            }
        }
        // 遍历结束都没找到，返回false
        return false;
    }

    //优秀解答
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;
    public boolean isCousins3(TreeNode root, int x, int y) {
        // 采用深度优先的算法，定义两个hashmap,一个用来存储节点TreeNode的深度，一个用来存储节点的父节点
        depth = new HashMap<Integer, Integer>();
        parent = new HashMap<Integer, TreeNode>();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? depth.get(par.val) + 1 : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args){
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        TreeNode root = TreeNode.generate(new Integer[]{1,2,3,4});
        cousinsInBinaryTree.isCousins(root,4,3);
    }
}
