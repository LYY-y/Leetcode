/**876.链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。*/
public class MiddleOfTheLinkedList {
    //100 6.01快慢指针取中值
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f!= null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
