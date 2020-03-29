/**面试题01.01判定字符是否唯一
 *实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 */
public class IsUniqueLCCI {
    //100
    public boolean isUnique(String astr) {
        int n = astr.length();
        for (int i = 0; i < n; i++){
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
