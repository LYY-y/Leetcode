import java.util.Arrays;

/**面试题17.04.消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？*/
public class MissingNumberLCCI {
    //11.92
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i != nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {

    }
