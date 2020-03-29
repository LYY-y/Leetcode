import java.util.Arrays;

/**1346.检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class CheckIfNAndItsDoubleExist {
    //64.08 100
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        if (arr[0] < 0) {
            int[] dic = new int[Math.abs(arr[0]) * 2 + 1];
            while (i < arr.length && arr[i] < 0) {
                dic[0 - arr[i]]++;
                dic[0 - arr[i] * 2]++;
                if (dic[0 - arr[i] * 2] > 1 && dic[0 - arr[i]] < 2) {
                    return true;
                }
                i++;
            }
        }
        int[] dic = new int[Math.abs(arr[arr.length-1])*2+1];
        if (dic.length == 1){
            return true;
        }
        while (i < arr.length){
            dic[arr[i]]++;
            dic[arr[i]*2]++;
            if ((dic[arr[i]] > 1 && dic[arr[i]*2] < 2)){
                return true;
            }
            i++;
        }
        return false;
    }

    //99.66 100
    public boolean checkIfExist2(int[] arr) {
        int[] counter = new int[4001];
        for (int a : arr){
            counter[2000 + a]++;
        }
        for (int a : arr){
            if (a != 0 && counter[2000+a*2] >= 1){
                return true;
            }
            if (a == 0 && counter[2000+a*2] >= 2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
    CheckIfNAndItsDoubleExist c = new CheckIfNAndItsDoubleExist();
    System.out.println("T "+c.checkIfExist2(new int[]{10,2,5,3}));
    System.out.println("T "+c.checkIfExist(new int[]{7,1,14,11}));
    System.out.println("F "+c.checkIfExist(new int[]{3,1,7,11}));
    System.out.println("T "+c.checkIfExist(new int[]{-3,-1,-6,11}));
    System.out.println("F "+c.checkIfExist(new int[]{4,-7,11,4,18}));
    System.out.println("F "+c.checkIfExist(new int[]{-4,-7,11,-4,18}));
    System.out.println("T "+c.checkIfExist(new int[]{0,0,0}));
    System.out.println("F "+c.checkIfExist(new int[]{-16,-19}));
    System.out.println("F "+c.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));

    }
}
