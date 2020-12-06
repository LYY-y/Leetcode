import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**961. 重复 N 次的元素
 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。



 示例 1：

 输入：[1,2,3,3]
 输出：3
 示例 2：

 输入：[2,1,2,5,3,2]
 输出：2
 示例 3：

 输入：[5,1,5,2,5,3,5,4]
 输出：5


 提示：

 4 <= A.length <= 10000
 0 <= A[i] < 10000
 A.length 为偶数*/
public class NRepeatedElementInSize2NArray {
    //34.03%,5.01%
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int len = A.length/2;
        if (A[len] == A[len+1]) {
            return A[len+1];
        }
        return A[len - 1];
    }

    //这个元素实际上就是数组中唯一一个重复的元素
    public int repeatedNTimes2(int[] A) {
        Set<Integer> set = new HashSet<>();
        int res=-1;
        for(int i=0;i<=A.length/2+1;i++){
            if(!set.add(A[i])){
                res=A[i];
                break;
            }
        }
        return res;
    }

}
