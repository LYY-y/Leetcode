"""
661.图片平滑器
包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。

示例 1:

输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
注意:

给定矩阵中的整数范围为 [0, 255]。
矩阵的长和宽的范围均为 [1, 150]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/image-smoother
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    # 95.69, 7
    def imageSmoother(self, M):
        rows = len(M)
        cols = len(M[0])
        result = [[0 for i in range(cols)] for j in range(rows)]
        for row in range(rows):
            for col in range(cols):
                if row == 0 and rows > 1:
                    if col == 0 and cols > 1:
                        result[row][col] = (M[row][col] + M[row][col+1] + M[row+1][col] + M[row+1][col+1]) // 4
                        continue
                    elif col == cols - 1:
                        result[row][col] = (M[row][col] + M[row][col-1] + M[row+1][col] + M[row+1][col-1]) // 4
                        continue
                    else:
                        result[row][col] = (M[row][col-1] + M[row][col] + M[row][col+1] + M[row+1][col-1] + M[row+1][col] + M[row+1][col+1]) // 6
                        continue
                elif row == rows - 1:
                    if col == 0 and cols > 1:
                        result[row][col] = (M[row][col] + M[row][col+1] + M[row-1][col] + M[row-1][col+1]) // 4
                        continue
                    elif col == cols - 1:
                        result[row][col] = (M[row][col] + M[row][col-1] + M[row-1][col] + M[row-1][col-1]) // 4
                        continue
                    else:
                        result[row][col] = (M[row][col-1] + M[row][col] + M[row][col+1] + M[row-1][col-1] + M[row-1][col] + M[row-1][col+1]) // 6
                        continue
                else:
                    if col == 0 and cols > 1:
                        result[row][col] = (M[row][col] + M[row][col+1] + M[row-1][col] + M[row-1][col+1] + M[row+1][col] + M[row+1][col+1]) // 6
                        continue
                    elif col == cols - 1:
                        result[row][col] = (M[row][col] + M[row][col-1] + M[row-1][col] + M[row-1][col-1] + M[row+1][col] + M[row+1][col-1]) // 6
                        continue
                    else:
                        result[row][col] = (M[row][col-1] + M[row][col] + M[row][col+1] + M[row-1][col-1] + M[row-1][col] + M[row-1][col+1] + M[row+1][col-1] + M[row+1][col] + M[row+1][col+1]) // 9
        return result


    # 遍历矩阵
    def imageSmoother2(self, M):
        R, C = len(M), len(M[0])
        ans = [[0] * C for _ in M]

        for r in range(R):
            for c in range(C):
                count = 0
                for nr in (r - 1, r, r + 1):
                    for nc in (c - 1, c, c + 1):
                        if 0 <= nr < R and 0 <= nc < C:
                            ans[r][c] += M[nr][nc]
                            count += 1
                ans[r][c] //= count

        return ans




s=Solution()
print(s.imageSmoother2([[1,1,1],[1,0,1],[1,1,1]]))
print(s.imageSmoother2([[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]))
print(s.imageSmoother2([[1]]))