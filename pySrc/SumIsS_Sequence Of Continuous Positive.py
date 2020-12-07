"""
57.和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
"""
class Solution:
    #86.16%,100%
    def findContinuousSequence(self, target: int):
        result = []
        p,q = 1,1
        sum = 0
        while q - p > 1 or p == q:
            while sum < target:
                sum += q
                q += 1
            if sum == target:
                result.append(list(range(p, q)))
            sum -= p
            p += 1
        return result
"""
还有数学法，利用求和
"""
s = Solution()
print(s.findContinuousSequence(9))
print(s.findContinuousSequence(15))