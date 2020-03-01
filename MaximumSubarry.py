"""
最大子序和：
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
"""
class Solution:
    def maxSubArray(self, nums) -> int:
        if len(nums)==1:
            return nums[0]
        sum = 0
        max = nums[0]
        for nums in nums:
            if sum>0:
                sum+=nums
            else:
                sum=nums
            if max<sum:
                max=sum
        return max

    def maxSubArray2(self, nums) -> int:
        length = len(nums)
        for i in range(1,length):
            temp = nums[i]+nums[i-1]
            if nums[i] < temp:
                nums[i] = temp
        return max(nums)


s=Solution()
print(s.maxSubArray2([1,2]))
