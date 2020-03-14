"""
849.到最近的人的最大距离
在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。

至少有一个空座位，且至少有一人坐在座位上。

亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。

返回他到离他最近的人的最大距离。

示例 1：

输入：[1,0,0,0,1,0,1]
输出：2
解释：
如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
因此，他到离他最近的人的最大距离是 2 。
示例 2：

输入：[1,0,0,0]
输出：3
解释：
如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
这是可能的最大距离，所以答案是 3 。
提示：

1 <= seats.length <= 20000
seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
import math
class Solution:
    # 记录开头连续0，结尾连续0，中间连续0的最大值/2，三者取最大值
    def maxDistToClosest(self, seats) -> int:
        count0, count, i, n = 0, 0, 0, len(seats)
        for j in range(n-1, -1 , -1):
            if seats[j] == 1:
                count0 = max(count0, n - j - 1)
                break
        if j == 0:
            return count0
        while seats[i] != 1:
            i += 1
        count0 = max(count0, i)
        if i == n - 1:
            return count0
        i += 1
        begin = i
        while i < n:
            if seats[i] == 1:
                count = max(count, i - begin)
                begin = i + 1
            i += 1
        return max(math.ceil(count / 2), count0)

    # 记录1的位置，求最大的差值, 47.84  14.86
    def maxDistToClosest(self, seats) -> int:
        arr, maxDist = [], 0
        for i, seat in enumerate(seats):
            if seat == 1:
                arr.append(i)
        maxDist = max(arr[0], len(seats) - arr[-1] - 1)
        for i in range(len(arr) - 1):
            maxDist = max(maxDist, (arr[i+1] - arr[i]) >> 1)
        return maxDist

    # 优秀解答
    def maxDistToClosest(self, seats) -> int:
        max_len = 1
        length = 0
        pre_len = -1
        for i, seat in enumerate(seats):
            if seat == 0:
                length += 1
            else:
                if length > 0:
                    if pre_len < 0 and seats[0] == 0:
                        pre_len = length
                    elif length > max_len:
                        max_len = length
                    length = 0
        return max(max_len // 2 + max_len % 2, pre_len, length)

    # 优秀解答，从左右两边记录
    def maxDistToClosest(self, seats) -> int:
        N = len(seats)
        left, right = [N] * N, [N] * N

        for i in range(N):
            if seats[i] == 1:
                left[i] = 0
            elif i > 0:
                left[i] = left[i - 1] + 1

        for i in range(N - 1, -1, -1):
            if seats[i] == 1:
                right[i] = 0
            elif i < N - 1:
                right[i] = right[i + 1] + 1
        return max(min(left[i], right[i]) for i, seat in enumerate(seats) if not seat)




s=Solution()
print(2, s.maxDistToClosest([1,0,0,0,1,0,1]))
print(3, s.maxDistToClosest([1,0,0,0]))
print(1, s.maxDistToClosest([1,0,0,1]))
print(2, s.maxDistToClosest([0,0,1,0,1,1]))

            



