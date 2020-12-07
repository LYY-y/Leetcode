"""
485.最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。
示例 1:
输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：
输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-consecutive-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def findMaxConsecutiveOnes(self, nums) -> int:
        for i in range(len(nums) - 1):
            if i > 0 and nums[i-1] == nums[i] and nums[i+1] == 1:
                nums[i] = 0
                continue
            nums[i + 1] += nums[i]
        return max(nums)

    def findMaxConsecutiveOnes2(self, nums) -> int:
        maxOnes, j = 0, 0
        for num in nums:
            if num == 1:
                j += 1
            else:
                maxOnes = max(maxOnes, j)
                j = 0
        return max(maxOnes, j)


s=Solution()
print(s.findMaxConsecutiveOnes2([1,1,0,1,1,1]))
print(s.findMaxConsecutiveOnes2([1,0,1,1,0,1]))


