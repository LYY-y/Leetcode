import java.util.Arrays;

/**面试题17.04.消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？*/
public class MissingNumber {
    //11.92
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //62.54
    public int missingNumber2(int[] nums) {
        int[] dic = new int[nums.length+1];
        for (int num : nums) {
            dic[num]++;
        }
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] == 0) {
                return i;
            }
        }
        return nums.length;
    }

    //100
    public int missingNumber3(int[] nums) {
        int r_sum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            r_sum += nums[i];
            sum += i;
        }
        sum += nums.length;
        return sum - r_sum;
    }

    //优秀解答
    //对同一个值异或两次，那么结果等于它本身，所以我们对res从0-nums.length进行异或，
    // 同时对nums数组中的值进行异或，出现重复的会消失，所以最后res的值是只出现一次的数字，也就是nums数组中缺失的那个数字。
    //作者：LSZ
    //链接：https://leetcode-cn.com/problems/missing-number-lcci/solution/onshi-jian-fu-za-du-o1kong-jian-fu-za-du-shi-xian-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int missingNumber4(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }

}
