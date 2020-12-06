import java.util.HashMap;
import java.util.Map;

/**594. 最长和谐子序列
 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。

 示例 1:

 输入: [1,3,2,2,5,2,3,7]
 输出: 5
 原因: 最长的和谐数组是：[3,2,2,2,3].
 说明: 输入的数组长度最大不超过20,000.*/
public class LongestHarmoniousSubsequence {
    //56.22%,5.12%
    public int findLHS(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        int count = 0;
        for (int num:nums){
            numMap.put(num, numMap.getOrDefault(num,0)+1);
        }
        for (int key:numMap.keySet()){
            if (numMap.containsKey(key+1)) {
                int temp = numMap.get(key)+numMap.get(key+1);
                if (count < temp) {
                    count = temp;
                }
            }
            if (numMap.containsKey(key-1)) {
                int temp = numMap.get(key) + numMap.get(key-1);
                if (count < temp) {
                    count = temp;
                }
            }
        }
        return count;
    }

    public int findLHS2(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }


    public static void main(String[] args){
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        System.out.println(longestHarmoniousSubsequence.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
