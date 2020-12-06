import java.util.*;

/**350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class IntersectionOfTwoArrays2 {
//   28.66%,87.45%
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++){
            Integer val = map1.get(nums1[i]);
            if (val == null){
                map1.put(nums1[i],1);
            }else {
                map1.put(nums1[i],val+1);
            }
        }
        for (int j = 0; j < nums2.length; j++){
            Integer val = map2.get(nums2[j]);
            if (val == null){
                map2.put(nums2[j],1);
            }else {
                map2.put(nums2[j],val+1);
            }
        }
        for (Integer key : map1.keySet()){
            if (map2.containsKey(key)){
                map.put(key, Math.min(map1.get(key),map2.get(key)));
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet()){
            int val = map.get(key);
            for (int i = 0; i < val; i++) {
                list.add(key);
            }
        }
        int len = list.size();
        int[] result = new int[len];
        for (int i= 0; i < len; i++){
            result[i] = list.get(i);
        }
        return result;
    }
//   61.55%，41.26%
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums1){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int[] result = new int[nums1.length];
        int k = 0;
        for (int num : nums2){
            if (map.get(num)!= null && map.get(num) > 0){
                result[k++] = num;
                int count = map.getOrDefault(num,0)-1;
                map.put(num,count);
            }
        }
        return Arrays.copyOfRange(result,0,k);
    }
//优秀解答，双指针
    public int[] intersect3(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int[] result = new int[nums1.length];
        int index = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                result[index] = nums1[i];
                i++;
                j++;
                index++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    public static void main(String[] args){
        int[] result = new IntersectionOfTwoArrays2().intersect2(new int[]{4,9,5},new int[]{9,4,9,8,4});
        for (int r: result){
            System.out.print(r+"  ");
        }
    }
}
