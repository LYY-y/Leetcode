/**剑指 Offer 30. 包含min函数的栈
 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.min();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.min();   --> 返回 -2.


 提示：

 各函数的调用总次数不超过 20000 次


 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/*/
import java.util.Stack;

public class StackContainingMinFunctionLCOF {
    //20.75%，88.35%
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public StackContainingMinFunctionLCOF() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty()||min_stack.peek()>=x){
            min_stack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek())){
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
