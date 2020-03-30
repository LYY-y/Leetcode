/**5368. 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-lucky-integer-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FindLuckyIntegerInAnArray {
    //100
    public int findLucky(int[] arr) {
        int[] dic = new int[501];
        for (int a : arr){
            dic[a]++;
        }
        for (int i = 500; i > 0; i--){
            if (i == dic[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FindLuckyIntegerInAnArray f = new FindLuckyIntegerInAnArray();
        System.out.println(f.findLucky(new int[]{2,2,3,4}));
        System.out.println(f.findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println(f.findLucky(new int[]{2,2,2,3,3}));
        System.out.println(f.findLucky(new int[]{5}));
        System.out.println(f.findLucky(new int[]{7,7,7,7,7,7,7}));

    }
}
