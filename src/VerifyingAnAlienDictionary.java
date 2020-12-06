/**953. 验证外星语词典
 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。

 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。



 示例 1：

 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 输出：true
 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 示例 2：

 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 输出：false
 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 示例 3：

 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 输出：false
 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。


 提示：

 1 <= words.length <= 100
 1 <= words[i].length <= 20
 order.length == 26
 在 words[i] 和 order 中的所有字符都是英文小写字母。*/
public class VerifyingAnAlienDictionary {
    //100.00%,40.00%
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int k=0; k< order.length(); k++){
            index[order.charAt(k)-'a']=k;
        }
        for (int i=0; i<words.length-1; i++){
            boolean isSame = true;
            String word1=words[i];
            String word2=words[i+1];
            int len1 = word1.length();
            int len2 = word2.length();
            int len =  Math.min(len1,len2);
            for (int j=0; j<len; j++){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    isSame = false;
                    int index1 = index[word1.charAt(j) - 'a'];
                    int index2 = index[word2.charAt(j) - 'a'];
                    if (index1 > index2) {
                        return false;
                    }
                    break;
                }
            }
            if (isSame && len1 > len2){
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }



    public static void main(String[] args){
        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"apap","app"},"abcdefghijklmnopqrstuvwxyz"));
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
    }
}
