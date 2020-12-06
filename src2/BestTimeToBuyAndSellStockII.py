# 122. 买卖股票的最佳时机 II
# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
# 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
# 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
class Solution:
    # 20.62 5.31
    def maxProfit(self, prices) -> int:
        n = len(prices)
        if n < 2:
            return 0
        # dp[i][j]表示第i天获得的最大收益，j=0不持股，j=1持股
        dp = [[0,0] for _ in range(n)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])
        return dp[n-1][0]

    #优质解答 贪心算法 注意：只能用于计算最大利润，计算的过程并不是实际的交易过程。
    def maxProfit(self, prices) -> int:
        i = 0
        sum = 0
        for i in range(1, len(prices)):
            if (prices[i] > prices[i - 1]):
                sum += prices[i] - prices[i - 1]
        return sum