import java.util.HashMap;
import java.util.Map;

/**290. 单词规律
 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true
 示例 2:

 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false
 示例 3:

 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false
 示例 4:

 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false
 说明:
 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * */
public class WordPattern {
    //98.56%,9.97%
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length()!=strings.length){
            return false;
        }
        Map<Character,String> map=new HashMap<Character,String>();
        for (int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)){
                if (!map.get(ch).equals(strings[i])){
                    return false;
                }
            }else if (map.containsValue(strings[i])){
                return false;
            } else {
                map.put(ch, strings[i]);
            }
        }
        return true;
    }

    //优秀解答
    public boolean wordPattern2(String p, String s) {
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        char[] chs = p.toCharArray();
        String[] strs = s.split(" ");
        if (chs.length != strs.length) {
            return false;
        }

        for (int i = 0; i < chs.length; i++) {
            if (!m1.containsKey(chs[i])) {
                m1.put(chs[i], strs[i]);
            } else {
                if (!m1.get(chs[i]).equals(strs[i])) {
                    return false;
                }
            }

            if (!m2.containsKey(strs[i])) {
                m2.put(strs[i], chs[i]);
            } else {
                if (m2.get(strs[i]) != chs[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba","dog dog dog dog"));
        System.out.println(wordPattern.wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("abba","dog cat cat fish"));

    }
}
