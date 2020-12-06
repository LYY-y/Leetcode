/**401. 二进制手表
 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

 每个 LED 代表一个 0 或 1，最低位在右侧。



 例如，上面的二进制手表读取 “3:25”。

 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。



 示例：

 输入: n = 1
 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]


 提示：

 输出的顺序没有要求。
 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
*/
 import java.util.ArrayList;
 import java.util.List;

public class BinaryWatch {
    //97.76%,97.73%
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<String>();
        for (int i=0; i<12; i++){
            for (int j=0; j<60; j++){
                if (Integer.bitCount(i)+Integer.bitCount(j) == num){
                    StringBuilder time = new StringBuilder();
                    time.append(i);
                    time.append(":");
                    if (j<10){
                        time.append(0);
                    }
                    time.append(j);
                    times.add(new String(time));
                }
            }
        }
        return times;
    }

    //优秀解答
    private List<String> ans=new ArrayList<String>();

    private String getTime(int[] clock){
        StringBuilder time=new StringBuilder();
        int hour=0;
        int i=0;
        for(;i<4;i++){
            hour=hour*2+clock[i];
        }
        if(hour>11){
            return "";
        }
        int minute=0;
        for(;i<clock.length;i++){
            minute=minute*2+clock[i];
        }
        if(minute>59){
            return "";
        }
        time.append(hour);
        time.append(':');
        if(minute<10){
            time.append(0);
        }
        time.append(minute);
        return time.toString();
    }

    private void backtrack(int[] clock,int k,int curIndex){
        if(k==0){
            String time=getTime(clock);
            if(time.length()!=0){
                ans.add(time);
            }
            return;
        }
        for(int i=curIndex;i<clock.length;i++){
            clock[i]=1;
            backtrack(clock,k-1,i+1);
            clock[i]=0;
        }
    }

    public List<String> readBinaryWatch2(int num) {
        int[] clock=new int[10];
        backtrack(clock,num,0);
        return ans;
    }

    public static void main(String[] args){
        BinaryWatch binaryWatch = new BinaryWatch();
        binaryWatch.readBinaryWatch2(1);
    }
}
