/**203.移除链表元素
 * 删除链表中等于给定值 val 的所有节点。*/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null){

        }
    }

    public static void main(String[] args){
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        r.removeElements(new AAATools().createLinkedList(new int[]{1,2,6,3,4,5,6}),6);
        r.removeElements(new AAATools().createLinkedList(new int[]{1}),1);
        r.removeElements(new AAATools().createLinkedList(new int[]{1,1}),1);
    }
}
