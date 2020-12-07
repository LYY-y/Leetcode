"""
83.删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 89.41 5.23
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        p = head
        while head != None:
            while head.next != None and head.val == head.next.val:
                head.next = head.next.next
            head = head.next
        return p

    # 递归
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        head.next = self.deleteDuplicates(head.next)
        if head.val == head.next.val:
            head = head.next
            return head