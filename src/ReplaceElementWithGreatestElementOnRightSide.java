/**1299.将每个元素替换为右侧最大元素
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。*/
public class ReplaceElementWithGreatestElementOnRightSide {
    //35.14 5.14
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        for (int i = n - 1; i > 0; i--){
            int temp = arr[i-1];
            arr[i-1] = max;
            max = Math.max(temp, max);
        }
        arr[n-1] = -1;
        return arr;
    }
    //100 5.14
    public int[] replaceElements2(int[] arr) {
        int rmax = arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--){
            int temp = arr[i];
            arr[i] = rmax;
            if (temp > rmax){
                rmax = temp;
            }
        }
        arr[arr.length-1] = -1;
        return arr;
    }

        public static void main(String[] args){
        ReplaceElementWithGreatestElementOnRightSide r = new ReplaceElementWithGreatestElementOnRightSide();
        System.out.println(r.replaceElements2(new int[]{17,18,5,4,6,1}));
    }
}
