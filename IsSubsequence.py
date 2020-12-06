# 392. 判断子序列
# 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
# 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
# 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
# 示例 1:
# s = "abc", t = "ahbgdc"
# 返回 true.
#
# 示例 2:
# s = "axc", t = "ahbgdc"
#
# 返回 false.
#
# 后续挑战 :
#
# 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
class Solution:
    # 双指针 76.70 10.15
    def isSubsequence(self, s: str, t: str) -> bool:
        s_arr = list(s)
        t_arr = list(t)
        s_len = len(s_arr)
        t_len = len(t_arr)
        i,j = 0,0
        while i < s_len and j < t_len:
            if s_arr[i] == t_arr[j]:
                i += 1
            j += 1
        return i == s_len

    # 动态规化
    def isSubsequence2(self, s: str, t: str) -> bool:
        s_len, t_len = len(s), len(t)
        dp = [[0]*26 for _ in range(t_len)]
        dp.append([t_len]*26)
        # dp[i][j]表示字符串t从位置i开始往后字符j第一次出现的位置
        for i in range(t_len-1, -1, -1):
            for j in range(26):
                dp[i][j] = i if ord(t[i]) == j + ord('a') else dp[i+1][j]

        add = 0
        for i in range(s_len):
            if dp[add][ord(s[i])-ord('a')] == t_len:
                return False
            add = dp[add][ord(s[i])-ord('a')]+1
        return


s = Solution()
print(s.isSubsequence2('ahc','ahbgdc'))
print(s.isSubsequence('axc','ahbgdc'))
