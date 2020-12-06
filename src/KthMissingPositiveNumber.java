/**1539. 第 k 个缺失的正整数
 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。

 请你找到这个数组里第 k 个缺失的正整数。



 示例 1：

 输入：arr = [2,3,4,7,11], k = 5
 输出：9
 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 示例 2：

 输入：arr = [1,2,3,4], k = 2
 输出：6
 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。


 提示：

 1 <= arr.length <= 1000
 1 <= arr[i] <= 1000
 1 <= k <= 1000
 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 * */
public class KthMissingPositiveNumber {
    //72.09%,23.55%
    public int findKthPositive(int[] arr, int k) {
        int a = 0;
        int len = arr.length;
        for (int i = 1; i < 1001 && a < len; i++){
            if (k == 0){
                return i-1;
            }
            if (arr[a] == i){
                a++;
                continue;
            }else {
                k--;
            }
        }
        return arr[len-1]+k;
    }

    //优秀解答
    public int findKthPositive2(int[] arr, int k) {
        if(arr[0] > k) return k;
        for(int i = 0 ; i < arr.length ; i++){
            if(k + i +1 - arr[i] <= 0){
                if(i- 1 >= 0)
                    return k + i;
            }
        }

        return  k + arr.length;
    }

    //二分法
    public int findKthPositive3(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }


    //指针法
    public int findKthPositive4(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0;
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                ++missCount;
                lastMiss = current;
            }
        }
        return lastMiss;
    }




    public static void main(String[] args){
        KthMissingPositiveNumber k = new KthMissingPositiveNumber();
        System.out.println("9 "+k.findKthPositive2(new int[]{2,3,4,7,11},5));
        System.out.println("6 "+k.findKthPositive(new int[]{1,2,3,4},2));
    }
}
