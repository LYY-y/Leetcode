"""
35.搜索插入位置：
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
"""
class Solution:
    def searchInsert(self, nums, target: int) -> int:
        for i in range(len(nums)-1,-1,-1):
            if target>nums[i]:
                return i+1
            if target==nums[i]:
                return i
        return 0

    def searchInsert2(self, nums, target: int) -> int:
        length=len(nums)
        left=0
        right=length-1
        mid=0
        while left<=right:
            mid=left+((right-left)>>1)
            if nums[mid]>target:
                right=mid-1
            elif nums[mid]<target:
                left=mid+1
                if right<left:
                    return left
            else:
                return mid
        if right<0:
            return 0
        elif left>length-1:
            return length
        else:
            return mid


s=Solution()
print(s.searchInsert2([1,2,4,6,7],5))

"""
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if(not nums):
            return 0
        n=len(nums)
        l=0
        r=n-1
        res=-1
        while(l<=r):
            mid=(l+r)//2
            if(nums[mid]==target):
                return mid
            elif(nums[mid]>target):
                r=mid-1
            else:
                l=mid+1
        res=l
        return res
"""