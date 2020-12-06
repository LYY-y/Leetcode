# 338. 比特位计数
# 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

class Solution:
    # 54.65 41.06
    def countBits(self, num: int):
        dp = [0 for i in range(num + 1)]
        dp[0] = 0
        for i in range(1, num + 1):
            # 若为奇数
            if i & 1 == 1:
                dp[i] = dp[i - 1] + 1
            else:
                dp[i] = dp[i >> 1]
        return dp

    # 优秀解答:1的二进制位等于0的二进制位前面加上1，（2，3）的二进制位等于（0，1）的二进制位前面加上1，（4，5，6，7）的二进制位等于（0，1，2，3）的二进制位前面加上1，
    def countBits(self, num: int):
        if num == 0:
            return [0]
        res = [0]
        count = 2
        while count <= num:
            res.extend([i + 1 for i in res])
            count *= 2
        count //= 2
        res += [i + 1 for i in res[: num - count + 1]]
        return res
