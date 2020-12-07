"""
34.在排序数组中查找元素的第一个和最后一个位置：
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def searchRange(self, nums, target: int):
        firstNum=self.search(nums,target,0)
        if firstNum == -1:
            return [-1,-1]
        last = firstNum
        lastNum=-1
        while last != -1 and last+1 < len(nums):
            last=self.search(nums,target,last+1)
            if last != -1:
                lastNum=last
        if lastNum == -1:
            return [firstNum,firstNum]
        else:
            return [firstNum,lastNum]

    def search(self, nums, target: int, left: int) -> int:
        if len(nums) == 0 or (len(nums) == 1 and nums[0] != target):
            return -1
        right = len(nums) - 1
        while left < right:
            mid = left + ((right - left) >> 1)
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        if nums[left] == target:
            return left
        else:
            return -1

s=Solution()
print(s.searchRange([1,1,2,4,6,7,8,8],8))

"""
def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1

        target_index = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                target_index = mid
                break
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        if target_index == -1:
            return [-1, -1]

        ret_left, ret_right = -1, -1
        p1, p2 = target_index, target_index
        while p1 >=0 and nums[p1] == target:
            ret_left = p1
            p1 -= 1

        while p2 < len(nums) and nums[p2] == target:
            ret_right = p2
            p2 += 1

        return [ret_left, ret_right]
"""
