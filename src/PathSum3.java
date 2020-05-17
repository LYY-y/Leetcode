import java.util.HashMap;
import java.util.Map;

/**437.路径总和3
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class PathSum3 {
    //改进2.0 99.41 73.91
    public int pathSum3(TreeNode root, int sum) {
        return helper3(root, sum, 0, new int[1000]);
    }

    public int helper3(TreeNode root, int sum, int cur, int[] array){
        if (root == null){
            return 0;
        }
        array[cur] = root.val;
        int pathSum = sum;
        //记录路径和等于给定数值的路径总数
        int count = 0;
        //到cur前的结点是否有符合条件的路径，若有，则count++
        for (int i = cur; i >= 0; i--){
            pathSum -= array[i];
            if (pathSum == 0){
                count++;
            }
        }
        return count + helper3(root.left, sum, cur + 1, array) + helper3(root.right, sum, cur + 1, array);
    }

    //改进1.0 99.41 69.57
    public int pathSum2(TreeNode root, int sum) {
        //用map记录当前路径的累加和（key）及该路径上有该值的数目(value)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        return helper(root, sum, 0, map);
    }

    public int helper(TreeNode root, int sum, int pathSum, Map<Integer, Integer> map){
        if (root == null){
            return 0;
        }
        //res记录满足的路径数目
        int res = 0;
        //累计当前结点的和
        pathSum += root.val;
        //若在map中存在满足pathSum - sum的数，则证明存在一条路径满足条件，res+1
        res += map.getOrDefault(pathSum - sum, 0);
        //将累计当前结点和存到map中，并将对应的value+1
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        //进入递归
        res += helper(root.left, sum, pathSum, map);
        res += helper(root.right, sum, pathSum, map);
        //此时进入每天路径的尾，则value-1，避免重复计算
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }

    //双重递归57.55 86.96
    int num = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return num;
    }

    public void sum(TreeNode node, int sum){
        if (node == null){
            return;
        }
        sum -= node.val;
        if (sum == 0){
            num++;
        }
        sum(node.left, sum);
        sum(node.right, sum);
    }

    public static void main(String[] args){
        PathSum3 pathSum3 = new PathSum3();
        TreeNode root = new AAATools().createTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(pathSum3.pathSum3(root,8));
    }
}
