import java.util.HashSet;
import java.util.Set;

/**349.两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        int[] result = new int[integers.length];
        for (int k = 0; k < integers.length; k++){
            result[k] = integers[k];
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] nums3 = new int[]{};

        System.out.println(new IntersectionOfTwoArrays().intersection(nums1,nums2));
        System.out.println(new IntersectionOfTwoArrays().intersection(nums3,nums3));

    }
}
