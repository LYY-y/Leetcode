import java.util.ArrayList;
import java.util.List;

/**1389.按既定顺序创建目标数组
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 *
 * 题目保证数字插入位置总是存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class CreateTargetArrayInTheGivenOrder {
    //90.31
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int[] target = new int[nums.length];
        for (int i = 0; i < index.length; i++){
            list.add(index[i], nums[i]);
        }
        for (int j = 0; j < nums.length; j++){
            target[j] = list.get(j);
        }
        return target;
    }

    public static void main(String[] args){
        CreateTargetArrayInTheGivenOrder c = new CreateTargetArrayInTheGivenOrder();
        System.out.println(c.createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));
    }
}
