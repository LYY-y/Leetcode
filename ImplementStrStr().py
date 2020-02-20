'''
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
class Solution:
    '''
    KPM算法
    '''
    def strStr(self, haystack: str, needle: str) -> int:
        haystackLen=len(haystack)
        needleLen=len(needle)
        if haystackLen < needleLen:
            return -1
        h=0
        n=0
        next=Solution.getNext(self,needle)
        while h < haystackLen and n < needleLen:
            if n==-1 or haystack[h]==needle[n]:
                h+=1
                n+=1
            else:
                n=next[n]
                if haystackLen-h < needleLen-n:
                    break
        if n==needleLen:
            return h-n
        return -1

    def getNext(self,needle: str) -> list:
        next={}
        next[0]=-1
        i=0
        k=-1
        while i < len(needle)-1:
            if k==-1 or needle[i]==needle[k]:
                i+=1
                k+=1
                if needle[i] != needle[k]:
                    next[i]=k
                else:
                    next[i]=next[k]
            else:
                k=next[k]
        return next

    '''
    其他尝试方法：
    超出时间限制
    '''
    def strStr2(self, haystack: str, needle: str) -> int:
        hayLen=len(haystack)
        neeLen=len(needle)
        i=0
        j=1
        while i<hayLen and j<=neeLen:
            a = haystack[i:i + j]
            b = needle[0:j]
            if haystack[i:i+j]==needle[0:j]:
                j+=1
            else:
                i+=1
                j=1
        if j>neeLen:
            return i
        return -1


s=Solution()

print(s.strStr2("abcdabcab","dab"))
