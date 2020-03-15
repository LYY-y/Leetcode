"""
941.有效的山脉数组
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]
 

示例 1：

输入：[2,1]
输出：false
示例 2：

输入：[3,5,5]
输出：false
示例 3：

输入：[0,3,2,1]
输出：true
 

提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 81.97 5.26
    def validMountainArray(self, A) -> bool:
        n = len(A)
        if n < 3:
            return False
        i = 0
        while i < n - 1 and A[i] < A[i+1]:
            i += 1
        if i == n - 1 or A[i] == A[i+1] or i == 0 :
            return False
        while i < n - 1 and A[i] > A[i+1]:
            i += 1
        return i == n - 1 and A[-1] < A[-2]

    #双指针 61.48 5.26
    def validMountainArray(self, A) -> bool:
        n = len(A)
        if n < 3:
            return False
        l, r = 0, n-1
        while l < n - 2 and A[l] < A[l+1]:
            l += 1
        while r > 1 and A[r] < A[r-1]:
            r -= 1
        return l == r
s=Solution()
print(s.validMountainArray([0,1,2,1,2]))
print(s.validMountainArray([1,7,9,5,4,1,2]))
print(s.validMountainArray([0,3,2,1]))
print(s.validMountainArray([2,0,2]))
print(s.validMountainArray([1,2,3]))
print(s.validMountainArray([3,2,1]))


