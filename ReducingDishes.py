class Solution:
    # 5.29 5.34
    def maxSatisfaction(self, satisfaction) -> int:
        n = len(satisfaction)
        satisfaction.sort()
        # dp[i][j]表示前i个物体中，选中j个菜，可以达到的最大值。
        dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
        dp[1][0] = 0
        dp[1][1] = satisfaction[0]*1
        for i in range(2,n+1):
            for j in range(i+1):
                if j == 0:
                    dp[i][j] = 0
                else:
                    if i == j:
                        dp[i][j] = dp[i-1][j-1]+satisfaction[i-1]*j
                    else:
                        dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]+satisfaction[i-1]*j)

        ans = 0
        for k in range(n):
            ans = max(ans, dp[n][k])
        return ans

    # 优秀解答 贪心算法
    def maxSatisfaction(self, satisfaction) -> int:
        satisfaction.sort(reverse=True)
        pr, res = 0, 0
        for i in satisfaction:
            if pr + i > 0:
                pr += i
                res += pr
        return res

s=Solution()
print(s.maxSatisfaction([-1,-8,0,5,-7]))