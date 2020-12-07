# 1282. 用户分组
# 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，
# 其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
# 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
class Solution:
    # 64.72 16.86
    def groupThePeople(self, groupSizes):
        res = []
        map = {}
        for index,group in enumerate(groupSizes):
            if map.get(group):
                arr = map.get(group)
                arr.append(index)
                map[group] = arr
            else:
                map[group] = [index]
        for key,value in map.items():
            for i in range(0, len(value), key):
                res.append(value[i:i + key])
        return res

s=Solution()
print(s.groupThePeople([3,3,3,3,3,1,3]))
