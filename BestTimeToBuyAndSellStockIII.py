# 123. 买卖股票的最佳时机 III
# 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
#
# 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
#
# 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
class Solution:
    # 57.74 61.85
    def maxProfit(self, prices) -> int:
        n = len(prices)
        if n < 2:
            return 0
        # dp[i][j] i代表买入次数1，2，j=0表示不持股，j=1表示持股
        dp = [[0]*2 for _ in range(3)]
        dp[1][1] = -prices[0]
        dp[2][1] = float('-inf')
        for i in range(n):
            dp[1][1] = max(dp[1][1],-prices[i])
            dp[1][0] = max(dp[1][0],dp[1][1]+prices[i])
            dp[2][1] = max(dp[2][1],dp[1][0]-prices[i])
            dp[2][0] = max(dp[2][0],dp[2][1]+prices[i])
        return dp[2][0]



# 优秀解答
class Solution:
    def maxProfit(self, prices) -> int:
        fb, fs = -float("INF"), 0
        sb, ss = -float("INF"), 0
        for p in prices:
            if fb < -p:
                fb = -p
            if fs < fb + p:
                fs = fb + p
            if sb < fs - p:
                sb = fs - p
            if ss < sb + p:
                ss = sb + p
        return ss

s=Solution()
print(s.maxProfit([3,3,5,0,0,3,1,4]))