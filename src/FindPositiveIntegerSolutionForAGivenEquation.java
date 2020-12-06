/**1237. 找出给定方程的正整数解
 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。

 给定函数是严格单调的，也就是说：

 f(x, y) < f(x + 1, y)
 f(x, y) < f(x, y + 1)
 函数接口定义如下：

 interface CustomFunction {
 public:
 // Returns positive integer f(x, y) for any given positive integer x and y.
 int f(int x, int y);
 };
 如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。

 你可以将满足条件的 结果数对 按任意顺序返回。



 示例 1：

 输入：function_id = 1, z = 5
 输出：[[1,4],[2,3],[3,2],[4,1]]
 解释：function_id = 1 表示 f(x, y) = x + y
 示例 2：

 输入：function_id = 2, z = 5
 输出：[[1,5],[5,1]]
 解释：function_id = 2 表示 f(x, y) = x * y


 提示：

 1 <= function_id <= 9
 1 <= z <= 100
 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
 在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。*/
import java.util.ArrayList;
import java.util.List;


public class FindPositiveIntegerSolutionForAGivenEquation {
    //5.01%,84.50%
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int x=1; x<=1000;x++){
            for (int y=1;y<=1000;y++){
                if (z==customfunction.f(x,y)){
                    List<Integer> xAndY=new ArrayList<>();
                    xAndY.add(x);
                    xAndY.add(y);
                    list.add(xAndY);
                }
            }
        }
        return list;
    }

    //双指针
    public List<List<Integer>> findSolution2(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (customfunction.f(i,1) > z) {
                break;
            }
            int left = 1;
            int right = 1000;
            while (left <= right) {
                int mid = (right + left) / 2;
                int temp = customfunction.f(i,mid);
                if (temp == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(mid);
                    res.add(list);
                    break;
                } else if (temp > z) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }

    //双指针代替二重循环
    public List<List<Integer>> findSolution3(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1000;
        while (left <= 1000 && right >= 1) {
            int temp = customfunction.f(left,right);
            if (temp == z) {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                left++;
            } else if (temp > z) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }


}
