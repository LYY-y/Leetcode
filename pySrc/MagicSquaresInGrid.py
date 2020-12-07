"""
840.矩阵中的幻方
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。

给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

 

示例：

输入: [[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
输出: 1
解释:
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276

而这一个不是：
384
519
762

总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
提示:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/magic-squares-in-grid
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def numMagicSquaresInside(self, grid) -> int:
        i, j, count, rows, cols = 0, 0, 0, len(grid), len(grid[0])
        while i < rows - 2:
            while j < cols - 2:
                if grid[i+1][j+1] == 5 \
                    and grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15 \
                    and grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15 \
                    and grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15 \
                    and grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15 \
                    and grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15 \
                    and grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15 \
                    and grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15 \
                    and grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15 \
                    and self.isValid([grid[i][j], grid[i][j + 1], grid[i][j + 2], grid[i + 1][j],
                                      grid[i + 1][j + 1], grid[i + 1][j + 2], grid[i + 2][j],
                                      grid[i + 2][j + 1], grid[i + 2][j + 2]]):
                    count += 1
                j += 1
            j = 0
            i += 1
        return count

    def isValid(self, list):
        if len(set(list)) != 9:
            return False
        for num in list:
            if num not in range(1, 10):
                return False
        return True


s=Solution()
print(s.numMagicSquaresInside([[4,3,8,4],[9,5,1,9],[2,7,6,2]]))
print(s.numMagicSquaresInside([[5,5,5],[5,5,5],[5,5,5]]))
print(s.numMagicSquaresInside([[3,2,9,2,7],[6,1,8,4,2],[7,5,3,2,7],[2,9,4,9,6],[4,3,8,2,5]]))
print(s.numMagicSquaresInside([[4,3,8,4],[9,5,1,9],[2,7,6,2]]))


