import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**559. N叉树的最大深度
 给定一个 N 叉树，找到其最大深度。

 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

 例如，给定一个 3叉树 :







 我们应返回其最大深度，3。

 说明:

 树的深度不会超过 1000。
 树的节点总不会超过 5000。*/
public class MaximumDepthOfN_aryTree {
    //100.00%,90.78%
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        for (Node n:root.children){
            depth = Math.max(depth,maxDepth(n));
        }
        return depth;
    }

    //迭代
    public int maxDepth2(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                for (Node c : root.children) {
                    stack.add(new Pair(c, current_depth + 1));
                }
            }
        }
        return depth;
    }



}
