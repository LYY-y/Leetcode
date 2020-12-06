class Solution:
    # 41.38 12.27
    def waysToStep(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n == 3:
            return 4
        dp = [0 for _ in range(n+1)]
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for i in range(4,n+1):
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
        return dp[n]

# 优秀解答 快速幂方法
class Solution:
    def waysToStep(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        elif n == 3:
            return 4
        else:
            a = [[1, 2, 4]]
            b = [
                [0, 0, 1],
                [1, 0, 1],
                [0, 1, 1],
            ]

            def matrix_multiply(x, y):
                z = [[0] * len(y[0]) for _ in range(len(x))]
                for i in range(len(x)):
                    for j in range(len(y[0])):
                        for k in range(len(x[0])):
                            z[i][j] += x[i][k] * y[k][j]
                        z[i][j] %= 1000000007
                return z

            def matrix_power(x, p):
                res = [[0] * len(x) for _ in range(len(x))]

                for i in range(len(x)):
                    res[i][i] = 1

                while p:
                    if p & 1:
                        res = matrix_multiply(res, x)

                    x = matrix_multiply(x, x)
                    p = p >> 1

                return res

            return matrix_multiply(a, matrix_power(b, n - 3))[0][2]

