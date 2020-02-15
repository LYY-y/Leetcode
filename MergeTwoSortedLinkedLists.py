"""
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
#Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
解法一：
1、若其中一条链为空，则返回另一条
2、将头部较小的定为L1，用head1指L1头部，rear2记录L2的next位置
3、以L1为基准，若L1的next>=L2，则将L2插入L1前，两者指针均后移一位；
   否则只移动L1指针，直至L1结束
4、若L2此时不为空，则将L2接到L1后面
'''
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if(l1==None):
            return l2
        elif(l2==None):
            return l1
        if l1.val>l2.val:
            temp=l1;
            l1=l2;
            l2=temp;
        head1=l1
        rear2=ListNode(None)
        while l1.next!=None :
            if l2!=None and l1.next.val>=l2.val :
                if l2.next!=None:
                    rear2.next=l2.next
                else:
                    rear2.next=None
                l2.next=l1.next
                l1.next=l2
                l2=rear2.next
            l1=l1.next
        if l2!=None:
            l1.next=l2
        return head1
'''
解法二：
1、新建一个链表
2、在L1、L2链表中寻找较小值插入新链表中
'''
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if(l1==None):
            return l2
        elif(l2==None):
            return l1
        head=ListNode(None)
        p=head
        while l1!=None and l2!=None:
            if l1.val<=l2.val:
                p.next=l1
                l1=l1.next
            else:
                p.next=l2
                l2=l2.next
            p=p.next
        if l2!=None:
            p.next=l2
        elif l1!=None:
            p.next=l1
        return head.next
'''
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val: l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2

作者：QQqun902025048
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/python-4xing-by-knifezhu-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
'''
