"""
杨辉三角2:
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
示例:
输入: 3
输出: [1,3,3,1]
"""
class Solution:
    def getRow(self, rowIndex: int):
        if 