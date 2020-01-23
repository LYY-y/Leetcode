import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else {
            int single=0;
            int digit = checkDigit(x);
            int nowTemp=0;
            int preTemp;
            int compose=0;
            List<Integer> list=new ArrayList<>() ;
            //将整数从左到右每一位提取出来放到ArrayList中
            for (int i=0; i<digit ; i++){
                preTemp = nowTemp;
                nowTemp = x/(int) Math.pow(10,digit-i-1);
                single  = nowTemp-preTemp*10;
                list.add(i,single);
            }

            //将ArrayList中的数据提取出来组成整数，观察是否相等
            for (int i=digit-1; i>=0; i--) {
                compose = compose+list.get(i)*(int)Math.pow(10,i);
            }
            if (compose==x){
                return true;
            }else {
                return false;
            }
        }
    }

    public int checkDigit(int x){
        int digit =0;
        while (x!=0){
            x=x/10;
            digit++;
        }
        return digit;
    }

    public static void main(String[] args){
        PalindromeNum pm=new PalindromeNum();
        System.out.println(pm.isPalindrome(123321));

    }

    //取出后半段数字进行翻转。
        public boolean isPalindromeAnswer(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)){ return false;}
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }


//    作者：MisterBooo
//    链接：https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
