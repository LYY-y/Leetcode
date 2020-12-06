/**345. 反转字符串中的元音字母
 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。



 示例 1：

 输入："hello"
 输出："holle"
 示例 2：

 输入："leetcode"
 输出："leotcede"


 提示：

 元音字母不包含字母 "y" 。*/
public class ReverseVowelsOfAString {
    //93.20%,95.74%
    public String reverseVowels(String s) {
        int len = s.length();
        if (len<2){
            return s;
        }
        int l = 0;
        int r = len-1;
        char[] chars = new char[len];
        while (l<=r){
            while (l<len&&!isVowels(s.charAt(l))){
                chars[l] = s.charAt(l);
                l++;
            }
            if (l>r){
                break;
            }
            while (r>=0&&!isVowels(s.charAt(r))){
                chars[r] = s.charAt(r);
                r--;
            }
            chars[l]=s.charAt(r);
            chars[r]=s.charAt(l);
            l++;
            r--;
        }
        return new String(chars);
    }

    public boolean isVowels(char ch){
        if (ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u'||ch == 'A'||ch == 'E'||ch == 'I'||ch == 'O'||ch == 'U'){
            return true;
        }
        return false;
    }

    public String reverseVowels2(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(!isVow(c[left]) && left < right) {
                left++;
            }
            while(!isVow(c[right]) && left < right) {
                right--;
            }
            if(left >= right) {
                break;
            }
            swap(c, left++, right--);
        }
        return new String(c);
    }

    private boolean isVow(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' ||
                c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args){
        ReverseVowelsOfAString reverseVowelsOfAString=new ReverseVowelsOfAString();
//        System.out.println(reverseVowelsOfAString.reverseVowels("hello"));
//        System.out.println(reverseVowelsOfAString.reverseVowels("leetcode"));
        System.out.println(reverseVowelsOfAString.reverseVowels(".,"));
    }
}
