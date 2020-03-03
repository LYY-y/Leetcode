"""
给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def twoSum(self, numbers, target: int):
        map={}
        for i, num in enumerate(numbers):
            if target-num in map:
                return [map.get(target-num)+1, i+1]
            map[num]=i
        return [-1,-1]

    def twoSum2(self, numbers, target: int):
        left=0
        right=len(numbers)-1
        while True:
            sum = numbers[left] + numbers[right]
            if sum == target:
                return [left+1,right+1]
            elif sum < target:
                left += 1
            else:
                right -= 1

    def twoSum3(self, numbers, target: int):
        lenth = len(numbers);
        i = 0
        while i < lenth:
            n1 = numbers[i]
            n2 = target - n1
            if n2 >= n1:
                if n2 in numbers[i + 1:]:
                    return ([i + 1, numbers[i + 1:].index(n2, 0, lenth) + 2 + i])
            i += numbers.count(n1)
        print("no rulution")





x=Solution()
print(x.twoSum3([2, 7, 11, 15], 9))
print(x.twoSum2([2,3,4], 6))
print(x.twoSum2([-1,0], -1))

