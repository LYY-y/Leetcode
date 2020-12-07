# 1518. 换酒问题
# 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
# 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
# 请你计算 最多 能喝到多少瓶酒。
class Solution:
    # 82.27 16.99
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        count = numBottles
        while numBottles >= numExchange:
            last_count = int(numBottles / numExchange)
            count += last_count
            numBottles -= numExchange*last_count
            numBottles += last_count
        return int(count)

    # 优秀解答
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        res = numBottles
        bottle = numBottles
        while bottle / numExchange >= 1:
            bottle -= numExchange
            bottle += 1
            res += 1
        return res

    # 优秀解答
    def numWaterBottles(self, numBottles, numExchange):
        drink = numBottles
        while numBottles // numExchange != 0:
            drink += numBottles // numExchange
            numBottles = numBottles // numExchange + numBottles % numExchange
        return drink

    # 数学法
    # 考虑空瓶换酒，换完再喝，喝完再换的过程——每次换到一瓶酒就意味着多一个空瓶，所以每次损失的瓶子的数量为e - 1，我们要知道这个过程能得到多少瓶酒，即希望知道第一个打破下面这个条件的n是多少：
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        return (numBottles - numExchange) // (numExchange - 1) + 1 + numBottles if numBottles >= numExchange else numBottles


s=Solution()
print(s.numWaterBottles(9,3))