import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**409. 最长回文串
 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:

 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * */
public class LongestPalindrome {
    //17.24%,33.94%
    public int longestPalindrome(String s) {
        int count = 0;
        boolean haveOdd = false;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            int val = entry.getValue();
            if (val%2==0){
                count+=val;
            }else {
                if (val > 2){
                    count += (val-1);
                }
                haveOdd = true;
            }
        }
        if (haveOdd){
            count+=1;
        }
        return count;
    }

    //优秀解答
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

}
