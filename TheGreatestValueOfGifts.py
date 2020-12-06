# 剑指Offer47.礼物的最大价值
# 在一个m * n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
# 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

class Solution:
    # 53.92 91.92
    def maxValue(self, grid) -> int:
        m = len(grid)
        n = len(grid[0])
        tops = [0 for _ in range(n)]
        left = grid[0][0]
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    tops[j] = grid[i][j]
                elif i == 0:
                    tops[j] = tops[j-1] + grid[i][j]
                elif j == 0:
                    left = tops[j]+grid[i][j]
                    tops[j] = left
                else:
                    tops[j] = max(left,tops[j])+grid[i][j]
                    left = tops[j]
        return tops[n-1]

    # 优秀解答
    def maxValue2(self, grid) -> int:
        m, n = len(grid), len(grid[0])
        for j in range(1, n):  # 初始化第一行
            grid[0][j] += grid[0][j - 1]
        for i in range(1, m):  # 初始化第一列
            grid[i][0] += grid[i - 1][0]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += max(grid[i][j - 1], grid[i - 1][j])
        return grid[-1][-1]

s = Solution()
print(s.maxValue([[1,3,1],[1,5,1],[4,2,1]]))
