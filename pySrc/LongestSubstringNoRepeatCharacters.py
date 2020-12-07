#给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
            lastSame=0
            count=0
            map={}
            for index in range(len(s)):
                x=s[index]
                print(x)
                if x in map:
                    lastSame=max(map.get(x)+1,lastSame)
                    print("lastSame:",lastSame)
                map[x]=index
                print(map.items())
                count=max(map.get(x)-lastSame+1,count)
                print("count:",count)
            return count

s=Solution()
print(s.lengthOfLongestSubstring("pwwkew"))
