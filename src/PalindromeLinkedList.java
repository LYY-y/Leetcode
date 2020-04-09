/**234.回文链表
 *请判断一个链表是否为回文链表。 */
public class PalindromeLinkedList {
    //99.83 6.52
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode p = head;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
        //反转前半部分链表
        int half = count >> 1;
        ListNode pre = null;
        ListNode cur = head;
        while (half > 0){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            half--;
        }
        if ((count & 1) == 1){
            cur = cur.next;
        }
        while (cur != null && pre != null){
            if (cur.val != pre.val){
                return false;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList r = new PalindromeLinkedList();
        System.out.println(r.isPalindrome(new AAATools().createLinkedList(new int[]{1,2,3,3,2,1})));
        System.out.println(r.isPalindrome(new AAATools().createLinkedList(new int[]{1})));
        System.out.println(r.isPalindrome(new AAATools().createLinkedList(new int[]{})));
        System.out.println(r.isPalindrome(new AAATools().createLinkedList(new int[]{1,1})));
        System.out.println(r.isPalindrome(new AAATools().createLinkedList(new int[]{1,1,2,2,1})));
    }
}
