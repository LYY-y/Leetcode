/**637. 二叉树的层平均值
 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。



 示例 1：

 输入：
 3
 / \
 9  20
 /  \
 15   7
 输出：[3, 14.5, 11]
 解释：
 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。


 提示：

 节点值的范围在32位有符号整数范围内。*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    //71.03%,34.95%
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curLevelLen = queue.size();
            long sum = 0;
            for (int i=0; i<curLevelLen; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (sum/curLevelLen > Integer.MAX_VALUE){
                sum = Integer.MAX_VALUE;
            }
            list.add(((double)sum/curLevelLen));
        }
        return list;
    }

    //优秀解答
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> list = new LinkedList<Double>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            double total = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                total += tmp.val;
                if(tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            list.add(total / size);
        }
        return list;
    }

    //递归
    public List<Double> averageOfLevels3(TreeNode root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<Double>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }

}
