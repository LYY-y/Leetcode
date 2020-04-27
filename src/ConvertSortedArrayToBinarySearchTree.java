/**108.将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * */
public class ConvertSortedArrayToBinarySearchTree {
    //中序遍历：始终选择中间位置右边元素作为根节点
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int p = (left + right) >> 1;
        if (((left + right) & 1) == 1){
            p++;
        }
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(nums, left, p-1);
        root.right = helper(nums, p+1, right);
        return root;
    }

    //中序遍历：始终选择中间位置左边元素作为根节点
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length-1);
    }

    public TreeNode helper2(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int p = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper2(nums, left, p-1);
        root.right = helper2(nums, p+1, right);
        return root;
    }



    public static void main(String[] args){
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
        c.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}
