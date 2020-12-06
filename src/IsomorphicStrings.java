import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**205. 同构字符串
 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:

 输入: s = "egg", t = "add"
 输出: true
 示例 2:

 输入: s = "foo", t = "bar"
 输出: false
 示例 3:

 输入: s = "paper", t = "title"
 输出: true
 说明:
 你可以假设 s 和 t 具有相同的长度。
 * */
public class IsomorphicStrings {
    //5.19%,24.00%
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character,Character> map = new HashMap<Character, Character>();
        for (int i=0; i<len; i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar) || map.containsValue(tChar)) {
                for (char ch:map.keySet()){
                    char temp = map.get(ch);
                    if ((ch == sChar && temp != tChar) || (temp == tChar && ch != sChar)){
                        return false;
                    }
                }
            }else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }

    //优秀解答
    public boolean isIsomorphic2(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] map = new int[128];
        Arrays.fill(map,-1);
        for (int i=0;i<sArray.length;i++){
            if (map[sArray[i]]==-1){
                map[sArray[i]]=i;
            }else {
                if (tArray[map[sArray[i]]]!=tArray[i]){
                    return false;
                }
            }
        }
        Arrays.fill(map,-1);
        for (int i=0;i<tArray.length;i++){
            if (map[tArray[i]]==-1){
                map[tArray[i]]=i;
            }else {
                if (sArray[map[tArray[i]]]!=sArray[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("ab","aa"));
        System.out.println(isomorphicStrings.isIsomorphic("egg","add"));
        System.out.println(isomorphicStrings.isIsomorphic("foo","bar"));
        System.out.println(isomorphicStrings.isIsomorphic("paper","title"));
        System.out.println(isomorphicStrings.isIsomorphic("aa","ab"));

    }
}
