/**剑指 Offer 50. 第一个只出现一次的字符
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

 示例:

 s = "abaccdeff"
 返回 "b"

 s = ""
 返回 " "


 限制：

 0 <= s 的长度 <= 50000*/
public class TheFirstCharacterThatAppearsOnlyOnce {
    //92.10%,81.47%
    public char firstUniqChar(String s) {
        int[] chars = new int[26];
        int len=s.length();
        char result = ' ';
        for (int i=0; i<len; i++){
            chars[s.charAt(i)-'a']++;
        }
        int index = s.length();
        for (int j=0; j<26; j++){
            if (chars[j]==1){
                index = Math.min(index,s.indexOf((char)j+'a'));
                result = s.charAt(index);
            }
        }
        return result;
    }

    //优秀解答，正序找和反序找字符位置一样
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return ' ';
        int index = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int cur = s.indexOf(c);
            if (cur != -1 && cur == s.lastIndexOf(c)) {
                index = (index == -1 ? cur : Math.min(index, cur));
            }
        }
        // 判断是否存在
        return index == -1 ? ' ' : s.charAt(index);
    }

    public static void main(String[] args){
        TheFirstCharacterThatAppearsOnlyOnce theFirstCharacterThatAppearsOnlyOnce = new TheFirstCharacterThatAppearsOnlyOnce();
        System.out.println(theFirstCharacterThatAppearsOnlyOnce.firstUniqChar("leetcode"));
//        System.out.println(theFirstCharacterThatAppearsOnlyOnce.firstUniqChar("abaccdeff"));
//        System.out.println(theFirstCharacterThatAppearsOnlyOnce.firstUniqChar(""));
    }
}
