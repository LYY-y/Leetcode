/**203.移除链表元素
 * 删除链表中等于给定值 val 的所有节点。*/
public class RemoveLinkedListElements {
    //99.92 5.00
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        while (p != null && p.next != null){
            if (p.next.val == val){
                if (p.next == head){
                    head = head.next;
                    p.next = head;
                    continue;
                }
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }
//优秀解答100
    public ListNode removeElements2(ListNode head, int val) {
        ListNode cur = head;
        if(cur == null) return null;
        ListNode next = cur.next;
        if (cur.val == val) return removeElements2(next, val);
        while (next != null) {
            while(next != null && next.val == val) {
                next = next.next;
            }
            cur.next = next;
            if (next != null) {
                cur = next;
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        r.removeElements(new AAATools().createLinkedList(new int[]{1,2,6,3,4,5,6}),6);
        r.removeElements(new AAATools().createLinkedList(new int[]{1}),1);
        r.removeElements(new AAATools().createLinkedList(new int[]{1,1}),1);
        r.removeElements(new AAATools().createLinkedList(new int[]{1,2,2,1}),2);

    }
}
