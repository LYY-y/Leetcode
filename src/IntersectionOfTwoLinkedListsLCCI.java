/**面试题02.07.链表相交*/
public class IntersectionOfTwoLinkedListsLCCI {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a.next;
            b = b.next;
            if(a == null && b ==null){
                return null;
            }
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
        }
        return a;
    }
}
