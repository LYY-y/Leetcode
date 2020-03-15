"""
985.
给出一个整数数组 A 和一个查询数组 queries。

对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。

（此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）

返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。

 

示例：

输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
输出：[8,6,2,4]
解释：
开始时，数组为 [1,2,3,4]。
将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 

提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
1 <= queries.length <= 10000
-10000 <= queries[i][0] <= 10000
0 <= queries[i][1] < A.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 5.17, 5.38
    def sumEvenAfterQueries(self, A, queries):
        result = []
        evenSum = 0
        for i, a in enumerate(A):
            if a & 1 == 0:
                evenSum += a
        for query in queries:
            temp = A[query[1]]
            A[query[1]] += query[0]
            # 若加数为偶数
            if query[0] & 1 == 0:
                # 偶数+偶数
                if temp & 1 == 0:
                    evenSum += query[0]
                # 偶数+奇数
                else:
                    pass
            # 若加数为奇数
            else:
                # 奇数+偶数
                if temp & 1 == 0:
                    evenSum -= temp
                # 奇数+奇数
                else:
                    evenSum += A[query[1]]
            result.append(evenSum)
        return result

    # 66.41 5.38
    def sumEvenAfterQueries(self, A, queries):
        s = sum(x for x in A if x % 2 == 0)
        result = []
        for i, j in queries:
            if A[j] & 1 == 0:
                s -= A[j]
            A[j] += i
            if A[j] & 1 == 0:
                s += A[j]
            result.append(s)
        return result



s=Solution()
print(s.sumEvenAfterQueries([1,2,3,4], [[1,0],[-3,1],[-4,0],[2,3]]))
print(s.sumEvenAfterQueries([1], [[4,0]]))

