/**1290.二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class ConvertBinaryNumberInALinkedListToInteger {
    //逆向模拟 100 5.23
    public int getDecimalValue1(ListNode head) {
        int num = 0;
        while (head != null){
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }

    //递归，100
    public int digit = 0;
    public int getDecimalValue(ListNode head) {
        if (head.next == null){
            return (int) (head.val * Math.pow(2,digit++));
        }
        return getDecimalValue(head.next) + (int) (head.val * Math.pow(2,digit++));
    }



    public static void main(String[] args){
        ConvertBinaryNumberInALinkedListToInteger c = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c.getDecimalValue(new AAATools().createLinkedList(new int[]{1,0,1})));
        ConvertBinaryNumberInALinkedListToInteger c1 = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c1.getDecimalValue(new AAATools().createLinkedList(new int[]{1})));
        ConvertBinaryNumberInALinkedListToInteger c2 = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c2.getDecimalValue(new AAATools().createLinkedList(new int[]{0})));
        ConvertBinaryNumberInALinkedListToInteger c3 = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c3.getDecimalValue(new AAATools().createLinkedList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
        ConvertBinaryNumberInALinkedListToInteger c4 = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(c4.getDecimalValue(new AAATools().createLinkedList(new int[]{0,0})));
    }
}
