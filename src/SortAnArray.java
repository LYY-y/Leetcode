/**912.排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。*/
public class SortAnArray {
    //97.87 9.43
    public int[] sortArray(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        int min = len(nums)[0];
        int max = len(nums)[1];
        int[] dic = new int[max-min+1];
        for (int num : nums){
            dic[num-min]++;
        }
        int i = 0;
        for (int j = min; j <= max; j++){
            while (dic[j-min]-- > 0){
                nums[i++] =j;
            }
        }
        return nums;
    }

    public int[] len(int[] nums){
        int min = 50001;
        int max = -50001;
        for (int num : nums){
            if (num < min){
                min = num;
            }
            if (num > max){
                max = num;
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args){
        SortAnArray s = new SortAnArray();
        System.out.println(s.sortArray(new int[]{5,2,3,1}));
        System.out.println(s.sortArray(new int[]{5,1,1,2,0,0}));

    }
}
