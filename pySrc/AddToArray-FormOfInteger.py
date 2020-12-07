"""
989.数组形式的整数加法
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

 

示例 1：

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
示例 2：

输入：A = [2,7,4], K = 181
输出：[4,5,5]
解释：274 + 181 = 455
示例 3：

输入：A = [2,1,5], K = 806
输出：[1,0,2,1]
解释：215 + 806 = 1021
示例 4：

输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
输出：[1,0,0,0,0,0,0,0,0,0,0]
解释：9999999999 + 1 = 10000000000
 

提示：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
如果 A.length > 1，那么 A[0] != 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    #73.64 5.49
    def addToArrayForm(self, A, K: int):
        i = len(A) - 1
        while K > 0 and i >= 0:
            A[i] += K % 10
            K //= 10
            j = i
            while j > 0 and A[j] > 9:
                A[j] -= 10
                A[j-1] += 1
                j -= 1
            i -= 1
        while K != 0:
            if A[0] > 9:
                A[0] -= 10
                A.insert(0, K % 10 + 1)
            else:
                A.insert(0, K % 10)
            K //= 10
        if A[0] > 9:
            A[0] -= 10
            A.insert(0, 1)
        return A

    #75.2 5.49
    def addToArrayForm(self, A, K: int):
        i = len(A) - 1
        while K > 0 and i >= 0:
            K += A[i]
            A[i] = K % 10
            K //= 10
            i -= 1
        while K != 0:
            A.insert(0, K % 10)
            K //= 10
        return A

s=Solution()
print(s.addToArrayForm([1,2,0,0], 34))
print(s.addToArrayForm([2,7,4], 181))
print(s.addToArrayForm([2,1,5], 806))
print(s.addToArrayForm([9,9,9,9,9,9,9,9,9,9], 1))
print(s.addToArrayForm([0], 123))
print(s.addToArrayForm([6], 809))

