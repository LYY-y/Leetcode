/**1200.最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class MinimimAbsoluteDifference {
    //99.33 5.19
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int dif =arr[1]-arr[0];
        List<Integer> difArr = new ArrayList<>();
        difArr.add(0);
        List<List<Integer>> res = new LinkedList<>() ;
        for (int i = 1; i < arr.length - 1; i++){
            int temp = arr[i+1]-arr[i];
            if (temp > dif){
                continue;
            }
            if (temp < dif) {
                dif = temp;
                difArr.clear();
            }
            difArr.add(i);
        }
        for (int j = 0; j < difArr.size(); j++){
            List<Integer> list = new ArrayList<>();
            list.add(arr[difArr.get(j)]);
            list.add(arr[difArr.get(j)+1]);
            res.add(list);
        }
        return res;
    }
    //99.33 5.19
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++){
            int temp = arr[i+1] - arr[i];
            if (temp <= dif) {
                if (temp < dif) {
                    dif = temp;
                    res.clear();
                }
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            }
        }
        return res;
    }


        public static void main(String[] args){
        MinimimAbsoluteDifference m = new MinimimAbsoluteDifference();
        System.out.println(m.minimumAbsDifference(new int[]{4,2,1,3}));
        System.out.println(m.minimumAbsDifference(new int[]{1,3,6,10,15}));
        System.out.println(m.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));

    }
}
