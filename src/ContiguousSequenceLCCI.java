/**面试题16.17.连续数列
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。*/
public class ContiguousSequenceLCCI {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (temp < 0){
                temp = nums[i];
            }else {
                temp += nums[i];
            }
            if (temp > maxSum){
                maxSum = temp;
            }
        }
        return maxSum;
    }
//优秀解答
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for(int i = 1; i < len; i++){

            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args){
        ContiguousSequenceLCCI c = new ContiguousSequenceLCCI();
        System.out.println("6 " + c.maxSubArray(new AAATools().formatArray("[-2,1,-3,4,-1,2,1,-5,4]")));
        System.out.println("1 " + c.maxSubArray(new AAATools().formatArray("[-2,1]")));
        System.out.println("-1 " + c.maxSubArray(new AAATools().formatArray("[-2,-1]")));
        System.out.println("0 " + c.maxSubArray(new AAATools().formatArray("[-1,0,-2]")));
        System.out.println("6 " + c.maxSubArray(new AAATools().formatArray("[1,2,-1,-2,2,1,-2,1,4,-5,4]")));

    }
}
