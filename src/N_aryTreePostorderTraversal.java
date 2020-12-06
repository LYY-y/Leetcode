/**590. N叉树的后序遍历
 给定一个 N 叉树，返回其节点值的后序遍历。

 例如，给定一个 3叉树 :







 返回其后序遍历: [5,6,3,2,4,1].



 说明: 递归法很简单，你可以使用迭代法完成此题吗?*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal {
    //22.97%,97.62%
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null){
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            list.add(node.val);
            List<Node> children = node.children;
            for (Node n:children){
                stack.push(n);
            }
        }
        Collections.reverse(list);
        return list;
    }

    //优秀解答
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder2(Node root) {
        if(root == null)    return res;
        for(int i = 0;i<root.children.size();i++){
            postorder2(root.children.get(i));
        }
        res.add(root.val);
        //后续遍历，先把孩子节点按顺序遍历完之后最后才add父节点
        return res;
    }
}
