import java.util.HashMap;
import java.util.Map;

/**748. 最短补全词
 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。

 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。

 单词在匹配牌照中的字母时要：

 忽略牌照中的数字和空格。
 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。

 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。



 示例 1：

 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 输出："steps"
 说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
 "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 "steps" 包含 "t"、"p" 和两个 "s"。
 "stripe" 缺一个 "s"。
 "stepple" 缺一个 "s"。
 因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
 示例 2：

 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 输出："pest"
 说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的补全词 "pest" 。
 示例 3：

 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 输出："husband"
 示例 4：

 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 输出："enough"
 示例 5：

 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 输出："simple"


 提示：

 1 <= licensePlate.length <= 7
 licensePlate 由数字、大小写字母或空格 ' ' 组成
 1 <= words.length <= 1000
 1 <= words[i].length <= 15
 words[i] 由小写英文字母组成*/
public class ShortestCompletingWord {
    //12.25%,27.78%
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        licensePlate = licensePlate.toLowerCase();
        String shortestCompletingWord = null;
        for (int i=0; i<licensePlate.length(); i++){
            char ch = licensePlate.charAt(i);
            if (ch >= 'a' && ch <= 'z'){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        Map<Character,Integer> temp = new HashMap<Character, Integer>();
        for (String word:words){
            temp.putAll(map);
            boolean isCompletingWord = true;
            for (char w : word.toCharArray()){
                if (temp.containsKey(w)){
                    temp.put(w,temp.get(w)-1);
                }
            }
            for (Character key : temp.keySet()){
                if (temp.get(key) > 0){
                    isCompletingWord = false;
                    break;
                }
            }
            if (isCompletingWord){
                if (shortestCompletingWord == null || shortestCompletingWord.length() > word.length()) {
                    shortestCompletingWord = word;
                }
            }
        }
        return shortestCompletingWord;
    }


    //优秀解答
    public String shortestCompletingWord2(String licensePlate, String[] words) {
        if(words == null || words.length == 0 ) return "";
        if("".equals(licensePlate)) return words[0];

        int[] ps = new int[26];
        char t;
        for(int i = 0;i < licensePlate.length();i++){
            t = licensePlate.charAt(i);
            if(t >= 'A' && t <= 'Z'){
                t = (char) (t + 32);
            }else if(t < 'a' || t > 'z'){
                t = '0';
            }
            if(t != '0'){
                ps[t - 'a']++;
            }
        }

        String ret = null;
        for(String s : words){
            if(check(ps,s)){
                if(ret == null){
                    ret = s;
                }else if(s.length() < ret.length()){
                    ret = s;
                }
            }
        }
        return ret;
    }
    public boolean check(int[] ps,String s) {
        char t;
        int[] sc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            t = s.charAt(i);
            if (t >= 'A' && t <= 'Z') {
                t = (char) (t + 32);
            }
            sc[t - 'a']++;
        }
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] < ps[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        System.out.println("according "+shortestCompletingWord.shortestCompletingWord("GrC8950",new String[]{"other","every","base","according","level","meeting","none","marriage","rest"}));
        System.out.println("steps "+shortestCompletingWord.shortestCompletingWord("1s3 PSt",new String[]{"step","steps","stripe","stepple"}));
        System.out.println("pest "+shortestCompletingWord.shortestCompletingWord("1s3 456",new String[]{"looks", "pest", "stew", "show"}));
        System.out.println("husband "+shortestCompletingWord.shortestCompletingWord("Ah71752",new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"}));
        System.out.println("enough "+shortestCompletingWord.shortestCompletingWord("OgEu755",new String[]{"enough","these","play","wide","wonder","box","arrive","money","tax","thus"}));
        System.out.println("simple "+shortestCompletingWord.shortestCompletingWord("iMSlpe4",new String[]{"step","claim","consumer","student","camera","public","never","wonder","simple","thought","use"}));

    }
}
