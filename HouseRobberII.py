# 213. 打家劫舍 II
# 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
# 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
# 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

class Solution:
    # 86.24%, 15.46%
    def rob(self, nums) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        return max(self.helper(nums[1:],n-1),self.helper(nums[:-1],n-1))


    def helper(self,nums,n):
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[n-1]

    # 优秀解答
    def rob2(self, nums) -> int:
        n = len(nums)
        if nums == []:
            return 0
        if len(nums) == 1:
            return nums[0]
        # 抢了
        dp = [[0, 0] for _ in range(n)]
        dp[0][1] = nums[0]
        dp[0][0] = float('-inf')
        for i in range(1, n):
            dp[i][1] = dp[i - 1][0] + nums[i]
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        tmp_max = dp[n - 1][0]

        # 没抢
        dp = [[0, 0] for _ in range(n)]
        dp[0][1] = float('-inf')
        dp[0][0] = 0
        for i in range(1, n):
            dp[i][1] = dp[i - 1][0] + nums[i]
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        return max(dp[n - 1][0], dp[n - 1][1], tmp_max)
