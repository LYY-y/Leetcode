import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**1207. 独一无二的出现次数
 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。



 示例 1：

 输入：arr = [1,2,2,1,1,3]
 输出：true
 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 示例 2：

 输入：arr = [1,2]
 输出：false
 示例 3：

 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 输出：true


 提示：

 1 <= arr.length <= 1000
 -1000 <= arr[i] <= 1000*/
public class UniqueNumberOfOccurrences {
    //100.00%,5.02%
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2001];
        int[] counts = new int[1001];
        for (int i=0; i<arr.length; i++){
            map[arr[i]+1000]++;
        }
        for (int j=0; j<2001; j++){
            if (map[j] != 0){
                if (counts[map[j]] != 0){
                    return false;
                }
                counts[map[j]]++;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();

        // 记录出现次数
        for(int data :arr) {
            if (map.get(data) == null) map.put(data, 1);
            else map.put(data, map.get(data) + 1);
        }

        // 验证重复值
        for(Integer i : map.values()) {
            if (!set.add(i)) return false;
        }
        return true;
    }

}
