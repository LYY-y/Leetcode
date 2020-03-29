import java.util.Arrays;

/**820.单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ShortEncodingOfWords {
    //字典树/Trie树/前缀树
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words){
            len += trie.insert(word);
        }
        return len;
    }

    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public int insert(String word){
            TrieNode cur = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--){
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null){
                    isNew = true;
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            return isNew?word.length()+1 : 0;
        }
    }

    //trie节点
    class TrieNode{
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(){}

        public TrieNode(char val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        ShortEncodingOfWords s = new ShortEncodingOfWords();
        System.out.println(s.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(s.minimumLengthEncoding(new String[]{"time", "me"}));

    }
}
