import java.util.Stack;

/**844. 比较含退格的字符串
 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 注意：如果对空文本输入退格字符，文本继续为空。



 示例 1：

 输入：S = "ab#c", T = "ad#c"
 输出：true
 解释：S 和 T 都会变成 “ac”。
 示例 2：

 输入：S = "ab##", T = "c#d#"
 输出：true
 解释：S 和 T 都会变成 “”。
 示例 3：

 输入：S = "a##c", T = "#a#c"
 输出：true
 解释：S 和 T 都会变成 “c”。
 示例 4：

 输入：S = "a#c", T = "b"
 输出：false
 解释：S 会变成 “c”，但 T 仍然是 “b”。


 提示：

 1 <= S.length <= 200
 1 <= T.length <= 200
 S 和 T 只含有小写字母以及字符 '#'。


 进阶：

 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？*/
public class BackspaceStringCompare {
    //54.24%,96.88%
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        int lens=S.length();
        int lent=T.length();
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        int len=Math.max(S.length(),T.length());
        for (int i=0; i<len; i++){
            if (i<lens) {
                if (S.charAt(i) == '#') {
                    if (!stackS.empty()) {
                        stackS.pop();
                    }
                } else {
                    stackS.push(S.charAt(i));
                }
            }
            if (i<lent) {
                if (T.charAt(i) == '#') {
                    if (!stackT.empty()) {
                        stackT.pop();
                    }
                } else {
                    stackT.push(T.charAt(i));
                }
            }
        }
        while (!stackS.empty()){
            s.append(stackS.pop());
        }
        while (!stackT.empty()){
            t.append(stackT.pop());
        }
        return s.toString().equals(t.toString());
    }

    //优秀解答
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }


    //双指针，反向遍历字符串
    public boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                else {
                    break;
                }
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                }
                else if (skipT > 0) {
                    skipT--;
                    j--;
                }
                else {
                    break;
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }



    public static void main(String[] args){
        BackspaceStringCompare backspaceStringCompare=new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare3("y#fo##f","y#f#o##f"));
//        System.out.println(backspaceStringCompare.backspaceCompare("ab##","c#d#"));
//        System.out.println(backspaceStringCompare.backspaceCompare("ab#c","ab#c"));
        System.out.println(backspaceStringCompare.backspaceCompare("a#c","b"));
    }

}
