"""
977.有序数组的平方
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

 

示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
 

提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 直接排序 55.53, 5.26
    def sortedSquares(self, A):
        A = [a ** 2 for a in A]
        return sorted(A)

    # 双指针 32,5.26
    def sortedSquares(self, A):
        l, r = 0, len(A) - 1
        result = [0 for i in range(r+1)]
        k = len(result) - 1
        while l <= r:
            if abs(A[l]) > abs(A[r]):
                result[k] = A[l] ** 2
                l += 1
            else:
                result[k] = A[r] ** 2
                r -= 1
            k -= 1
        return result



s=Solution()
print(s.sortedSquares([-4,-1,0,3,10]))
print(s.sortedSquares([-7,-3,2,3,11]))