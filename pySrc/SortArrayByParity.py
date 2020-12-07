"""
905.按奇偶排序数组
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 

示例：

输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 

提示：

1 <= A.length <= 5000
0 <= A[i] <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 35.35 5.55
    def sortArrayByParity(self, A):
        evens, odds = [], []
        for num in A:
            if num & 1 == 1:
                odds.append(num)
            else:
                evens.append(num)
        return evens + odds

    def sortArrayByParity(self, A):
        A.sort(key=lambda x: x % 2)
        return A

    # 双指针 35.35 5.55
    def sortArrayByParity(self, A):
        l, r = 0, len(A) - 1
        while l < r:
            while A[l] % 2 == 0 and l < r:
                l += 1
            while A[r] % 2 == 1 and l < r:
                r -= 1
            A[l], A[r] = A[r], A[l]
        return A


s=Solution()
print(s.sortArrayByParity([3,1,2,4]))