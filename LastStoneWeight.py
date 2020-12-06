# 1046. 最后一块石头的重量
# 有一堆石头，每块石头的重量都是正整数。
#
# 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
#
# 如果 x == y，那么两块石头都会被完全粉碎；
# 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
# 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
import heapq


class Solution:
    # 47.09 27.06
    def lastStoneWeight(self, stones:list):
        while len(stones) > 1:
            stones.sort()
            max_stone = stones.pop(-1)
            second_stone = stones.pop(-1)
            stones.append(max_stone-second_stone)
        return stones[0] if stones else 0

    # 优秀解答 小顶堆 内建库
    def lastStoneWeight(self, stones) -> int:
        h = [-stone for stone in stones]
        heapq.heapify(h)

        while len(h) > 1:
            a, b = heapq.heappop(h), heapq.heappop(h)
            if a != b:
                heapq.heappush(h, a - b)
        return -h[0] if h else 0

s = Solution()
print(s.lastStoneWeight([2,7,4,1,8,1]))


