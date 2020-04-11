/**面试题18.删除链表的节点
 *给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。 */
public class DeleteNodeInALinkedListLCOF {
    //100
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        while (p.next != null){
            if (p.next.val == val){
                if (p.next == head){
                    return head.next;
                }
                p.next = p.next.next;
                return head;
            }
            p = p.next;
        }
        return head;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }

    public static void main(String[] args){
        DeleteNodeInALinkedListLCOF d = new DeleteNodeInALinkedListLCOF();
        d.deleteNode(new AAATools().createLinkedList(new int[]{4,5,1,9}),5);
        d.deleteNode(new AAATools().createLinkedList(new int[]{-3,5,-99}),-3);
    }
}
