# 861.翻转矩阵后的得分
# 有一个二维矩阵A其中每个元素的值为0或1 。移动是指选择任一行或列，并转换该行或列中的每一个值：将所有0都更改为1，将所有1都更改为0。
# 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。返回尽可能高的分数。

# class Solution:
#     def matrixScore(self, A) -> int:
#         # 行m、列n
#         m = len(A)
#         n = len(A[0])
#         i = 0
#         j = 0
#         while i < m:
#             while j < n:
#  官方题解
class Solution(object):
    def matrixScore(self, A):
        R, C = len(A), len(A[0])
        ans = 0
        for c in range(C):
            col = 0
            for r in range(R):
                col += A[r][c] ^ A[r][0]
            ans += max(col, R - col) * 2 ** (C - 1 - c)
        return ans

s = Solution()
print(s.matrixScore([[0,0,1,1],[1,0,1,0],[1,1,0,0]]))

