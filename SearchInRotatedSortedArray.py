"""
搜索旋转排序数组：
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:

    def search(self, nums, target: int) -> int:
        length=len(nums)
        maxIndex=0
        for i in range(length):
            if maxIndex==length-1:
                break
            if nums[maxIndex]<=nums[maxIndex+1]:
                maxIndex=i
        if maxIndex==length-1:
            return self.searchOne(nums,target,0)
        else:
            minIndex=maxIndex+1
            if target==nums[maxIndex]:
                return maxIndex
            elif target==nums[minIndex]:
                return minIndex
            elif target>=nums[0] and target<=nums[maxIndex]:
                return self.searchOne(nums[0:maxIndex+1],target,0)
            elif target<=nums[length-1] and target>=nums[minIndex]:
                return self.searchOne(nums,target,minIndex)
            return -1


    '''在有序列表中二分法查找'''
    def searchOne(self, nums, target: int, left: int) -> int:
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


    """
    方法2：
    """
    def search(self, nums, target: int) -> int:
        length=len(nums)
        left=0
        right=length-1
        while left<right:
            mid=(right+left)>>1
            if target==nums[left]:
                return left
            if target==nums[right]:
                return right
            if target==nums[mid]:
                return mid
            if nums[mid]>=nums[right]>=target or nums[right]>=target>=nums[mid] or target>=nums[mid]>=nums[right]:
                left=mid+1
            else:
                right=mid-1

        return left if target==nums[left] else -1




s=Solution()
print("[5,7,7,1],5 ",s.search([5,7,7,1],5))
print("[1,3,5],5 ",s.search([1,3,5],5))
print("[1,3,5],0 ",s.search([1,3,5],0))
print("[5,7,1],0 ",s.search([5,7,1],0))
print("[5,7,1],5 ",s.search([5,7,1],5))
print("[1,3],0 ",s.search([1,3],0))
print("[1,3],1 ",s.search([1,3],1))
print("[3,1],0 ",s.search([3,1],0))
print("[3,1],3 ",s.search([3,1],3))
print("[1],1 ",s.search([1],1))
print("[2],6 ",s.search([2],6))
print("[4,5,6,7,0,1,2],0 ",s.search([4,5,6,7,0,1,2],0))
print("[4,5,6,7,0,1,2],1 ",s.search([4,5,6,7,0,1,2],1))
print("[4,5,6,7,0,1,2],5 ",s.search([4,5,6,7,0,1,2],5))
print("[4,5,6,7,8,1,2,3],8 ",s.search([4,5,6,7,8,1,2,3],8))


"""
""
    思路不变
    0. 中间位置恰好是target, 直接返回
    1. 递归左边的条件1, 升序, left <= target < middle, 其中left < middle用于确定是升序
    2. 递归左边的条件2, 循环, middle < left <= target(位于7-10部分), 或者 target < middle <left(位于0-1部分)
    3. 其他情况, 递归右边
"""
"""
    方法2, 非递归形式
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l, r = 0, len(nums)-1

        while l <= r:
            m = int((l+r)/2)
            if nums[m] == target: return m
            if nums[l] == target: return l
            if nums[l] < target < nums[m] or nums[m] < nums[l] < target or target < nums[m] < nums[l]: r = m-1
            else: l = m+1
        return -1
"""