"""
665.非递减数列
给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

示例 1:

输入: [4,2,3]
输出: True
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: [4,2,1]
输出: False
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
说明:  n 的范围为 [1, 10,000]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def checkPossibility(self, nums) -> bool:
        n = len(nums)
        count = 0
        if n < 3:
            return True
        for i in range(n-1):
            x = nums[i]
            if nums[i] > nums[i+1]:
                if i > 0:
                    nums[i] = nums[i-1]
                else:
                    nums[i] = nums[i+1]
                if nums[i] > nums[i+1]:
                    nums[i] = x
                    nums[i+1] = x
                count += 1
            if count == 2:
                return False
        return True




s=Solution()
print(False,s.checkPossibility([3,4,2,3]))
print(False,s.checkPossibility([4,2,1]))
print(True,s.checkPossibility([4,2,3]))
print(True,s.checkPossibility([1,3,2]))
print(False,s.checkPossibility([1,5,4,6,7,10,8,9]))
print(True,s.checkPossibility([2,3,3,2,4]))
print(False,s.checkPossibility([3,3,2,2]))

