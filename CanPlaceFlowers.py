"""
605.种花问题
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
注意:

数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-place-flowers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 27.64, 10.82
    def canPlaceFlowers(self, flowerbed, n: int) -> bool:
        length = len(flowerbed)
        if length == 1:
            if flowerbed[0] == 0:
                return n <= 1
            else:
                return n <= 0
        flowers = 0
        i = 1

        if flowerbed[0] == flowerbed[1]:
            flowerbed[0] = 1
            flowers += 1
        while i < length - 1:
            if flowerbed[i] ==  flowerbed[i + 1] == flowerbed[i - 1] == 0:
                flowers += 1
                flowerbed[i] = 1
                i += 2
            else:
                i += 1
        if flowerbed[length - 1] == flowerbed[length - 2]:
            flowerbed[length - 1] = 1
            flowers += 1
        return flowers >= n

    #前后补0
    def canPlaceFlowers2(self, flowerbed, n: int) -> bool:
        flowerbed = [0] + flowerbed + [0]
        i = 1
        while i < len(flowerbed) - 1:
            if flowerbed[i - 1] ==0 and flowerbed[i] == 0 and flowerbed[i + 1] == 0:
                n -= 1
                if n <= 0:
                    return True
                flowerbed[i] = 1
                i += 2
            else:
                i += 1
        return n <= 0

s=Solution()
print(s.canPlaceFlowers2([1,0,0,0,0,1],2))
print(s.canPlaceFlowers2([0,1,0],1))
print(s.canPlaceFlowers2([1,0,1,0,1,0,1],0))



