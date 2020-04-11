/**160.同面试题52.相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。*/
public class IntersectionOfTwoLinkedLists {
    //依次遍历自己的所在链表，然后去遍历对方的链表，抵消不相交部分的差距41.32 47.39
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode hA = headA;
        ListNode hB = headB;
        int count = 2;
        while (headA != null && headB != null){
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            if (headA == null && count > 0){
                headA = hB;
                count--;
            }
            if (headB == null && count > 0){
                headB = hA;
                count--;
            }
        }
        return null;
    }

    //改善99.98 36.16 若不相交则都为null
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode hA = headA;
        ListNode hB = headB;
        while(hA != hB){
            if (hA != null){
                hA = hA.next;
            }else {
                hA = headB;
            }
            if (hB != null){
                hB = hB.next;
            }else {
                hB = headA;
            }
        }
        return hA;
    }

    public static void main(String[] args){
        IntersectionOfTwoLinkedLists i = new IntersectionOfTwoLinkedLists();
        ListNode[] listNodes = new AAATools().createIntersectionOfTwoLinkedLinkedLists(new int[]{4,1,8,4,5}, new int[]{5,0,1,8,4,5}, 2, 3);
        i.getIntersectionNode2(listNodes[0], listNodes[1]);

        ListNode[] listNodes2 = new AAATools().createIntersectionOfTwoLinkedLinkedLists(new int[]{2,6,4}, new int[]{1,5}, 3, 2);
        i.getIntersectionNode2(listNodes2[0], listNodes2[1]);
    }
}
