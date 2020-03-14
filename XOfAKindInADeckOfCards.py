"""
914.卡牌分组
给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。

 

示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
示例 2：

输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。
示例 3：

输入：[1]
输出：false
解释：没有满足要求的分组。
示例 4：

输入：[1,1]
输出：true
解释：可行的分组是 [1,1]
示例 5：

输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]

提示：

1 <= deck.length <= 10000
0 <= deck[i] < 10000
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""
import collections


class Solution:
    # 89.5 5.59
    def hasGroupsSizeX(self, deck) -> bool:
        copy = list(set(deck))
        counts = []
        for x in copy:
            counts.append(deck.count(x))
        k = self.selfGcd(counts[0], counts[0])
        for i in range(1, len(copy)):
            k = self.selfGcd(k, counts[i])
        return True if k >= 2 else False

    def selfGcd(self,x, y):
        while y:
            x, y = y, x % y
        return x
    # 优秀解答
    def hasGroupsSizeX(self, deck) -> bool:
        # 获取出现次数
        counter = list(set(collections.Counter(deck).values()))
        min_count = min(counter)
        # 如果存在出现一次, 则返回错误
        if 1 in counter:
            return False
        for i in range(2, min_count + 1):
            # 从2开始, 判断是否均可除尽
            if all([c % i == 0 for c in counter]):
                return True
        return False



s=Solution()
print(True, s.hasGroupsSizeX([1,2,3,4,4,3,2,1]))
print(False, s.hasGroupsSizeX([1,1,1,2,2,2,3,3]))
print(False, s.hasGroupsSizeX([1]))
print(True, s.hasGroupsSizeX([1,1]))
print(True, s.hasGroupsSizeX([1,1,2,2,2,2]))
