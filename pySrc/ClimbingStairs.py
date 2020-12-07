# 70. 爬楼梯
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
# 注意：给定 n 是一个正整数。

class Solution:
    # 94.24% 33.98%
    def climbStairs(self, n: int) -> int:
        dp = [0]*n
        # 1层楼
        dp[0] = 1
        # 2层楼
        dp[1] = 2
        for i in range(2,n):
            dp[i] = dp[i-1]+1+dp[i-2]+1
        return dp[n-1]

    # 优秀解答
    def climbStairs(self, n: int) -> int:
        if n == 1 or n == 2:
            return n
        a, b, temp = 1, 2, 0
        for i in range(3, n + 1):
            temp = a + b
            a = b
            b = temp
        return temp