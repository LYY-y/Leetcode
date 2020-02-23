'''
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

"""
1、第一个数为flag，依次遍历数组，若等于flag，
   则数组往后遍历直至遇到一个不等于flag的值，才将其存储，循环往复
"""
class Solution:
    def removeDuplicates(self, nums) -> int:
        flag=0
        length=len(nums)
        for i in range(length):
            begin=flag
            while nums[begin]==nums[flag]:
                flag=flag+1
                if flag>length-1:
                    return i+1
            nums[i+1]=nums[flag]
            if nums[i]==nums[length-1]:
                return i+1
nums=[1,1,2,2,2,3,4,4,5,6]
s=Solution()
print(s.removeDuplicates(nums))

"""
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                nums[i+1] = nums[j]
                i += 1
        return i+1
"""