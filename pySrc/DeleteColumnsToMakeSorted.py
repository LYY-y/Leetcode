# 944. 删列造序
# 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
# 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
# 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。（可以参见 删除操作范例）

class Solution:
    # 14.92 20.38
    def minDeletionSize(self, A) -> int:
        # A中字符串的数目
        n = len(A)
        # 每一个字符串字符个数
        sLen = len(A[0])
        i = 0
        res = 0
        while i < sLen:
            for j in range(1,n):
                if ord(A[j][i]) - ord(A[j-1][i]) < 0:
                    res += 1
                    break
            i += 1
        return res

    # 优秀解答
    def minDeletionSize(self, A) -> int:
        ans = 0
        for i in zip(*A):
            i = list(i)
            if i != sorted(i):
                ans += 1
        return ans

    # 官方解答 贪心算法
    def minDeletionSize(self, A):
        ans = 0
        for col in zip(*A):
            if any(col[i] > col[i + 1] for i in range(len(col) - 1)):
                ans += 1
        return ans

