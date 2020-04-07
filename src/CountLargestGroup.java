/**1399.统计最大组的数目
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 *
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-largest-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class CountLargestGroup {
    //100
    public int countLargestGroup(int n) {
        int[] dic = new int[37];
        for (int i = 1; i <= n; i++){
            int temp = 0;
            int k = i;
            while (k > 0){
                temp += k % 10;
                k /= 10;
            }
            dic[temp]++;
        }
        int res = 1;
        int m = 0;
        for (int j = 0; j < 37; j++){
            if (m < dic[j]){
                m = dic[j];
                res = 1;
                continue;
            }
            if (m == dic[j]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        CountLargestGroup c = new CountLargestGroup();
        System.out.println(c.countLargestGroup(13));
        System.out.println(c.countLargestGroup(2));
        System.out.println(c.countLargestGroup(15));
        System.out.println(c.countLargestGroup(24));
    }
}
