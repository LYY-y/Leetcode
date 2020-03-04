"""
旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    #27.28% ，100%
    def rotate(self, nums, k: int) -> None:
        for i in range(k):
            nums.insert(0,nums.pop())
        return nums

    # 97.25%,100.00%
    def rotate2(self, nums, k: int) -> None:
        n = len(nums)
        k = k % n
        self.myReverse(nums,0,len(nums)-1)
        self.myReverse(nums,0,k-1)
        self.myReverse(nums,k,len(nums)-1)
        return nums

    def myReverse(self,nums,start,end):
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -=1
        return nums

    def rotate3(self, nums, k: int) -> None:








s=Solution()
print(s.rotate2([1,2,3,4,5,6,7],3))
