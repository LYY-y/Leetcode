# 337. 打家劫舍 III
# 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
# 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
# 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
#
# 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 23.23% 44.09%
    def rob(self, root) -> int:
        def _rob(root):
            if not root:
                return 0,0
            # 后序遍历
            left = _rob(root.left)
            right = _rob(root.right)

            # 当前节点偷
            res1 = left[1] + right[1] + root.val
            # 当前节点不偷
            res2 = max(left) + max(right)
            return res1,res2
        return max(_rob(root))


    def rob2(self, root) -> int:
        if not root:
            return 0

        def helper(node):
            if not node.left and not node.right:
                return 0, node.val

            n0, n1 = 0, node.val
            if node.left:
                l0, l1 = helper(node.left)
                n0, n1 = n0 + max(l0, l1), l0 + n1
            if node.right:
                r0, r1 = helper(node.right)
                n0, n1 = n0 + max(r0, r1), r0 + n1
            return n0, n1

        root0, root1 = helper(root)
        return max(root0, root1)


