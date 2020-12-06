/**168. Excel表列名称
 给定一个正整数，返回它在 Excel 表中相对应的列名称。

 例如，

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 示例 1:

 输入: 1
 输出: "A"
 示例 2:

 输入: 28
 输出: "AB"
 示例 3:

 输入: 701
 输出: "ZY"*/
public class ExcelSheetColumnTitle {
    //100.00%,100.00%
    public String convertToTitle(int n) {
        StringBuilder stringBuilder=new StringBuilder();
        while (n != 0){
            n--;
            stringBuilder.append((char)(n%26+'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
//        System.out.println(excelSheetColumnTitle.convertToTitle(1000));
        System.out.println(excelSheetColumnTitle.convertToTitle(701));
        System.out.println(excelSheetColumnTitle.convertToTitle(28));
        System.out.println(excelSheetColumnTitle.convertToTitle(1));
    }
}
