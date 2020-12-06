import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**653. 两数之和 IV - 输入 BST
 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

 案例 1:

 输入:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 输出: True


 案例 2:

 输入:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 输出: False
*/
 public class TwoSumIVInputIsABST {
    //方法一：直接扫描整个二叉树，使用hash表记录各个元素出现的次数，然后判断k - num是否在hash表中。
    //51.69%,64.08%
    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        return helper(root,k,new HashSet());
    }

    public boolean helper(TreeNode node, int k, Set set){
        if (node == null){
            return false;
        }
        if (set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return helper(node.right,k,set) || helper(node.left,k,set);
    }

//    方法二：叉搜索树的中序遍历为递增序列，所以我们可以利用这个升序的序列寻找k。 使用双指针，分别指向头、尾。
//    如果两数之和大于target，尾指针前移，如果两数之和小于target，首指针后移
    //96.46%,10.47%
    public boolean findTarget2(TreeNode root, int k){
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        int l = 0;
        int r = list.size()-1;
        int sum = 0;
        while (l<r){
            sum = list.get(l)+list.get(r);
            if (sum == k){
                return true;
            }else if (sum < k){
                l++;
            }else {
                r--;
            }
        }
        return false;
    }

    public void inorder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

}
