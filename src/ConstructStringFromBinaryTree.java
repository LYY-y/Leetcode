/**606. 根据二叉树创建字符串
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

示例 1:

输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
示例 2:

输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
通过次数17,795提交次数32,307*/
public class ConstructStringFromBinaryTree {
    //55.88%,61.57%
    StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t != null){
            stringBuilder.append(t.val);
            if (t.left != null || t.right != null){
                stringBuilder.append("(");
                tree2str(t.left);
                stringBuilder.append(")");
                if (t.right != null){
                    stringBuilder.append("(");
                    tree2str(t.right);
                    stringBuilder.append(")");
                }
            }
        }
        return stringBuilder.toString();
    }

    //优秀解答
    public String tree2str2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        toString1(t,sb);
        return sb.toString();
    }
    public void toString1(TreeNode t,StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append('(');
                toString1(t.left, sb);
                sb.append(')');

                if (t.right != null) {
                    sb.append('(');
                    toString1(t.right, sb);
                    sb.append(')');
                }
            }
        }
    }
}
