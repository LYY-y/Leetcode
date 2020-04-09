/**1290.二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        return helper(head, -1,0);
    }

    public int helper(ListNode head,int digit, int ans){
        if (head == null){
            return ans;
        }
        digit++;
        helper(head.next, digit, ans);
        ans += (int) (head.val * Math.pow(2,digit));
        return ans;
    }

    public static void main(String[] args){
        ConvertBinaryNumberInALinkedListToInteger c = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{1,0,1})));
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{1})));
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{0})));
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{0,0})));
    }
}
