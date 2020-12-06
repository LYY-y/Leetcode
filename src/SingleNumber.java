import java.util.Arrays;

/**136. 只出现一次的数字
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4
 * */
public class SingleNumber {
    //30.82%,15.75%
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length; ){
            if (i == nums.length-1){
                return nums[i];
            }
            if (nums[i] != nums[i+1]){
                if (nums[i+1]==nums[i+2]){
                    return nums[i];
                }
                return nums[i+1];
            }else {
                i+=2;
            }
        }
        return 0;
    }
    //优秀解答
    //任何数和 00 做异或运算，结果仍然是原来的数
    //任何数和其自身做异或运算，结果是 0
    //异或运算满足交换律和结合律
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res^=nums[i];
        }
        return res;
    }

    public static void main(String[] args){
        SingleNumber singleNumber=new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{4,1,2,1,2}));

        System.out.println(singleNumber.singleNumber(new int[]{2,2,1}));
    }
}
