"""
922.按奇偶排序数组2
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 

示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 

提示：

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    #两次遍历 53.95 5.81
    def sortArrayByParityII(self, A):
        i, n, evens, odds = 0, len(A), [], []
        for a in range(0,n-1,2):
            if A[a] & 1 != 0:
                odds.append(a)
        for a in range(1,n,2):
            if A[a] & 1 == 0:
                evens.append(a)
        for i in range(len(evens)):
            A[evens[i]], A[odds[i]] = A[odds[i]], A[evens[i]]
        return A

    # 双指针 75.97, 5.85
    def sortArrayByParityII(self, A):
        odd = 1
        for even in range(0, len(A), 2):
            if A[even] & 1 != 0:
                while A[odd] & 1 != 0:
                    odd += 2
                A[even], A[odd] = A[odd], A[even]
        return A

s=Solution()
print(s.sortArrayByParityII([4,2,5,7]))