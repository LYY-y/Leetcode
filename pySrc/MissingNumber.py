"""
268.缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
示例 1:
输入: [3,0,1]
输出: 2
示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    #5.02%,25.31%
    def missingNumber(self, nums) -> int:
        for i in range(len(nums)+1):
            if i not in nums:
                return i

    #95.33%, 22.94%
    #利用数学法，但有可能造成溢出，最好一边加一边减
    def missingNumber2(self, nums) -> int:
        sum = 0
        isHaveZero = False
        for num in nums:
            if num == 0:
                isHaveZero = True
            sum += num
        if not isHaveZero:
            return 0
        maxNum = max(nums)
        temp = (maxNum * (maxNum + 1) >> 1)
        if temp == sum:
            return maxNum + 1
        return temp - sum
    #改善上面的数学法
    #96.94%，25.31%
    def missingNumber3(self, nums) -> int:
        sum = 0
        for i, num in enumerate(nums):
            sum += i+1
            sum -= num
        return sum

    #位运算法
    def missingNumber4(self, nums) -> int:
        miss = len(nums)
        for i, num in enumerate(nums):
            miss ^= i ^ num
        return miss

s = Solution()
print(s.missingNumber4([1,0]))
print(s.missingNumber4([1]))
print(s.missingNumber4([0]))
print(s.missingNumber4([3,0,1]))
print(s.missingNumber4([9,6,4,2,3,5,7,0,1]))