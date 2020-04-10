/**面试题02.02.返回倒数第k个节点
 * 找出单向链表中倒数第 k 个节点。返回该节点的值。*/
public class KthNodeFromEndOfListLCCI {
    //递归100
    int total = 0;
    int res = 0;
    public int kthToLast2(ListNode head, int k) {
        helper(head, k, 0);
        return res;
    }

    public void helper(ListNode head, int k, int pos){
        if (head == null){
            total = pos;
            return;
        }
        helper(head.next,k,++pos);
        if (pos == total - k + 1){
            res = head.val;
        }
    }

    //双指针100
    public int kthToLast(ListNode head, int k) {
        ListNode s = head;
        ListNode f = head;
        while (k > 0){
            f = f.next;
            k--;
        }
        while (f != null){
            s = s.next;
            f = f.next;
        }
        return s.val;
    }


        public static void main(String[] args){
        KthNodeFromEndOfListLCCI k = new KthNodeFromEndOfListLCCI();
        System.out.println(k.kthToLast(new AAATools().createLinkedList(new int[]{1,2,3,4,5}),2));
        KthNodeFromEndOfListLCCI k1 = new KthNodeFromEndOfListLCCI();
        System.out.println(k1.kthToLast(new AAATools().createLinkedList(new int[]{1,2,3,4,5}),5));
        KthNodeFromEndOfListLCCI k2 = new KthNodeFromEndOfListLCCI();
        System.out.println(k2.kthToLast(new AAATools().createLinkedList(new int[]{1}),1));
    }
}
