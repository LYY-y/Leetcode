"""
1071.字符串的最大公因子
对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

 

示例 1：

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""
 

提示：

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1[i] 和 str2[i] 为大写英文字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 枚举
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        n1, n2 = len(str1), len(str2)
        for i in range(min(n1, n2), 0, -1):
            if (n1 % i == 0 and n2 % i == 0):
                if str1[:i] * (n1 // i) == str1 and str1[:i] * (n2 // i) == str2:
                    return str1[0:i]
        return ""






s=Solution()
print(s.gcdOfStrings("ABCABC", "ABC"))
print(s.gcdOfStrings("ABABAB", "ABAB"))
print(s.gcdOfStrings("LEET", "CODE"))

