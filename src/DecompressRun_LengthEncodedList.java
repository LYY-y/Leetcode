/**1313.解压缩编码列表
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * 考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * 请你返回解压后的列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class DecompressRun_LengthEncodedList {
    //99.3 100
    public int[] decompressRLElist(int[] nums) {
        int n = 0;
        for (int i=0; i < nums.length; i=i+2){
            n += nums[i];
        }
        int[] res = new int[n];
        int k = 0;
        for (int i = 0; i < n;){
            for (int j = 0; j < nums[k]; j++){
                res[i++] = nums[k+1];
            }
            k += 2;
        }
        return res;
    }

    public static void main(String[] args){
        DecompressRun_LengthEncodedList d = new DecompressRun_LengthEncodedList();
        System.out.println(d.decompressRLElist(new int[]{1,2,3,4}));
        System.out.println(d.decompressRLElist(new int[]{1,1,2,3}));

    }
}
