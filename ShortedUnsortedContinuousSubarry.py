"""
581.最短无序连续子数组
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 67.79,8.79
    def findUnsortedSubarray(self, nums) -> int:
        if len(nums) <= 1:
            return 0
        sortNums = sorted(nums)
        begin, last = 0, len(nums) - 1
        while nums[begin] == sortNums[begin]:
            begin += 1
            if begin == last:
                return 0
        while nums[last] == sortNums[last]:
            last -= 1
        return last - begin + 1
s=Solution()
print(s.findUnsortedSubarray([2, 6, 4, 8, 10, 9, 15]))
print(s.findUnsortedSubarray([2,1]))
print(s.findUnsortedSubarray([1]))