# 剑指Offer
# 42.连续子数组的最大和
# 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
# 要求时间复杂度为O(n)。

# 示例1:
#
# 输入: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
# 输出: 6
# 解释: 连续子数组[4, -1, 2, 1]
# 的和最大，为6。
class Solution:
    # 95.41% 6.20%
    def maxSubArray(self, nums) -> int:
        arr = [0]*(len(nums))
        arr[0] = nums[0]
        for i in range(1,len(nums)):
            if arr[i-1] >= 0:
                arr[i] = arr[i-1]+nums[i]
            else:
                arr[i] = nums[i]
        return max(arr)

    # 优秀解答
    def maxSubArray(self, nums) -> int:
        length = len(nums)
        res = -101
        s = 0
        for r in range(length):
            # print(s)
            if s <= 0 and nums[r] > s:
                s = nums[r]
            else:
                s += nums[r]
            if s > res:
                res = s
        return res

