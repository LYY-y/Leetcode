"""
322.零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    #动态规划
    #自顶向下
    def coinChange(self, coins, amount: int) -> int:
        # 备忘录
        memo = dict()
        # 定义：凑出金额ammount，至少要dp(amount)个硬币
        def dp(n):
            # 查看备忘录：
            if n in memo:
                return memo[n]
            # base case:
            if n == 0:
                return 0
            if n < 0:
                return -1
            #求最小值，所以初始化为正无穷
            res = float('INF')

            # 做选择，选择需要硬币最少的那个结果
            for coin in coins:
                subproblem = dp(n - coin)
                if subproblem == -1: continue
                res = min(res, subproblem + 1)
            # 记入备忘录
            memo[n] = res if res != float('INF') else -1
            return memo[n]
        return dp(amount)

    # 自底向上，使用dp table消除重叠子问题
    # dp[i] = x 表示目标金额为i时，至少需要x枚硬币
    def coinChange2(self, coins, amount: int) -> int:
        # 数组大小为amount + 1, 初始值为 amount + 1
        dp = [amount + 1] * (amount + 1)
        # base case
        dp[0] = 0
        for i in range(len(dp)):
            for coin in coins:
                if i < coin:
                    continue
                dp[i] = min(dp[i], 1 + dp[i - coin])
        return dp[amount] if dp[amount] != amount + 1 else -1



s=Solution()
print(s.coinChange2([1,2,5],11))
print(s.coinChange([186,419,83,408],6429))
print(s.coinChange([2],3))
print(s.coinChange([1],2))


