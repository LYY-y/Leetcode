# 309. 最佳买卖股票时机含冷冻期
# 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
#
# 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
#
# 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
# 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
class Solution:
    def maxProfit(self, prices) -> int:
        n = len(prices)
        if n < 2:
            return 0
        # dp[i][j] 代表第i天获得的最大收益，j=0未持股，j=1持股
        dp = [[0]*2 for _ in range(n)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
            if i > 2:
                dp[i][1] = max(dp[i-1][1],dp[i-2][0]-prices[i])
            else:
                dp[i][1] = max(dp[i-1][1],-prices[i])
        resMax = 0
        for i in range(n):
            resMax = max(resMax,dp[i][0])
        return resMax

    # 优秀解答
    def maxProfit(self, prices) -> int:
        if not prices:
            return 0
        n = len(prices)
        f = [[-prices[0], 0, 0]] + [[0] * 3 for i in range(n - 1)]
        # f[i][0]: 手上持有股票的最大收益
        # f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        # f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        for i in range(1, n):
            f[i][0] = max(f[i - 1][0], f[i - 1][2] - prices[i])
            f[i][1] = f[i - 1][0] + prices[i]
            f[i][2] = max(f[i - 1][1], f[i - 1][2])
        return max(f[n - 1][1], f[n - 1][2])

s = Solution()
# print(s.maxProfit([1,2,3,0,2]))
print(s.maxProfit([2,1,4]))