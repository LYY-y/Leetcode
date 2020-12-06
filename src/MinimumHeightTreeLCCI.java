public class MinimumHeightTreeLCCI {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }

    //100.00%,97.24%
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums,int low,int high){
        if (low > high){
            return null;
        }
        int mid = (high-low+1)/2+low;
        //int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,low,mid-1);
        root.right = helper(nums,mid+1,high);
        return root;
    }


    public static void main(String[] args){
        MinimumHeightTreeLCCI minimumHeightTreeLCCI=new MinimumHeightTreeLCCI();
        System.out.println(minimumHeightTreeLCCI.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
