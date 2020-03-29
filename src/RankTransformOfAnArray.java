import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**1331.数组序号转换
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class RankTransformOfAnArray {
    //94.39 100
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        int[] res = new int[arr.length];
        Arrays.sort(copy);
        //去重
        int p =0, q=1;
        if (copy.length > 1) {
            while (q < copy.length) {
                if (copy[p] != copy[q]){
                    copy[++p] = copy[q++];
                }else {
                    q++;
                }
            }
        }
        copy = Arrays.copyOf(copy, p+1);
        Map<Integer,Integer> dic = new HashMap<Integer, Integer>();
        for (int i = 0; i < copy.length; i++){
            dic.put(copy[i], i+1);
        }
        for (int j = 0; j < arr.length; j++){
            res[j] = dic.get(arr[j]);
        }
        return res;
    }

    //优秀解答 建立数组hash表
    public int[] arrayRankTransform2(int[] arr) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,j=1;
        for (int i:arr){
            if(i>max) max=i;
            if(i<min) min=i;
        }
        int[] bucket=new int[max-min+1];
        for (int i:arr){
            bucket[i-min]++;
        }
        for (int i=0;i<bucket.length;i++){
            if(bucket[i]!=0){
                bucket[i]=j++;
            }
        }
        int[] res=new int[arr.length];
        int index=0;
        for (int i:arr){
            res[index++]=bucket[i-min];
        }
        return res;
    }
        public static void main(String[] args){
        RankTransformOfAnArray r = new RankTransformOfAnArray();
        System.out.println("[4,1,2,3] "+r.arrayRankTransform(new int[]{40,10,20,30}));
        System.out.println("[1,1,1] "+r.arrayRankTransform(new int[]{100,100,100}));
        System.out.println("[5,3,4,2,8,6,7,1,3] "+r.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}));

    }
}
