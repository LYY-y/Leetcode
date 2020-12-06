/**242.有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。*/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] strArr = new int[26];
        if (s.length() == t.length()){
            int len = s.length();
            for (int i=0; i < len; i++){
                strArr[s.charAt(i)-97]++;
                strArr[t.charAt(i)-97]--;
            }
            for (int j = 0; j < strArr.length; j++){
                if (strArr[j] != 0){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

//    改进
    public boolean isAnagram2(String s, String t) {
        int[] strArr = new int[26];
        if (s.length() == t.length()){
            int len = s.length();
            for (int i=0; i < len; i++){
                strArr[s.charAt(i)-97]++;
            }
            for (int i=0; i < len; i++){
                strArr[t.charAt(i)-97]--;
                if (strArr[t.charAt(i)-97] < 0){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println("True: "+new ValidAnagram().isAnagram("aum","mua"));
        System.out.println("True: "+new ValidAnagram().isAnagram("aumtt","attum"));
        System.out.println("True: "+new ValidAnagram().isAnagram("",""));
        System.out.println("False: "+new ValidAnagram().isAnagram("aum","mu"));
        System.out.println("False: "+new ValidAnagram().isAnagram("au","mua"));
        System.out.println("False: "+new ValidAnagram().isAnagram("aumm","mua"));
        System.out.println("False: "+new ValidAnagram().isAnagram("","mua"));
    }
}
