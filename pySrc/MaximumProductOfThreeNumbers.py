"""
628.三个数的最大乘积
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 41.17, 11.17
    def maximumProduct(self, nums) -> int:
        nums.sort()
        if nums[-1] * abs(nums[0]) * abs(nums[1]) > nums[-1] * nums[-2] * nums[-3]:
            return nums[-1] * abs(nums[0]) * abs(nums[1])
        return nums[-1] * nums[-2] * nums[-3]
s=Solution()
print(s.maximumProduct([-1,-2,1,2,3]))
print(s.maximumProduct([-1,-2,-3]))
print(s.maximumProduct([-4,-3,-2,-1,60]))