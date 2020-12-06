import java.util.ArrayList;
import java.util.List;

/**501. 二叉搜索树中的众数
 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

 假定 BST 有如下定义：

 结点左子树中所含结点的值小于等于当前结点的值
 结点右子树中所含结点的值大于等于当前结点的值
 左子树和右子树都是二叉搜索树
 例如：
 给定 BST [1,null,2,2],

 1
 \
 2
 /
 2
 返回[2].

 提示：如果众数超过1个，不需考虑输出顺序

 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）*/
public class FindModeInBinarySearchTree {
    //100.00%,97.33%
    List<Integer> list = new ArrayList<>();
    int cur_count;
    int max_count;
    int pre ;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (root.val == pre){
            cur_count++;
        }else {
            pre = root.val;
            cur_count = 1;
        }
        if (max_count == cur_count){
            list.add(root.val);
        }
        if (max_count < cur_count){
            max_count = cur_count;
            list.clear();
            list.add(root.val);
        }
        inorder(root.right);
    }
}
