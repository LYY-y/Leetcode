import sys
"""    
依次截取第一个元素的第一个字符，观察其余元素是否满足，
若满足取出第二个字符进行比较，直至不满足或某元素字符已全部取完.
"""
class Solution:
    def longestCommonPrefix(self, strs) -> str:
        j=0
        strResult=""
        strLongestLength = sys.maxsize
        if(len(strs)==0):
            return strResult
        for i in strs:
            if(len(i)==0):
                return strResult
            strLongestLength = len(i) if len(i)<strLongestLength else strLongestLength
        while j < strLongestLength:
            for k in range(len(strs)):
                if strs[k][j] != strs[0][j]:
                    return strResult
            strResult+=strs[0][j]
            j+=1
        return strResult
"""
优秀解答：
"""
class Solution2:
    def longestCommonPrefix(self, strs) -> str:
        '''
        :param strs: List[str]
        :rtype:List[str]
        '''
        max = ''
        for i in zip(*strs):
            if len(set(i)) == 1:
                max += i[0]
            else:
                return max
        return max

s=Solution2()
print(s.longestCommonPrefix(["flower","flow","flight"]))
