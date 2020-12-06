import java.util.Stack;

/**1598. 文件夹操作日志搜集器
 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。

 下面给出对变更操作的说明：

 "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 "./" ：继续停留在当前文件夹。
 "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。

 文件系统启动时位于主文件夹，然后执行 logs 中的操作。

 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。*/
public class CrawlerLogFolder {
    //32.20%,99.79%
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log:logs){
            if (log.equals("../")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }else {
                    continue;
                }
            }else if (log.equals("./")){
                continue;
            }else {
                stack.push(log);
            }
        }
        return stack.size();
    }

    //优秀解答
    public int minOperations2(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                ans--;
                if (ans < 0) {
                    ans = 0;
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
