# 765. 情侣牵手
# N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
#
# 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
#
# 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

class Solution:
    # 78.65 12.36
    def minSwapsCouples(self, row) -> int:
        count = 0
        n = len(row)
        i = 0
        while i < n:
            one = row[i]
            if one & 1 == 0:
                two = one + 1
            else:
                two = one - 1
            if row[i+1] != two:
                two_index = self.findTwo(i+1, row, two)
                row[i+1], row[two_index] = row[two_index], row[i+1]
                count += 1
            i += 2
        return count


    def findTwo(self,start,row,two):
        for i in range(start,len(row)):
            if row[i] == two:
                return i

        # 官方题解
        def minSwapsCouples(self, row):
            ans = 0
            for i in range(0, len(row), 2):
                x = row[i]
                if row[i + 1] == x ^ 1: continue
                ans += 1
                for j in range(i + 1, len(row)):
                    if row[j] == x ^ 1:
                        row[i + 1], row[j] = row[j], row[i + 1]
                        break
            return ans

    # 优秀解答
    def minSwapsCouples(self, row) -> int:
        if len(row) <= 2:
            return 0
        val = row[0]
        if val % 2 == 1:
            v = val - 1
        else:
            v = val + 1
        if row[1] == v:
            return self.minSwapsCouples(row[2:])
        else:
            index = row.index(v)
            row[1], row[index] = row[index], row[1]
            return self.minSwapsCouples(row[2:]) + 1

    # 优秀解答
    def minSwapsCouples(self, row) -> int:
        n = len(row)
        parent = {i: i for i in range(n // 2)}

        def find(node):
            path = []
            while node != parent[node]:
                path.append(node)
                node = parent[node]
            for p in path:
                parent[p] = node
            return node

        def union(n1, n2):
            p1 = find(n1)
            p2 = find(n2)
            if p1 != p2:
                parent[p1] = p2

        for i in range(0, n, 2):
            union(row[i] // 2, row[i + 1] // 2)
        return n // 2 - len(set([find(i) for i in range(n // 2)]))

s=Solution()
print(s.minSwapsCouples([5,4,2,6,3,1,0,7]))