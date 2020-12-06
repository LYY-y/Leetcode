import java.util.Arrays;

/**453. 最小移动次数使数组元素相等
 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。



 示例:

 输入:
 [1,2,3]

 输出:
 3

 解释:
 只需要3次移动（注意每次移动会增加两个元素的值）：

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/
public class MinimumMovesToEqualArrayElements {
    //暴力法，超时
    public int minMoves(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int count = 0;
        while (true){
            Arrays.sort(nums);
            int min = nums[0];
            int max = nums[nums.length-1];
            if (min!=max){
                int k = max-min;
                count+=k;
                for (int i=0; i<nums.length-1; i++){
                    nums[i]+=k;
                }
            }else {
                break;
            }
        }
        return count;
    }

    //44.67%,99.49%
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i=nums.length-1; i>=0; i--){
            count += (nums[i]-nums[0]);
        }
        return count;
    }

    //动态规化
    public int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (moves + nums[i]) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }

    //数学法
    public int minMoves4(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }

    //改进数学法
    public int minMoves5(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }


    public static void main(String[] args){
        MinimumMovesToEqualArrayElements minimumMovesToEqualArrayElements = new MinimumMovesToEqualArrayElements();
        System.out.println(minimumMovesToEqualArrayElements.minMoves3(new int[]{1,2,3}));
    }
}
