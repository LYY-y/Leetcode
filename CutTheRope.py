# 剑指 Offer 14- I. 剪绳子
# 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
# 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
class Solution:
    # 35.16 6.55
    def cuttingRope(self, n: int) -> int:
        # dp[i]表示长度为i之前的最大的乘积
        dp = [0 for _ in range(n+1)]
        for i in range(2,n+1):
            for j in range(1,i):
                dp[i] = max(max(j*(i-j), j*dp[i-j]),dp[i])
        return dp[n]

    # 优秀解答 数学法
    def cuttingRope(self, n: int) -> int:
        if n <= 2: return 1
        if n == 3: return 2
        res = 1
        while n > 4:
            res *= 3
            n -= 3
        res *= n
        return res

s = Solution()
print(s.cuttingRope(6))