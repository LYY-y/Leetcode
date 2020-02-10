#给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
class Solution:
    def romanToInt(self, s: str) -> int:
        result=0
        dict={'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000,'IV':4,'IX':9,'XL':40,'XC':90,'CD':400,'CM':900}
        while len(s) > 0:
            if(len(s)==1 or dict.get(s[0])>=dict.get(s[1])):
                result+=dict.get(s[0])
                s=s[1:]
            else:
                result+=dict.get(s[0:2])
                s=s[2:]
        return result

s=Solution()
print(s.romanToInt("III"))

"""
解题思路：
从右往左扫描字符串，将每个字符翻译为数字并进行累加，
如果当前字符翻译过来的数字小与上一次的数字，则*-1.
class Solution:
    def romanToInt(self, s: str) -> int:
        mapping = {
            "I":1,
            "V":5,
            "X":10,
            "L":50,
            "C":100,
            "D":500,
            "M":1000
        }
        result = 0
        prev_num = 0
        for c in reversed(s):
            a = mapping.get(c)
            if a < prev_num:
                result -= a
            else:
                result += a
                prev_num = a
        return result

作者：shao-21
链接：https://leetcode-cn.com/problems/roman-to-integer/solution/cong-you-wang-zuo-sao-miao-zi-fu-chuan-bi-jiao-hao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
"""
