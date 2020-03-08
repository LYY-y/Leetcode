"""
414.第三大的数
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
示例 1:
输入: [3, 2, 1]
输出: 1
解释: 第三大的数是 1.
示例 2:
输入: [1, 2]
输出: 2
解释: 第三大的数不存在, 所以返回最大的数 2 .
示例 3:
输入: [2, 2, 3, 1]
输出: 1
解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/third-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 22.37, 35.87
    def thirdMax(self, nums) -> int:
        maxThree = [float('-INF')] * 3
        for num in nums:
            i = 0
            while i < len(maxThree):
                if num in maxThree:
                    break
                if num > maxThree[i]:
                    maxThree.insert(i,num)
                    maxThree.pop()
                    break
                i += 1
        if maxThree[2] != float('-INF'):
            return maxThree[2]
        return maxThree[0]

    # 通过但不好
    def thirdMax2(self, nums) -> int:
        nums = set(nums)
        if len(nums) < 3:
            return max(nums)
        nums.remove(max(nums))
        nums.remove(max(nums))
        return max(nums)

    def thirdMax3(self, nums) -> int:
        maxThree = [float('-INF')] * 3
        for num in nums:
            if num in maxThree:
                continue
            if num > maxThree[2]:
                if num > maxThree[1]:
                    if num > maxThree[0]:
                        maxThree[2] = maxThree[1]
                        maxThree[1] = maxThree[0]
                        maxThree[0] = num
                    else:
                        maxThree[2] = maxThree[1]
                        maxThree[1] = num
                else:
                    maxThree[2] = num
        if maxThree[2] != float('-INF'):
            return maxThree[2]
        return maxThree[0]









s=Solution()
print(s.thirdMax3([3, 2, 1]))
print(s.thirdMax3([2, 2, 3, 1]))
print(s.thirdMax3([5,2,2]))





