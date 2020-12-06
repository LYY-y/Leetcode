/**剑指 Offer 06. 从尾到头打印链表
 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]


 限制：

 0 <= 链表长度 <= 10000*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PrintTheLinkedListFromEndToBeginning {
    //42.34%,5.08%
    List<Integer> list = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        helper(head);
        int[] res = new int[list.size()];
        for (int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(ListNode node){
        if (node.next == null){
            list.add(node.val);
            return;
        }
        list.add(node.val);
        helper(node.next);
    }

    //优秀解答
    public int[] reversePrint2(ListNode head) {
        ListNode cur =head;
        int n=0;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        int[] a =new int[n];
        int i =n-1;
        while(head!=null){
            a[i]=head.val;
            i--;
            head=head.next;
        }
        return a;
    }


    //栈
    public int[] reversePrint3(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }


}
