# 198.打家劫舍
# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
# 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
# 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

class Solution:
    def rob(self, nums) -> int:
        n = len(nums)
        # dp[i]代表第i天之前接的总时间
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,n):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        return dp[n-1]

    # 优秀解答
    def rob(self, nums) -> int:
        if not nums or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        tmp_1 = nums[0]
        tmp_2 = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            tmp_1, tmp_2 = tmp_2, max(tmp_2, tmp_1 + nums[i])
        return tmp_2