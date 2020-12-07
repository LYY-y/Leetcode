# 763. 划分字母区间
# 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
class Solution:
    # 19.28 41.93
    def partitionLabels(self, S: str):
        res = []
        max_position = [0]*26
        for i, ch in enumerate(S):
            max_position[ord(ch)-ord('a')] = i
        start = 0
        end = 0
        for i,ch in enumerate(S):
            end = max(end,max_position[ord(ch)-ord('a')])
            if i == end:
                res.append(end-start+1)
                start = end + 1
        return res

    # 官方题解
    def partitionLabels(self, S: str):
        last = [0] * 26
        for i, ch in enumerate(S):
            last[ord(ch) - ord("a")] = i

        partition = list()
        start = end = 0
        for i, ch in enumerate(S):
            end = max(end, last[ord(ch) - ord("a")])
            if i == end:
                partition.append(end - start + 1)
                start = end + 1

        return partition


s=Solution()
print(s.partitionLabels("ababcbacadefegdehijhklij"))