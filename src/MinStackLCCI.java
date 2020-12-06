/**面试题 03.02. 栈的最小值
 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。


 示例：

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.*/
import java.util.Stack;

public class MinStackLCCI {
    //22.03%，99.79%
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStackLCCI() {
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


    //优秀解答
    int[] imitate;
    int[] min;
    int top = -1;

    /** initialize your data structure here. **/
//    public MinStack() {
//        imitate = new int[10000];
//        min = new int[10000];
//
//    }

    public void push2(int x) {
        if(top == -1)
            min[top + 1] = x;

        else if(min[top] > x)
        {
            min[top + 1] = x;
        }
        else
        {
            min[top + 1] = min[top];
        }
        top++;
        imitate[top] = x;

    }

    public void pop2() {
        top--;

    }

    public int top2() {
        return imitate[top];

    }

    public int getMin2() {
        return min[top];

    }
}
