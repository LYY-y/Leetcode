/**面试题02.01.移除重复节点
 * 移除未排序链表中的重复节点。保留最开始出现的节点。*/
public class RemoveDuplicateNodeLCCI {
    //双循环+双指针17.84
    public ListNode removeDuplicateNodes1(ListNode head) {
        ListNode s = head;
        while (s != null){
            ListNode f = s;
            while (f.next != null){
                if (s.val == f.next.val){
                    f.next = f.next.next;
                }else {
                    f = f.next;
                }
            }
            s = s.next;
        }
        return head;
    }

    //递归 98.95
    int[] hash = new int[20001];
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head != null){
            if (hash[head.val] == 0){
                hash[head.val]++;
                head.next = removeDuplicateNodes(head.next);
                return head;
            }else {
                return removeDuplicateNodes(head.next);
            }
        }else {
            return null;
        }
    }

    public static void main(String[] args){
        RemoveDuplicateNodeLCCI r = new RemoveDuplicateNodeLCCI();
        r.removeDuplicateNodes(new AAATools().createLinkedList(new int[]{1, 2, 3, 3, 2, 1}));
        r.removeDuplicateNodes(new AAATools().createLinkedList(new int[]{1, 1, 1, 1, 2}));
    }
}
