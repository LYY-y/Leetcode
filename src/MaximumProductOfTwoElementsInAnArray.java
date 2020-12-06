/**1464. 数组中两元素的最大乘积
 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

 请你计算并返回该式的最大值。



 示例 1：

 输入：nums = [3,4,5,2]
 输出：12
 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 示例 2：

 输入：nums = [1,5,4,5]
 输出：16
 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 示例 3：

 输入：nums = [3,7]
 输出：12


 提示：

 2 <= nums.length <= 500
 1 <= nums[i] <= 10^3
 * */
public class MaximumProductOfTwoElementsInAnArray {
    //89.12%,5.21%
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num:nums){
            if (num > max2){
                if (num > max1){
                    max2 = max1;
                    max1 = num;
                }else {
                    max2 = num;
                }
            }
        }
        return (max1-1)*(max2-1);
    }

    public static void main(String[] args){
        MaximumProductOfTwoElementsInAnArray maximumProductOfTwoElementsInAnArray = new MaximumProductOfTwoElementsInAnArray();
        System.out.println("12 "+maximumProductOfTwoElementsInAnArray.maxProduct(new int[]{3,4,5,2}));
        System.out.println("16 "+maximumProductOfTwoElementsInAnArray.maxProduct(new int[]{1,5,4,5}));
        System.out.println("12 "+maximumProductOfTwoElementsInAnArray.maxProduct(new int[]{3,7}));
    }
}
