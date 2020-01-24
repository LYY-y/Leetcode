import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==1){
            return 1;
        }else {
            int count=0;
            Map<Integer,String> map=new HashMap<Integer, String>();
            //从左到右将不重复的字符编码存进HashMap
            for (int j=0; j<s.length(); j++) {
                for (int i = j; i < s.length(); i++) {
                    if (map.containsValue(s.substring(i,i+1))) {//  检查map是否已有该值
                        if (count < map.size()) {
                            count = map.size();
                        }
                        map.clear();
                        break;
                    } else {
                        map.put(i, s.substring(i,i+1));
                    }

                }
            }
            return count;
        }
    }
//滑动窗口法
    public int lengthOfLongestSubstring2(String s) {
        int count=0;
        int lastSame=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                lastSame=Math.max(map.get(s.charAt(i))+1,lastSame);
            }
            map.put(s.charAt(i),i);
            count=Math.max(i-lastSame+1,count);
        }
        return count;
    }

    public static void main(String[] args){
        LongestSubstringNoRepeatCharacters test=new LongestSubstringNoRepeatCharacters();
        System.out.println(test.lengthOfLongestSubstring2(" "));
    }
}
