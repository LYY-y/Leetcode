"""
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
# 同以下方法
    def removeElement(self, nums, val: int) -> int:
        i=0
        for num in nums:
            if num!=val:
                nums[i]=num
                i+=1
        return len(nums) and i+1

# 双指针
    def removeElement2(self, nums, val: int) -> int:
        i=0
        for j in range(len(nums)):
            if nums[j]!=val:
                nums[i]=nums[j]
                i+=1
        return len(nums) and i

nums=[0,1,2,2,3,0,4,2]
s=Solution()
print(s.removeElement2(nums,2))
