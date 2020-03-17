import java.util.ArrayList;
import java.util.List;

/**1089.复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class DuplicateZeros {
    // 52.43 5.47
    public void duplicateZeros(int[] arr) {
        List<Integer> marks = new ArrayList<>();
        int arrLen = arr.length;
        int n = arr.length;
        for (int k=0; k<n; k++){
            if (arr[k] == 0){
                marks.add(k);
            }
        }
        int markLen = marks.size();
        if (markLen > 0) {
            for (int i = arrLen - 1; i >= marks.get(0); i--) {
                if (i + markLen < n) {
                    arr[i + markLen] = arr[i];
                }
                if (arr[i] == 0) {
                    markLen--;
                    if (i + markLen < n) {
                        arr[i + markLen] = 0;
                    }
                }
            }
        }
    }

    //99.51 5.47
    public void duplicateZeros2(int[] arr) {
        int[] copy = arr.clone();
        int j = 0;
        for (int i=0; i < arr.length; i++){
            arr[i] = copy[j];
            if (copy[j] == 0 && i != arr.length - 1){
                i++;
                arr[i] = 0;
            }
            j++;
        }
    }
    public static void main(String[] args){
        DuplicateZeros d = new DuplicateZeros();
        d.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        d.duplicateZeros(new int[]{1,2,3});
        d.duplicateZeros(new int[]{0,1,0,0,0,0,0});
    }
}
