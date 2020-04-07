/**面试题53-1.在排序数组中查找数字1
 * 在排序数组中查找数字*/
public class FindNumbersInSortedArray {
    //34.67
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (nums[l] != target || nums[r] != target){
            if (nums[l] > target || nums[r] < target){
                return 0;
            }
            if (nums[l] < target){
                l++;
            }
            if (nums[r] > target){
                r--;
            }
        }
        return r - l + 1;
    }

    //100二分法
    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) >> 1;
            if (nums[m] <= target){
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        int right = l;
        l = 0;
        r = nums.length - 1;
        while (l <= r){
            int m = (l + r) >> 1;
            if (nums[m] < target){
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        int left = r;
        return right - left - 1;
    }
    public static void main(String[] args){
        FindNumbersInSortedArray f = new FindNumbersInSortedArray();
        System.out.println(f.search2(new AAATools().formatArray("[5,7,7,8,8,10]"), 8));
        System.out.println(f.search2(new AAATools().formatArray("[5,7,7,8,8,10]"), 6));

    }
}
