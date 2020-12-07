"""
896.单调数列
如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

 

示例 1：

输入：[1,2,2,3]
输出：true
示例 2：

输入：[6,5,4,4]
输出：true
示例 3：

输入：[1,3,2]
输出：false
示例 4：

输入：[1,2,4,5]
输出：true
示例 5：

输入：[1,1,1]
输出：true
 

提示：

1 <= A.length <= 50000
-100000 <= A[i] <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotonic-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from pip._vendor.msgpack.fallback import xrange


class Solution:
    # 两次遍历
    def isMonotonic(self, A) -> bool:
        n = len(A)
        return self.isUpper(A, n) or self.isLow(A, n)

    def isUpper(self, A, n):
        for i in range(n - 1):
            if A[i] > A[i+1]:
                return False
        return True

    def isLow(self, A, n):
        for i in range(n - 1):
            if A[i] < A[i + 1]:
                return False
        return True

    #一次遍历 20.24 5.15
    def isMonotonic(self, A) -> bool:
        flag = 0
        for i in xrange(len(A) - 1):
            if A[i] < A[i+1]:
                c = 1
            elif A[i] > A[i+1]:
                c = -1
            else:
                c = 0
            if c:
                if c != flag and flag != 0:
                    return False
                flag = c
        return True

    def isMonotonic(self, A) -> bool:
        sortArr = sorted(A)
        if A == sortArr or A == sortArr[::-1]:
            return True
        else:
            return False


s=Solution()
print(s.isMonotonic([1,2,2,3]))
print(s.isMonotonic([6,5,4,4]))
print(s.isMonotonic([1,3,2]))
print(s.isMonotonic([1,2,4,5]))
print(s.isMonotonic([1,1,1]))
print(s.isMonotonic([11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5]))

