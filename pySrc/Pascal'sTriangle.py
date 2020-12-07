"""
杨辉三角：
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。在杨辉三角中，每个数是它左上方和右上方的数的和。
"""
class Solution:
    def generate(self, numRows: int):
        if numRows == 0:
            return []
        result = [[] for i in range(numRows)]
        result[0].append(1)
        row = 1
        while row < numRows:
            result[row].append(1)
            for i in range(1,row):
                result[row].append(result[row-1][i-1]+result[row-1][i])
            result[row].append(1)
            row+=1
        return result


s=Solution()
print(s.generate(7))

"""
优秀答案
    def generate2(self, numRows: int):
        if numRows <= 0:
            return []
        else:
            res = [[1]]
            while len(res) < numRows:
                #res[-1]：表示数组的最后一行
                #i=res[-1] + [0]=[1,0]
                #j=[0] + res[-1]=[0,1]
                #new=[1,1]
                new = [a + b for a, b in zip(res[-1] + [0], [0] + res[-1])]
                res.append(new)
            return res
"""
