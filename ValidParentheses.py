"""
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

"""
"""
1、去除所有空格，若为空，则返回True
2、计算字符串长度，若为奇数，则返回False
3、左括号为键，相同类型的右括号为值构造字典；创建列表构造栈
4、遍历字符串，将左括号放入栈中，遇到右括号时若与栈中最后一个左括号
   是相同类型时，栈将最后一个元素（左括号）推出；若类型不同，则返回False；
   直至栈为空且字符串已完全遍历，则返回True；其余情况返回False
"""

class Solution:
    def isValid(self, s: str) -> bool:
        s.replace(" ","")
        if not s:
            return True    
        length=len(s)
        dict={'(': ')', '{': '}', '[':']'}
        if length%2 != 0:
            return False
        strList=[]
        for ch in s:
            if ch in dict:
                strList.append(ch)
            if (ch not in dict) and strList:
                if ch==dict[strList[-1]]:
                    strList.pop()
                else:
                    return False
            else:
                return False
        if len(strList):
             return False
        return True

s=Solution()
print(s.isValid("){"))
