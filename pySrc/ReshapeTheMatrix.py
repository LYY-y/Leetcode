"""
566.重塑矩阵
在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。

给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。

重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。

如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

示例 1:

输入:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
输出:
[[1,2,3,4]]
解释:
行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
示例 2:

输入:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
输出:
[[1,2],
 [3,4]]
解释:
没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
注意：

给定矩阵的宽和高范围在 [1, 100]。
给定的 r 和 c 都是正数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reshape-the-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 18.31, 11.05
    def matrixReshape(self, nums, r: int, c: int):
        r0, c0 = len(nums), len(nums[0])
        mat = [[0 for i in range(c)] for j in range(r)]
        row, col, i, j = 0, 0, 0, 0
        if r0 * c0 != r * c:
            return nums
        while row < r:
            while col < c:
                if j >= c0:
                    j = 0
                    i += 1
                mat[row][col] = nums[i][j]
                j += 1
                col += 1
            row += 1
            col = 0
        return mat

    # 先变成一维数组
    def matrixReshape2(self, nums, r: int, c: int):
        if len(nums) * len(nums[0]) != r * c:
            return nums
        arr, mat = [], []
        for rows in nums:
            arr += rows
        for i in range(0, len(arr), c):
            mat.append(arr[i:i+c])
        return mat

    # 内存最小解答
    def matrixReshape3(self, nums, r, c):
        size = len(nums) * len(nums[0])
        if r * c == size:
            flatten = [i for row in nums for i in row]
            return list(zip(*[iter(flatten)] * c))
        else:
            return nums


s=Solution()
print(s.matrixReshape3([[1,2],[3,4],[5,6],[7,8],[9,10],[11,12]],4,3))