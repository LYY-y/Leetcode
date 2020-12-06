import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**面试题 01.04. 回文排列
 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。

 回文串不一定是字典当中的单词。



 示例1：

 输入："tactcoa"
 输出：true（排列有"tacocat"、"atcocta"，等等）*/
public class PalindromePermutationLCCI {
    //68.57%,33.96%
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        boolean flag = true;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int val : map.values()) {
            if (val % 2 != 0) {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() < 2;
    }

    public boolean canPermutePalindrome3(String s) {
        int countodd=0;
        int [] table = new int[128];
        for(char c : s.toCharArray()){
            int x = c;
            if(x!=-1){
                table[x]++;
                if(table[x]%2==1){countodd++;}
                if(table[x]%2==0){countodd--;}
            }
        }
        return (countodd<=1)?true:false;
    }

}
