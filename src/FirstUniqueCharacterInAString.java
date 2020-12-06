/**387. 字符串中的第一个唯一字符
 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



 示例：

 s = "leetcode"
 返回 0

 s = "loveleetcode"
 返回 2


 提示：你可以假定该字符串只包含小写字母。
 * */
public class FirstUniqueCharacterInAString {
    //92.75%,36.82%
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        int len = s.length();
        for (int i=0; i<len; i++){
            chars[s.charAt(i)-'a']++;
        }
        int[] pos = new int[len];
        for (int j=0;  j<26; j++){
            if (chars[j] == 1){
                pos[s.indexOf(j+'a')]++;
            }
        }
        for (int k=0; k<len; k++){
            if (pos[k]==1){
                return k;
            }
        }
        return -1;
    }

    //优秀解答
    public int firstUniqChar2(String s) {
        int minIndex = s.length();
        for (int i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf((char) i);
            int lastIndex = s.lastIndexOf((char) i);
            if (firstIndex == -1 || lastIndex == -1) continue;
            if (firstIndex == lastIndex)
                minIndex = Math.min(firstIndex, minIndex);
        }
        return minIndex < s.length() ? minIndex : -1;
    }

    public static void main(String[] args){
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("leetcode"));
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
    }

}
