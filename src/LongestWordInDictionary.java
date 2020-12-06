import java.util.*;

/**720. 词典中最长的单词
 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

 若无答案，则返回空字符串。



 示例 1：

 输入：
 words = ["w","wo","wor","worl", "world"]
 输出："world"
 解释：
 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 示例 2：

 输入：
 words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 输出："apple"
 解释：
 "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。


 提示：

 所有输入的字符串都只包含小写字母。
 words数组长度范围为[1,1000]。
 words[i]的长度范围为[1,30]。*/
public class LongestWordInDictionary {
    //52.34%,96.07%
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<String>();
        String result = "";
        for (String word:words){
            if (word.length()==1 || set.contains(word.substring(0,word.length()-1))){
                if (result.length() < word.length()){
                    result = word;
                }
                set.add(word);
            }
        }
        return result;
    }

    //优秀解答，前缀树
    public String longestWord2(String[] words) {

        TrieNode root = new TrieNode(true);
        for(String word : words) {
            addToTrieTree(root,word);
        }

        String[] candidates = new String[30];
        char[] seed = new char[30];

        dfs(root, 0, candidates, seed);

        for(int i = 29; i >= 0; i--){
            if(candidates[i] != null){
                return candidates[i];
            }
        }
        return "";
    }

    private void dfs(TrieNode node, int level, String[] candidates, char[] seed){
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null && node.children[i].isLeaf){
                seed[level] = (char)(i + 'a');
                if(candidates[level] == null){
                    candidates[level] = new String(seed, 0, level+1);
                }
                dfs(node.children[i], level+1, candidates, seed);
            }
        }
    }

    private void addToTrieTree(TrieNode root, String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int offset = c - 'a';
            if (node.children[offset] == null){
                node.children[offset] = new TrieNode(false);
            }
            node = node.children[offset];
        }
        node.isLeaf = true;
    }

    private static class TrieNode {
        private boolean isLeaf;
        private final TrieNode[] children;

        private TrieNode (boolean isLeaf){
            this.isLeaf = isLeaf;
            children = new TrieNode[26];
        }
    }

    public static void main(String[] args){
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
//        System.out.println(longestWordInDictionary.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(longestWordInDictionary.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
