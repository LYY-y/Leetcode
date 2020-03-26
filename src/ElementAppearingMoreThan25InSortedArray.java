/**1287.有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 * */
public class ElementAppearingMoreThan25InSortedArray {
    //100 5.96
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for (int i = 0; i+n/4 < n; i++){
            if (arr[i] == arr[i+n/4]){
                return arr[i];
            }
        }
        return -1;
    }

    //100 5.96
    public int findSpecialInteger2(int[] arr) {
        int gap = arr.length /4 + 1;
        for (int i = 0; gap < arr.length; i++, gap++){
            if (arr[i] == arr[gap]){
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }

        public static void main(String[] args){
        ElementAppearingMoreThan25InSortedArray e = new ElementAppearingMoreThan25InSortedArray();
        System.out.println(e.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }
}
