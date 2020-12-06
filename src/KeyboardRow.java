import java.util.ArrayList;
import java.util.List;

/**500. 键盘行
 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。



 American keyboard



 示例：

 输入: ["Hello", "Alaska", "Dad", "Peace"]
 输出: ["Alaska", "Dad"]


 注意：

 你可以重复使用键盘上同一字符。
 你可以假设输入的字符串将只包含字母。
 * */
public class KeyboardRow {
    //100.00%,44.38%
    public String[] findWords(String[] words) {
        int[] map = new int[26];
        List<String> result = new ArrayList<String>();
        for (int i=0; i<26; i++){
            if (i==0||i==18||i==3||i==5||i==6||i==7||i==9||i==10||i==11){
                map[i]=2;
            }else if (i==25||i==23||i==2||i==21||i==1||i==13||i==12){
                map[i]=3;
            }else {
                map[i]=1;
            }
        }
        for (String word:words){
            boolean isInARow = true;
            String lowWord = word.toLowerCase();
            int temp = map[lowWord.charAt(0)-'a'];
            for (int j=1; j<lowWord.length(); j++){
                int present = map[lowWord.charAt(j)-'a'];
                if (present != temp){
                    isInARow = false;
                    break;
                }
            }
            if (isInARow) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args){
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }
}
