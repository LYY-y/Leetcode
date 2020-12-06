/**1154. 一年中的第几天
 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。



 示例 1：

 输入：date = "2019-01-09"
 输出：9
 示例 2：

 输入：date = "2019-02-10"
 输出：41
 示例 3：

 输入：date = "2003-03-01"
 输出：60
 示例 4：

 输入：date = "2004-03-01"
 输出：61


 提示：

 date.length == 10
 date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。*/
public class DayOfTheYear {
    //100.00%,74.21%
    public int dayOfYear(String date) {
        int d = 0;
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(5,7));
        int day = Integer.valueOf(date.substring(8,10));
        int[] monthAndDay = new int[12];
        for (int i=0; i<12; i++){
            if ((i+1==1)||(i+1==3)||(i+1==5)||(i+1==7)||(i+1==8)||(i+1==10)||(i+1==12)) {
                monthAndDay[i] = 31;
            }else {
                monthAndDay[i] = 30;
            }
        }
        if (isLeapYear(year)){
            monthAndDay[1] = 29;
        }else {
            monthAndDay[1] = 28;
        }
        for (int y=0; y<month-1; y++){
            d += monthAndDay[y];
        }
        d += day;
        return d;
    }

    public boolean isLeapYear(int year){
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        DayOfTheYear dayOfTheYear=new DayOfTheYear();
        System.out.println(dayOfTheYear.dayOfYear("2019-01-09"));
        System.out.println(dayOfTheYear.dayOfYear("2019-02-10"));
        System.out.println(dayOfTheYear.dayOfYear("2003-03-01"));
        System.out.println(dayOfTheYear.dayOfYear("2004-03-01"));
    }
}
