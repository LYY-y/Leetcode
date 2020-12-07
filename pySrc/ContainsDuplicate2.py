"""
219.存在重复数组2
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def containsNearbyDuplicate(self, nums, k: int) -> bool:
        dict = {}
        for i in range(len(nums)):
            if dict.get(nums[i]) is not None and i - dict.get(nums[i]) <= k:
                return True
            else:
                dict[nums[i]] = i
        return False

s =Solution()
print(s.containsNearbyDuplicate([1,0,1,1],1))
print(s.containsNearbyDuplicate([1,2,3,1,2,3],2))
print(s.containsNearbyDuplicate([99,99],2))