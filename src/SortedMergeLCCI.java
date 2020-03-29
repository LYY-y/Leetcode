/**面试题10.01.合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class SortedMergeLCCI {
    public int[] merge(int[] A, int m, int[] B, int n) {
        int i = n + m - 1;
        n--;
        m--;
        while (n >= 0 && m >= 0){
            if (B[n] >= A[m]){
                A[i--] = B[n--];
            }else {
                A[i--] = A[m--];
            }
        }
        while (n >= 0){
            A[i--] = B[n--];
        }
        return A;
    }

    public static void main(String[] args){
        SortedMergeLCCI s = new SortedMergeLCCI();
        System.out.println(s.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3));
        System.out.println(s.merge(new int[]{0},0,new int[]{1},1));

    }
}
