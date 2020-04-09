/**206.反转链表
 * 反转一个单链表。*/
public class ReverseLinkedList {
    //迭代100
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        r.reverseList(new AAATools().createLinkedList(new int[]{1,2,3,4,5}));
    }
}
