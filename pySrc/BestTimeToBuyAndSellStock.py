"""
买卖股票的最佳时机：
定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。

示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def maxProfit(self, prices) -> int:
        length = len(prices)
        if length < 2:
            return 0
        buy = prices[0]
        sell = buy
        max = 0
        buyIndex = 0
        for index in range(1,length):
            price=prices[index]
            if price > sell and buyIndex < index:
                sell = price
                if sell - buy > max:
                    max = sell - buy
                else:
                    pass
                continue
            if price < buy:
                buy = price
                buyIndex = index
                sell = buy
        return max

    def maxProfit2(self, prices) -> int:
        length = len(prices)
        if length == 0:
            return 0
        low, maxProfit = prices[0], 0
        for price in prices:
            maxProfit = maxProfit if maxProfit > price - low else (price - low)
            low = low if low < price else price
        return maxProfit

    # 动态规划
    def maxProfit3(self, prices) -> int:
        dp_i_0, dp_i_1 = 0, float('-INF')
        for price in prices:
            dp_i_0 = max(dp_i_0, dp_i_1 + price)
            dp_i_1 = max(dp_i_1, -price)
        return dp_i_0
        

s=Solution()
print(s.maxProfit3([7,1,5,3,6,4]))
print(s.maxProfit3([7,6,4,3,1]))
print(s.maxProfit3([2,4,1,9,5]))
