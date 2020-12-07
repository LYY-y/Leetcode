"""
448.找出所有数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。
您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
示例:
输入:
[4,3,2,7,8,2,3,1]
输出:
[5,6]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 超时
    def findDisappearedNumbers(self, nums):
        n = len(nums)
        if n == 1 and nums[0] == 1:
            return [2]
        disappers = []
        for i in range(1,n+1):
            if i not in nums:
                disappers.append(i)
        return disappers

    # 题解方法：将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
    def findDisappearedNumbers2(self, nums):
        for num in nums:
            index = abs(num) - 1
            nums[index] = -(abs(nums[index]))
        return [i + 1 for i, num in enumerate(nums) if num > 0]

    def findDisappearedNumbers3(self, nums):
        n = len(nums)
        nums = set(nums)
        result = []
        for i in range(1, n + 1):
            if i not in nums:
                result.append(i)
        return result






s=Solution()
print(s.findDisappearedNumbers3([4,3,2,7,8,2,3,1]))
print(s.findDisappearedNumbers2([1]))
print(s.findDisappearedNumbers3([1,1]))
print(s.findDisappearedNumbers2([]))
print(s.findDisappearedNumbers2([1,2]))


