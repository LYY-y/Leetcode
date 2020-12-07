"""
1002.查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

 

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]
 

提示：

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-common-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    # 57.89 5.23
    def commonChars(self, A):
        hashMap = {}
        res = []
        for ch in A[0]:
            hashMap[ch] = A[0].count(ch)
        for s in range(1, len(A)):
            for key in hashMap:
                temp = A[s].count(key)
                if temp:
                    if temp < hashMap[key]:
                        hashMap[key] = temp
                else:
                    hashMap[key] = 0
        for key in hashMap:
            while hashMap[key] != 0:
                res.append(key)
                hashMap[key]-= 1
        return res
    #57.89 5.23
    def commonChars(self, A):
        res = []
        for ch in set(A[0]):
            count = [x.count(ch) for x in A]
            minCount = ch * min(count)
            for i in minCount:
                res.append(i)
        return res

# 建立一个二维数组，行数是输入单词的个数（最大100），列数是26个英文字母。
# 记下来每个单词中每个字母出现的次数，然后直接在这个二维数组上进行比较，
# 保证第一行是该字母在所有单词中出现的最小次数。
# 最后输出即可

s=Solution()
print(s.commonChars(["bella","label","roller"]))
print(s.commonChars(["cool","lock","cook"]))




