# 剑指 Offer 14- II. 剪绳子 II
# 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
# 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
# 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
class Solution:
    # 5.01 21.45
    def cuttingRope(self, n: int) -> int:
        # dp[i]代表长度为i所得的最大乘积
        dp = [0 for _ in range(n + 1)]
        for i in range(2, n + 1):
            for j in range(1, i):
                dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
        return dp[n] % (1000000007)

    # 优秀解答
    def cuttingRope(self, n: int) -> int:
        sm = [0, 1, 1, 2, 4]
        if n <= 4:
            return sm[n]
        a = n // 3
        b = n % 3
        if b == 0:
            return 3 ** a % 1000000007
        else:
            return 3 ** (a + b - 2) * (6 - 2 * b) % 1000000007

    # 优秀解答
    def cuttingRope(self, n: int) -> int:

        if n <= 3: return n - 1

        res = 1

        while n > 4:
            n = n - 3
            res = res * 3 % 1000000007

        return res * n % 1000000007