import java.util.LinkedList;
//工具
public class AAATools {
    public int[] formatArray(String str){
        String[] stringArr = str.split("[,\\[\\]]");
        int[] arr = new int[stringArr.length - 1];
        int i = 0;
        for (String s : stringArr){
            if (!s.equals("")) {
                arr[i++] = Integer.parseInt(s);
            }
        }
        return arr;
    }

    public ListNode createLinkedList(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode p = head;
        for (int i = 1; i < list.length; i++) {
            p.next = new ListNode(list[i]);
            p = p.next;
        }
        return head;
    }

    public ListNode createLinkedListCycle(int[] arr, int pos){
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        ListNode flag = null;
        if (pos == 0){
            flag = head;
        }
        for (int i = 1; i < arr.length; i++){
            p.next = new ListNode(arr[i]);
            p = p.next;
            if (i == pos){
                flag = p;
            }
        }
        if (flag != null){
            p.next = flag;
        }
        return head;
    }

    public ListNode[] createIntersectionOfTwoLinkedLinkedLists(int[] listA, int[] listB, int skipA, int skipB){
        ListNode headA = createLinkedList(listA);
        ListNode headB = createLinkedList(listB);
        ListNode hA = headA;
        ListNode hB = headB;
        ListNode[] listNodes = new ListNode[]{hA,hB};
        while (skipA > 0){
            headA = headA.next;
            skipA--;
        }
        while (skipB > 1){
            headB = headB.next;
            skipB--;
        }
        headB.next = headA;
        return listNodes;
    }

    public static void main(String[] args){
        AAATools tool = new AAATools();
        tool.formatArray("[-2,1,-3,4,-1,2,1,-5,4]");
        tool.createLinkedListCycle(new int[]{3,2,0,-4},1);
        tool.createIntersectionOfTwoLinkedLinkedLists(new int[]{4,1,8,4,5}, new int[]{5,0,1,8,4,5},2,3);
    }
}
