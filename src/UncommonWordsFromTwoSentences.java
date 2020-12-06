import java.util.*;

/**884. 两句话中的不常见单词
 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。

 返回所有不常用单词的列表。

 您可以按任何顺序返回列表。



 示例 1：

 输入：A = "this apple is sweet", B = "this apple is sour"
 输出：["sweet","sour"]
 示例 2：

 输入：A = "apple apple", B = "banana"
 输出：["banana"]


 提示：

 0 <= A.length <= 200
 0 <= B.length <= 200
 A 和 B 都只包含空格和小写字母。*/
public class UncommonWordsFromTwoSentences {
    //99.86%,75.00%
    public String[] uncommonFromSentences(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int k = 0;
        List<String> words = new ArrayList<String>();
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");
        Map<String, Integer> mapA = new HashMap<String,Integer>();
        Map<String, Integer> mapB = new HashMap<String,Integer>();
        for (String a:arrA){
            mapA.put(a, mapA.getOrDefault(a,0)+1);
        }
        for (String b:arrB){
            mapB.put(b, mapB.getOrDefault(b,0)+1);
        }
        for (String keyA:mapA.keySet()){
            if (!mapB.containsKey(keyA)&&mapA.get(keyA) == 1){
                words.add(keyA);
            }
        }
        for (String keyB:mapB.keySet()){
            if (!mapA.containsKey(keyB)&&mapB.get(keyB) == 1){
                words.add(keyB);
            }
        }
        return words.toArray(new String[words.size()]);
    }

    public String[] uncommonFromSentences2(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args){
        UncommonWordsFromTwoSentences uncommonWordsFromTwoSentences = new UncommonWordsFromTwoSentences();
        System.out.println(uncommonWordsFromTwoSentences.uncommonFromSentences("this apple is sweet","this apple is sour"));
    }
}
