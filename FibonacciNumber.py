"""
509.斐波那契数
斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。
示例 1：
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
示例 2：
输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
示例 3：
输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
提示：
0 ≤ N ≤ 30
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fibonacci-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 递归，记忆化自顶向下的方法
    #79.1%,15.32%
    memo = {}
    def fib(self, N: int) -> int:
        if N < 2:
            return N
        if self.memo.get(N):
            return self.memo[N]
        self.memo[N] = self.fib(N - 1) + self.fib(N - 2)
        return self.memo[N]

    # 记忆化自底向上的方法
    # 79% , 15.32%
    def fib3(self, N: int) -> int:
        if N == 0:
            return 0
        if N < 3:
            return 1
        prev, curr= 1, 1
        for i in range(N - 2):
            curr = prev + curr
            prev = curr - prev
        return curr



s=Solution()
print(s.fib3(4))
print(s.fib3(1))

