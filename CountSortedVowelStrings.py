# 1641.统计字典序元音字符串的数目
# 给你一个整数n，请返回长度为n 、仅由元音(a, e, i, o, u)组成且按字典序排列的字符串数量。
# 字符串s按字典序排列需要满足：对于所有有效的i，s[i]在字母表中的位置总是与s[i + 1]相同或在s[i + 1]之前。

class Solution:
    # 29.72 68.13
    def countVowelStrings(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 5
        dp = [[0 for i in range(5)] for _ in range(n)]
        # dp[i][j]表示长度为i且最后一个字符小于等于j元音字符结尾的字符串数量和
        for i in range(5):
            dp[0][i] = i+1

        for i in range(1,n):
            for j in range(5):
                if j == 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]
        return dp[n-1][4]

    # 数学法
    def countVowelStrings(self, n: int) -> int:
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) // 24
        # n个球分成5堆
        # return math.comb(n + 5 - 1, 4)


s = Solution()
print(s.countVowelStrings(2))