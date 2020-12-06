/**342. 4的幂
 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。

 示例 1:

 输入: 16
 输出: true
 示例 2:

 输入: 5
 输出: false
 进阶：
 你能不使用循环或者递归来完成本题吗？*/
public class PowerOfFour {
    //100.00%,53.14%
    public boolean isPowerOfFour(int num) {
        if (num>0 && ((Math.log(num)/Math.log(2))%2 == 0)){
            return true;
        }
        return false;
    }

//    4 的幂与二进制数 (101010...10)相与得0
    public boolean isPowerOfFour2(int num) {
        if (num>0 && (num&(num-1)) == 0 && (num&0xaaaaaaaa)==0){
            return true;
        }
        return false;
    }

    public boolean isPowerOfFour3(int num) {
        if (num>0 && (num&(num-1)) == 0 && num%3==1){
            return true;
        }
        return false;
    }
}
