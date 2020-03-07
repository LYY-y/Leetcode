"""
283.移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 98.93%, 25.38%
    def moveZeroes(self, nums):
        n = len(nums) - 1
        i = 0
        count = 0
        while count < n:
            if nums[i] == 0:
                nums.append(nums.pop(i))
                count += 1
                continue
            i += 1
            count += 1
        return nums

    #双指针,将为0的数放在非0的右边
    def moveZeroes2(self, nums):
        n = len(nums)
        if n < 2:
            return nums
        zeroIndex = 0
        for i in range(n):
            if nums[i] != 0:
                nums[zeroIndex], nums[i] = nums[i], nums[zeroIndex]
                zeroIndex += 1
        return nums

    # 遍历数组，无为0的元素移动数组前方，用index下标记录。
    # 遍历结束，对index值后的元素统一设为0
    def moveZeroes3(self, nums):
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index] = nums[i]
                index += 1
        while index < len(nums):
            nums[index] = 0
            index += 1
        return nums





s=Solution()
print(s.moveZeroes3([0,1,0,3,12]))
print(s.moveZeroes3([0,0,1]))

