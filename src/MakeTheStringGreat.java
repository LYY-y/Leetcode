import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**1544. 整理字符串
 给你一个由大小写英文字母组成的字符串 s 。

 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:

 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。

 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。

 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。



 示例 1：

 输入：s = "leEeetcode"
 输出："leetcode"
 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 示例 2：

 输入：s = "abBAcC"
 输出：""
 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 "abBAcC" --> "aAcC" --> "cC" --> ""
 "abBAcC" --> "abBA" --> "aA" --> ""
 示例 3：

 输入：s = "s"
 输出："s"


 提示：

 1 <= s.length <= 100
 s 只包含小写和大写英文字母*/
public class MakeTheStringGreat {
    //6.35%,63.64%
    public String makeGood(String s) {
        List<String> list = Arrays.asList(s.split(""));
        StringBuilder stringBuilder = new StringBuilder();
        int len = list.size();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<len; i++){
            char a = list.get(i).charAt(0);
            if (!stack.empty()) {
                char b = stack.peek();
                if (Math.abs(a - b) == 32) {
                    stack.pop();
                } else {
                    stack.push(list.get(i).charAt(0));
                }
            }else {
                stack.push(list.get(i).charAt(0));
            }
        }
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    //优秀解答
    public String makeGood2(String s) {
        int idx = 2, len = s.length();
        char[] ca = new char[len + 1];
        ca[1] = s.charAt(0);
        for(int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if(Math.abs(ca[idx - 1] - c) == 32) {
                idx--;
            }
            else {
                ca[idx++] = c;
            }
        }
        return new String(ca, 1, idx - 1);
    }

    //优秀解答
    public String makeGood3(String s) {
        StringBuilder str = new StringBuilder(s);
        for(int i=0;i<str.length()-1;){
            if(Math.abs(str.charAt(i)-str.charAt(i+1))  == 32){
                str.delete(i,i+2);
                i=0;
                continue;
            }
            i++;
        }
        return str.toString();
    }

    public static void main(String[] args){
        MakeTheStringGreat makeTheStringGreat=new MakeTheStringGreat();
        System.out.println(makeTheStringGreat.makeGood("leEeetcode"));
        System.out.println(makeTheStringGreat.makeGood("abBAcC"));
        System.out.println(makeTheStringGreat.makeGood("s"));
    }
}
