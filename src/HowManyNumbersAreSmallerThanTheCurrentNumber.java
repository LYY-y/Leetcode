import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**1365.有多少小于当前数字的数字给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

 以数组形式返回答案。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    // 5.61
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int num : nums){
            if (hashmap.containsKey(num)){
                hashmap.put(num, hashmap.get(num)+1);
            }else {
                hashmap.put(num, 1);
            }
        }
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for (int v : hashmap.keySet()){
                if (v < nums[i]){
                    count += hashmap.get(v);
                }
            }
            res[i] = count;
        }
        return res;
    }

    //89.68
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums){
            counter[num]++;
        }
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = 0; j < counter.length; j++){
                if (j >= nums[i]){
                    break;
                }
                sum += counter[j];
            }
            nums[i] = sum;
        }
        return nums;
    }

    //优秀解答 100
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] qq = new int[101];
        for (int lee : nums)
        {
            qq[lee]++;
        }
        int[] ints = new int[101];
        for (int i = 1;i < ints.length;i++)
        {
            ints[i] = qq[i - 1] + ints[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length;i++)
        {
            res[i] = ints[nums[i]];
        }
        return res;
    }

    public static void main(String[] args){
        HowManyNumbersAreSmallerThanTheCurrentNumber h = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        System.out.println(h.smallerNumbersThanCurrent3(new int[]{8,1,2,2,3}));
        System.out.println(h.smallerNumbersThanCurrent2(new int[]{6,5,4,8}));
        System.out.println(h.smallerNumbersThanCurrent2(new int[]{7,7,7,7}));

    }
}
