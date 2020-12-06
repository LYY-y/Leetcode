# 1221. 分割平衡字符串
# 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
# 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
# 返回可以通过分割得到的平衡字符串的最大数量。

class Solution:
    # 83.63 10.80
    def balancedStringSplit(self, s: str) -> int:
        n = len(s)
        if n < 2:
            return 0
        count = 0
        i = 0
        # flag为标志位，若字符为L，则flag+1，若字符为R，则flag-1
        flag = 0
        while i < n:
            if s[i] == 'L':
                flag += 1
            else:
                flag -= 1
            if flag == 0:
                count += 1
            i += 1
        return count

    # 优秀解答
    def balancedStringSplit(self, s: str) -> int:
        result, count = 0, 0
        for num in s:
            if num == 'R':
                count += 1
            else:
                count -= 1
            if count == 0:
                result += 1
        return result

s=Solution()
print(s.balancedStringSplit("RLRRLLRLRL"))
