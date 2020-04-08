/**141.环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class LinkedListCycle {
    //100 5.08 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (s != f){
            if (f.next == null || f.next.next == null){
                return false;
            }
            s = s.next;
            f = f.next.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        while (head != head.next){
            if (head.next == null || head.next.next ==null){
                return false;
            }
            head.next = head.next.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args){
        LinkedListCycle l = new LinkedListCycle();
        System.out.println("T " + l.hasCycle2(new AAATools().createLinkedListCycle(new int[]{3,2,0,-4},1)));
        System.out.println("T " + l.hasCycle2(new AAATools().createLinkedListCycle(new int[]{1,2},0)));
        System.out.println("F " + l.hasCycle2(new AAATools().createLinkedListCycle(new int[]{1},-1)));
        //System.out.println(l.hasCycle(new AAATools().createLinkedListCycle(new int[]{3,2,0,-4},-1)));
    }
}
