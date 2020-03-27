import java.util.Arrays;

/**1295.统计位数为偶数的数字
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * */
public class FindNumbersWithEvenNumberOfDigits {
    //99.89 18.47
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums){
            if (num < 10 || (num >= 100 && num < 1000)){
                continue;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args){
        FindNumbersWithEvenNumberOfDigits f = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(f.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(f.findNumbers(new int[]{555,901,482,1771}));

    }
}
