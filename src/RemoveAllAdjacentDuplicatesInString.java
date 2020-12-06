import java.util.Stack;

/**1047. 删除字符串中的所有相邻重复项
 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

 在 S 上反复执行重复项删除操作，直到无法继续删除。

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。



 示例：

 输入："abbaca"
 输出："ca"
 解释：
 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。


 提示：

 1 <= S.length <= 20000
 S 仅由小写英文字母组成。*/
public class RemoveAllAdjacentDuplicatesInString {
    //41.04%,99.22%
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<S.length(); i++){
            if (stack.isEmpty()){
                stack.push(S.charAt(i));
            }else {
                if (stack.peek()!=S.charAt(i)){
                    stack.push(S.charAt(i));
                }else {
                    stack.pop();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    //优秀解答
    public String removeDuplicates2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = -1, j = 0;
        while (j < chars.length) {
            char c = chars[j];
            if (i >= 0 && chars[i] == c) {
                i--;
            } else {
                chars[++i] = c;
            }
            j++;
        }
        return new String(chars, 0, i + 1);
    }
}
