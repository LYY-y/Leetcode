"""
832.翻转图像
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

示例 1:

输入: [[1,1,0],[1,0,1],[0,0,0]]
输出: [[1,0,0],[0,1,0],[1,1,1]]
解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
示例 2:

输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
说明:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flipping-an-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
import math


class Solution:
    # 53.8, 7.90
    def flipAndInvertImage(self, A):
        r, c = len(A), len(A[0])
        for i in range(r):
            A[i].reverse()
            for j in range(c):
                A[i][j] ^= 1
        return A

    # 53.8, 7.90
    def flipAndInvertImage2(self, A):
        r, c, l = len(A), len(A[0]) >> 1, len(A)
        for i in range(r):
            if l & 1 != 0:
                A[i][c] ^= 1
            for j in range(c):
                A[i][j], A[i][l-j-1] = A[i][l-j-1] ^ 1, A[i][j] ^ 1
        return A

    #两数相同反转，两数不同不做处理
    def flipAndInvertImage3(self, A):
        for r in A:
            for j in range((len(r) + 1) >> 1):
                if r[j] == r[-1-j]:
                    r[j] = r[-1-j] = r[j] ^ 1
        return A

     # 100
    def flipAndInvertImage4(self, A):
        ll = []
        for i in A:
            l = []
            for j in i:
                if j == 0:
                    l.insert(0, 1)
                else:
                    l.insert(0, 0)
            ll.append(l)
        return ll



s=Solution()
print(s.flipAndInvertImage2([[1,1,0],[1,0,1],[0,0,0]]))
print(s.flipAndInvertImage2([[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]))

print(s.flipAndInvertImage4([[1,1,0],[1,0,1],[0,0,0]]))
print(s.flipAndInvertImage4([[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]))