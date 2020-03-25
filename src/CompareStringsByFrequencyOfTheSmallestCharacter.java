import java.util.Arrays;

/**1170.比较字符串最小字母出现频次
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。

 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。

 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    //77.44 5.26
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        byte[] wordsArr = new byte[words.length];
        int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++){
            wordsArr[i] = f(words[i]);
        }
        Arrays.sort(wordsArr);
        for (int j = 0; j < res.length; j++){
            byte query = f(queries[j]);
            for (int k = wordsArr.length - 1; k >= 0 && query < wordsArr[k]; k--){
                res[j]++;
            }
        }
        return res;
    }

    public byte f(String str){
        byte frequency = 0;
        byte[] bytes = str.getBytes();
        byte min = bytes[0];
        for (int j = 0; j < bytes.length; j++){
            if (bytes[j] == min){
                frequency++;
            }
            if (bytes[j] < min){
                min = bytes[j];
                frequency = 1;
            }
        }
        return frequency;
    }
//优秀解答
    public int[] numSmallerByFrequency2(String[] queries, String[] words) {
// 统计
        int [] counter = new int[12];
        for (int i = 0; i < words.length; i++)
            counter[fs(words[i])]++;

        // 累和
        for (int i = 9; i >= 0; i--)
            counter[i] += counter[i + 1];

        // 拿值
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ret[i] = counter[fs(queries[i]) + 1];

        return ret;
    }

    public int fs(String str) {

        if (str.length() < 2)
            return str.length();

        char temp = str.charAt(0);
        int max = 1;
        for (int i = 1; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == temp)
                max += 1;
            else if (ch < temp) {
                max = 1;
                temp = ch;
            } else
                continue;
        }
        return max;
    }

    public static void main(String[] args){
        CompareStringsByFrequencyOfTheSmallestCharacter c = new CompareStringsByFrequencyOfTheSmallestCharacter();
        //System.out.println("[1]  " + c.numSmallerByFrequency2(new String[]{"cbd"}, new String[]{"zaaaz"}));
        System.out.println("[1,2]  " + c.numSmallerByFrequency2(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"}));
    }
}
