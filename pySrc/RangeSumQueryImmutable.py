# 303. 区域和检索 - 数组不可变
# 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
#
# 实现 NumArray 类：
#
# NumArray(int[] nums) 使用数组 nums 初始化对象
# int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
# 99.62% 27.61%
class NumArray:
    arr = []
    def __init__(self, nums):
        self.arr = [0,]
        for i in range(len(nums)):
            self.arr.append(self.arr[i]+nums[i])

    def sumRange(self, i: int, j: int) -> int:
        return self.arr[j+1]-self.arr[i]