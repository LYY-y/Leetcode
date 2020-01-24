import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatCharacters {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0; i<s.length(); i++){
            int single=(int)s.charAt(i);
            map.put(i,single);
            for (int begin=0; begin<=i; begin++){
                int sum=0;
                if (map.get(begin)==map.get())
            }

        }

    }
}
