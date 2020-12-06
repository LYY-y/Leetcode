/**589. N叉树的前序遍历
 给定一个 N 叉树，返回其节点值的前序遍历。

 例如，给定一个 3叉树 :



 返回其前序遍历: [1,3,5,6,2,4]。



 说明: 递归法很简单，你可以使用迭代法完成此题吗?*/
import java.util.*;

public class N_aryTreePreorderTraversal {
    //5.02%,93.11%
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node n:node.children){
                stack.add(n);
            }
        }
        return list;
    }


    private List<Integer> result = new ArrayList<Integer>();

    public List<Integer> preorder2(Node root) {
        int size = 0;
        try{
            size = root.children.size();
        }catch(NullPointerException e){
            size = 0;
        }
        if(size == 0 ){
            try{
                result.add(root.val);
            }catch(NullPointerException e){
            }
        }else{
            try{
                result.add(root.val);
                for(int i = 0; i < size; i++){
                    Node node = root.children.get(i);
                    preorder2(node);
                }
            }catch(NullPointerException e){
            }
        }
        return result;
    }
}
