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
"""
优秀解答：
"""
class Solution:
    def isValid(self, s: str) -> bool:
        # left_1, left_2, left_3 = 0, 0, 0

        # if s=='':
        #     return True
        # elif len(s)%2 == 1:   # Length of s is odd
        #     return False

        # for i in range(len(s)):
        #     if s[i]=='(':
        #         left_1 += 1
        #     elif s[i] == ')':
        #         left_1 -= 1
        #     elif s[i]=='[':
        #         left_2 += 1
        #     elif s[i]==']':
        #         left_2 -= 1
        #     elif s[i]=='{':
        #         left_3 += 1
        #     elif s[i] == '}':
        #         left_3 -= 1
        #     else:
        #         print('Wrong Input')

        # if left_1 == left_2 == left_3 == 0:
        #     return True
        # else:
        #     return False



        ################################################################################################

        if s=='':
            return True
        elif len(s)%2 == 1:   # Length of s is odd
            return False

        # The stack to keep track of opening brackets.
        stack = []

        # Hash map for keeping track of mappings. This keeps the code very clean.
        # Also makes adding more types of parenthesis easier
        mapping = {")": "(", "}": "{", "]": "["}

        # For every bracket in the expression.
        for char in s:

            # If the character is an closing bracket
            if char in mapping:

                # Pop the topmost element from the stack, if it is non empty
                # Otherwise assign a dummy value of '#' to the top_element variable
                if stack and mapping[char] == stack.pop():
                    pass
                else:
                    return False

                # The mapping for the opening bracket in our hash and the top
                # element of the stack don't match, return False
                # if mapping[char] != top_element:
                #     return False
            else:
                # We have an opening bracket, simply push it onto the stack.
                stack.append(char)

        # In the end, if the stack is empty, then we have a valid expression.
        # The stack won't be empty for cases like ((()
        return not stack

s=Solution()
print(s.isValid("){"))
