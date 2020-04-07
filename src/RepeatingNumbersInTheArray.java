/**面试题03.数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class RepeatingNumbersInTheArray {
    //71.38
    public int findRepeatNumber(int[] nums) {
        int n =nums.length;
        int[] dic = new int[n];
        for (int i = 0; i < n; i++){
            dic[nums[i]]++;
            if (dic[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }

    //92.53
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int temp;
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        RepeatingNumbersInTheArray r = new RepeatingNumbersInTheArray();
        System.out.println(r.findRepeatNumber2(new AAATools().formatArray("[2,3,1,0,2,5,3]")));
    }
}
