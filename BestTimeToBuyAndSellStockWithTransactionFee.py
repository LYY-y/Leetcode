# 714. 买卖股票的最佳时机含手续费
# 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
#
# 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
#
# 返回获得利润的最大值。
#
# 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
class Solution:
    # 33.35 31.16
    def maxProfit(self, prices, fee: int) -> int:
        # dp[i][j] 第i天执行操作获得的最大金额，j=0表示不持股，j=1表示持股
        n = len(prices)
        dp = [[0,0] for _ in range(n)]
        dp[0][0] = 0
        # 买入时扣手续费
        dp[0][1] = -prices[0]-fee
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][0]-prices[i]-fee,dp[i-1][1])
        return dp[n-1][0]

    # 优秀解答
    def maxProfit(self, prices, fee):
        cash, hold = 0, -prices[0]
        for i in range(1, len(prices)):
            cash = max(cash, hold + prices[i] - fee)
            hold = max(hold, cash - prices[i])
        return cash

#优秀解答2 100
class Solution:
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        n = len(prices)
        if n < 2:
             return 0
        ans = 0
        minimum = prices[0]
        for i in range(1, n):
            if prices[i] < minimum:
                minimum = prices[i]
            elif prices[i] > minimum + fee:
                ans += prices[i]-fee-minimum
                minimum = prices[i]-fee
        return ans

s = Solution()
print(s.maxProfit([1, 3, 2, 8, 4, 9],2))
