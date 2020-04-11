/**面试题02.06.回文链表
 * 检查输入的链表是否是回文的。*/
public class PalindromeLinkedListLCCI {
    //55.13
    public boolean isPalindrome(ListNode head) {
        //快慢指针获取中间点
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        //逆转后半部分
        ListNode re = reverse(s);

        //比较
        while (re != null){
            if (head.val != re.val){
                return false;
            }
            re = re.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args){
        PalindromeLinkedListLCCI p = new PalindromeLinkedListLCCI();
        System.out.println(p.isPalindrome(new AAATools().createLinkedList(new int[]{1,1,2,1})));
    }
}
