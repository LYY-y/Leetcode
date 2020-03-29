/**面试题01.02 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。*/
public class CheckPermutationLCCI {
    //100
    public boolean CheckPermutation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2){
            return false;
        }
        int[] temp = new int[256];
        for (int i = 0; i < n1; i++){
            temp[s1.charAt(i)]++;
        }
        for (int j = 0; j < n2; j++){
            temp[s2.charAt(j)]--;
        }
        for (int t : temp){
            if (t != 0){
                return false;
            }
        }
        return true;
    }

    //优秀解答：还可用异或运算特点优化，相同的两个值的运算结果为0
    public boolean CheckPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int length = s1.length();
        if (length != s2.length()) {
            return false;
        }
        int result = 0;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        for (int i = 0; i < s1Char.length; i++) {
            result = result ^ s1Char[i] ^ s2Char[i];
        }
        return result == 0;
    }
}
