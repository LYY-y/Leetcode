# 188. 买卖股票的最佳时机 IV
# 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
#
# 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
#
# 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
class Solution:
    # 94.96 88.19
    def maxProfit(self, k: int, prices) -> int:
        n = len(prices)
        if n < 2 or k < 1:
            return 0
        # dp[i][j] 表示完成i次交易持有的金额，j=0不持股，j=1持股
        dp = [[0]*2 for _ in range(k+1)]
        # 初始化
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        dp[1][1] = -prices[0]
        # 交易未发生
        for i in range(2,k+1):
            dp[i][1] = float('-inf')
        for i in range(1,n):
            for j in range(1,min(i+1,k+1)):
                dp[j][1] = max(dp[j][1], dp[j-1][0]-prices[i])
                dp[j][0] = max(dp[j][0],dp[j][1]+prices[i])
        res = float('-inf')
        for i in range(1,k+1):
            res = max(res, dp[i][0])
        return res

    # 优秀解答
    def maxProfit2(self, k: int, prices) -> int:
        if len(prices) <= 1 or k == 0:
            return 0
        k = min(k, len(prices) // 2)
        dp_buy = [float('-inf')] * (k)
        dp_sell = [0] * (k)

        for p in prices:
            dp_buy[0] = max(dp_buy[0], -p)
            dp_sell[0] = max(dp_sell[0], dp_buy[0] + p)
            for i in range(1, k):
                dp_buy[i] = max(dp_buy[i], dp_sell[i - 1] - p)
                dp_sell[i] = max(dp_sell[i], dp_buy[i] + p)

        return dp_sell[k - 1]

s=Solution()
# print(s.maxProfit(2,[3,2,6,5,0,3]))
print(s.maxProfit(2,[1,2,4]))