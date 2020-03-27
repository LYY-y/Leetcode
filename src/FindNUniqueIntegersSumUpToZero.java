/**1304.和为零的N个唯一整数
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * */
public class FindNUniqueIntegersSumUpToZero {
    //100 5.01
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int t = n >> 1;
        for (int i = 0; i < n; i++){
            res[i] = t--;
            if (t == 0){
                t--;
            }
        }
        if ((n & 1) == 1){
            res[n-1] = 0;
        }
        return res;
    }

    public static void main(String[] args){
        FindNUniqueIntegersSumUpToZero f = new FindNUniqueIntegersSumUpToZero();
        System.out.println(f.sumZero(5));
        System.out.println(f.sumZero(3));
        System.out.println(f.sumZero(1));
    }
}
