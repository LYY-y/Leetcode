import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**面试题17.10.主要元素
 * 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。*/
public class FindMajorityElementLCCI {
    //41.31
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int n = nums.length >> 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]){
                count++;
                if (count > n){
                    return nums[i];
                }
            }else {
                count = 1;
            }
        }
        return count > n ? nums[nums.length-1] : -1;
    }

    //41.31
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        for (int i = 0; i <= mid && i + mid < nums.length; i++) {
            if (nums[i] == nums[i+mid]){
                return nums[i];
            }
        }
        return -1;
    }

    //25.7
    public int majorityElement3(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int mid = nums.length >> 1;
        for (int num : nums){
            if (map.containsKey(num)){
                int value = map.get(num) + 1;
                if (value > mid){
                    return num;
                }
                map.put(num, value);
            }else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    //76.19
    public int majorityElement4(int[] nums) {
        int count = 0;
        int ele = 0;
        for (int n : nums){
            if (count == 0){
                ele = n;
                count++;
            }else {
                if (ele == n){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for (int n : nums){
            if (n == ele){
                count++;
            }
        }
        return count > (nums.length >> 1) ? ele : -1;
    }

    public static void main(String[] args){
        FindMajorityElementLCCI f = new FindMajorityElementLCCI();
        System.out.println(f.majorityElement4(new AAATools().formatArray("[3,2,3]")));
        System.out.println(f.majorityElement4(new AAATools().formatArray("[1,2,5,9,5,9,5,5,5]")));
        System.out.println(f.majorityElement4(new AAATools().formatArray("[3,2]")));
        System.out.println(f.majorityElement4(new AAATools().formatArray("[2,2,1,1,1,2,2]")));
        System.out.println(f.majorityElement4(new AAATools().formatArray("[1]")));

    }
}
