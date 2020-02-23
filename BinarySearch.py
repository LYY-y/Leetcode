"""
二分查找：
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def search(self, nums, target: int) -> int:
        if len(nums)==0 or (len(nums)==1 and nums[0]!=target):
            return -1
        left=0
        right=len(nums)-1
        while left<right:
            mid=left+((right-left)>>1)
            if nums[mid]<target:
                left=mid+1
            else:
                right=mid

        if nums[left]==target:
            return left
        else:
            return -1

s=Solution()
print(s.search([1,2,4,6,7],8))

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        '''
        if target not in nums:
            return -1
        for i in range(len(nums)):
            if nums[i]==target:
                return i
        '''
        i=0
        j=len(nums)-1
        while i<j or i==j:
            mid=(i+j)//2

            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                i=mid+1
            else:
                j=mid-1
        return -1
"""