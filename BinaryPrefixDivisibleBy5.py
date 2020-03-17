"""
1018.可被5整除的二进制前缀
给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。

 

示例 1：

输入：[0,1,1]
输出：[true,false,false]
解释：
输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
示例 2：

输入：[1,1,1]
输出：[false,false,false]
示例 3：

输入：[0,1,1,1,1,1]
输出：[true,false,false,false,true,false]
示例 4：

输入：[1,1,1,0,1]
输出：[false,false,false,false,false]
 

提示：

1 <= A.length <= 30000
A[i] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 41.45 5.33
    def prefixesDivBy5(self, A):
        i, num, n = 0, 0, len(A)
        res = []
        while i < n:
            num = 2 * num + A[i]
            if num % 5 == 0:
                res.append(True)
            else:
                res.append(False)
            i += 1
        return res
    #95.07 5.33
    def prefixesDivBy5(self, A):
        temp = 0
        for i,num in enumerate(A):
            temp = (temp * 2 + num) % 5
            A[i] = (temp % 5 == 0)
        return A

s=Solution()
print(s.prefixesDivBy5([0,1,1]))
print(s.prefixesDivBy5([1,1,1]))
print(s.prefixesDivBy5([0,1,1,1,1,1]))
print(s.prefixesDivBy5([1,1,1,0,1]))
print(s.prefixesDivBy5([1,1,0,0,0,1,0,0,1]))
