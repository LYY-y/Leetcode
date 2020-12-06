/**942. 增减字符串匹配
 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

 如果 S[i] == "I"，那么 A[i] < A[i+1]
 如果 S[i] == "D"，那么 A[i] > A[i+1]


 示例 1：

 输入："IDID"
 输出：[0,4,1,3,2]
 示例 2：

 输入："III"
 输出：[0,1,2,3]
 示例 3：

 输入："DDI"
 输出：[3,2,0,1]


 提示：

 1 <= S.length <= 10000
 S 只包含字符 "I" 或 "D"。*/
public class DIStringMatch {
    //80.83%,82.00%
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] match = new int[n+1];
        int[] res = new int[n+1];
        for (int k=0; k<res.length; k++){
            res[k] = k;
        }
        int k = 0;
        int d = res.length-1;
        int min = res[k++];
        int max = res[d--];
        for (int i=0; i<n; i++){
            char c = S.charAt(i);
            if (c == 'I'){
                match[i] = min;
                min = res[k++];
            }else {
                match[i] = max;
                max = res[d--];
            }
        }
        match[match.length-1]=min;
        return match;
    }

    //官方题解
    public int[] diStringMatch2(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }


    public static void main(String[] args){
        DIStringMatch diStringMatch=new DIStringMatch();
        diStringMatch.diStringMatch("IDID");
    }
}
