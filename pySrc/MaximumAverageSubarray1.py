"""
643.子数组最大平均数1
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:

输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 

注意:

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 超时
    def findMaxAverage(self, nums, k: int) -> float:
        ave = float('-INF')
        for i in range(len(nums) - k + 1):
            ave = max(ave, sum(nums[i: i + k])/k)
        return ave

    # 87.06, 6.05
    def findMaxAverage2(self, nums, k: int) -> float:
        tempSum = sum(nums[:k])
        maxSum = tempSum
        for i in range(k, len(nums)):
            tempSum = tempSum + nums[i] - nums[i - k]
            maxSum = max(maxSum, tempSum)
        return maxSum / k


s=Solution()
print(s.findMaxAverage2([1,12,-5,-6,50,3], 4))
print(s.findMaxAverage2([5], 1))