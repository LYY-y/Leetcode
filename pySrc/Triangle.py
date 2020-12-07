# 120. 三角形最小路径和
# 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
#
# 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
class Solution:
    # 13.06 6.18
    def minimumTotal(self, triangle) -> int:
        n = len(triangle)
        if n < 1:
            return 0
        if n == 1:
            return triangle[0][0]
        # dp[i][j] 代表在第i层选择第j个元素前的最小路径
        dp = [[0 for _ in range(n)] for _ in range(n)]
        # 初始化
        dp[0][0] = triangle[0][0]
        for i in range(1,n):
            for j in range(i+1):
                if j == 0:
                    dp[i][j] = dp[i-1][j] + triangle[i][j]
                elif j == i:
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
        # 遍历最下一层
        res = float('inf')
        for i in range(n):
            res = min(res,dp[n-1][i])
        return res

    # 官方优化
    def minimumTotal(self, triangle) -> int:
        n = len(triangle)
        f = [[0] * n for _ in range(n)]
        f[0][0] = triangle[0][0]

        for i in range(1, n):
            f[i][0] = f[i - 1][0] + triangle[i][0]
            for j in range(1, i):
                f[i][j] = min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j]
            f[i][i] = f[i - 1][i - 1] + triangle[i][i]

        return min(f[n - 1])

    # 官方优化
    def minimumTotal(self, triangle) -> int:
        n = len(triangle)
        f = [[0] * n for _ in range(2)]
        f[0][0] = triangle[0][0]

        for i in range(1, n):
            curr, prev = i % 2, 1 - i % 2
            f[curr][0] = f[prev][0] + triangle[i][0]
            for j in range(1, i):
                f[curr][j] = min(f[prev][j - 1], f[prev][j]) + triangle[i][j]
            f[curr][i] = f[prev][i - 1] + triangle[i][i]

        return min(f[(n - 1) % 2])


    # 官方优化
    def minimumTotal(self, triangle) -> int:
        n = len(triangle)
        f = [0] * n
        f[0] = triangle[0][0]

        for i in range(1, n):
            f[i] = f[i - 1] + triangle[i][i]
            for j in range(i - 1, 0, -1):
                f[j] = min(f[j - 1], f[j]) + triangle[i][j]
            f[0] += triangle[i][0]

        return min(f)



s=Solution()
print(s.minimumTotal([[2],[3,4],[6,5,7],[4,1,8,3]]))