/**237.删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。*/
public class DeleteNodeInALinkedList {
    //100
    public void deleteNode(ListNode node) {
//        ListNode p = node.next;
//        node.next = node.next.next;
//        while (p != null){
//            node.val = p.val;
//            p = p.next;
//            node = node.next;
//        }
        //优化
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        DeleteNodeInALinkedList d = new DeleteNodeInALinkedList();
        d.deleteNode(new AAATools().createLinkedList(new int[]{4,5,1,9}));
    }
}
