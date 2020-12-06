/**389. 找不同
 给定两个字符串 s 和 t，它们只包含小写字母。

 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

 请找出在 t 中被添加的字母。
 * */
public class FindTheDifference {
    //73.01%,77.76%
    public char findTheDifference(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[] chars = new int[26];
        for (int i=0; i<lenS; i++){
            chars[s.charAt(i)-'a']++;
        }
        for (int i=0; i<lenT; i++){
            chars[t.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++){
            if (chars[i] != 0){
                return (char)(i+'a');
            }
        }
        return ' ';
    }

    //优秀解答
    public char findTheDifference2(String s, String t) {
        int count1 = 0;
        int count2 = 0;
        for(char i : s.toCharArray()){
            count1 += i;
        }
        for (char j : t.toCharArray()){
            count2 += j;
        }
        return (char) (count2-count1);
    }

    public char findTheDifference3(String s, String t) {
        int num=0;
        for(char c:s.toCharArray()){
            num^=c;
        }
        for(char c:t.toCharArray()){
            num^=c;
        }
        return (char)(num);
    }

}
