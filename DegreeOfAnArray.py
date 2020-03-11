"""
697.数组的度
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6
注意:

nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 5.01, 20.53
    def findShortestSubArray(self, nums) -> int:
        n = len(nums)
        hashMap = {}
        degree, minLen = 0, float('INF')
        numArr = []
        for i in range(n):
            if nums[i] in hashMap:
                hashMap[nums[i]] += 1
            else:
                hashMap[nums[i]] = 1
        degree = max(hashMap.values())
        for key, value in hashMap.items():
            if value == degree:
                numArr.append(key)
        for num in numArr:
            i, start, count = 0, -1, 0
            while i < n:
                if nums[i] == num:
                    if start == -1:
                        start = i
                    count += 1
                    if count == degree:
                        minLen = min(minLen, i - start + 1)
                        break
                i += 1
        return minLen

    def findShortestSubArray2(self, nums) -> int:
        n = len(nums)
        hashMap = {}
        degree, minLen = 0, float('INF')
        numArr = []
        for i in range(n):
            if nums[i] in hashMap:
                hashMap[nums[i]] += 1
            else:
                hashMap[nums[i]] = 1
        degree = max(hashMap.values())
        for key, value in hashMap.items():
            if value == degree:
                numArr.append(key)
        for num in numArr:
            l, r = 0, n - 1
            while nums[l] != num:
                l += 1
            while nums[r] != num:
                r -= 1
            minLen = min(minLen, r - l + 1)
            if minLen == 2:
                return 2
        return minLen

    #优秀解答
    def findShortestSubArray3(self, nums) -> int:
        a = {}
        for i in range(len(nums)):
            if nums[i] not in a:
                a[nums[i]] = [i]
            else:
                a[nums[i]].append(i)
        m = 0
        for i in a:
            m = max(m, len(a[i]))
        r = len(nums)
        for i in a:
            if len(a[i]) == m:
                r = min(r, a[i][-1] - a[i][0] + 1)
        return r

s=Solution()
print(s.findShortestSubArray3([1, 2, 2, 3, 1]))
print(s.findShortestSubArray3([1,2,2,3,1,4,2]))