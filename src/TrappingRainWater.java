import java.util.Stack;

/**42.接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length){
            while (!stack.empty() && height[cur] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()){
                    break;
                }
                int dis = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[cur]);
                res = res + dis * (min - h);
            }
            stack.push(cur);
            cur++;
        }
        return res;
    }

    public static void main(String[] args){
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
