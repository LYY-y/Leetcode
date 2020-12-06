import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**125. 验证回文串
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false*/
public class ValidPalindrome {
    //12.89%,10.44%
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        Pattern p = Pattern.compile("[^a-z0-9]");
        Matcher matcher = p.matcher(s);
        s = matcher.replaceAll("");
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        int l = 0;
        int r = len-1;
        while (l<=r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    //优秀解答
    public boolean isPalindrome2(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!isValid(lc)) {
                l++;
                continue;
            }
            if (!isValid(rc)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    boolean isValid(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9');
    }

    public static void main(String[] args){
        ValidPalindrome validPalindrome=new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
