import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**496. 下一个更大元素 I
 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。



 示例 1:

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 示例 2:

 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 输出: [3,-1]
 解释:
 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。


 提示：

 nums1和nums2中所有元素是唯一的。
 nums1和nums2 的数组大小都不超过1000。*/
public class NextGreaterElementI {
    //35.07%,99.04%
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int n1:nums1){
            for (int i=0; i<nums2.length; i++){
                if (n1 == nums2[i]){
                    int k = i+1;
                    while (k<nums2.length && nums2[k]<n1){
                        k++;
                    }
                    if (k<nums2.length) {
                        list.add(nums2[k]);
                    }else {
                        list.add(-1);
                    }
                    break;
                }
            }
        }
        int[] element = new int[list.size()];
        for (int i=0; i<element.length; i++){
            element[i] = list.get(i);
        }
        return element;
    }

    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Stack< Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap< >();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }



    public static void main(String[]args){
        NextGreaterElementI nextGreaterElementI=new NextGreaterElementI();
        nextGreaterElementI.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
        nextGreaterElementI.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4});
    }
}
