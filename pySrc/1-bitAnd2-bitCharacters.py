"""
717.1比特与2比特字符
有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。

现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

示例 1:

输入:
bits = [1, 0, 0]
输出: True
解释:
唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
示例 2:

输入:
bits = [1, 1, 1, 0]
输出: False
解释:
唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
注意:

1 <= len(bits) <= 1000.
bits[i] 总是0 或 1.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 54.03, 7.88
    def isOneBitCharacter(self, bits) -> bool:
        i, n, flag = 0, len(bits), True
        while i < n:
            if bits[i] == 1:
                i += 2
                flag = False
                continue
            i += 1
            flag =True
        return flag

    #线性扫描
    def isOneBitCharacter2(self, bits) -> bool:
        i = 0
        while i < len(bits) - 1:
            i += bits[i] + 1
        return i == len(bits) - 1

    #贪心
    def isOneBitCharacter3(self, bits) -> bool:
        parity = bits.pop()
        while bits and bits.pop():
            parity ^= 1
        return parity == 0


s=Solution()
print(True, s.isOneBitCharacter3([1, 1, 0]))
print(True, s.isOneBitCharacter3([1, 0, 0]))
print(False, s.isOneBitCharacter3([1, 1, 1, 0]))