import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    //28.94%,7.01%
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<text.length(); i++){
            char ch = text.charAt(i);
            if (ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        if (map.size() < 5){
            return 0;
        }
        map.put('o',map.get('o')/2);
        map.put('l',map.get('l')/2);

        int count = Integer.MAX_VALUE;
        for (char key : map.keySet()){
            count = Math.min(count,map.get(key));
        }
        return count;
    }

    public int maxNumberOfBalloons2(String text) {
        int[] letterArray = new int[26];
        for (char c : text.toCharArray()) {
            letterArray[c - 97]++;
        }
        letterArray['l' - 97] = letterArray['l' - 97]/2;
        letterArray['o' - 97] = letterArray['o' - 97]/2;
        int min = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            if (letterArray[c - 97] < min) {
                min = letterArray[c - 97];
            }
        }
        return min;
    }

    public static void main(String[] args){
        MaximumNumberOfBalloons maximumNumberOfBalloons = new MaximumNumberOfBalloons();
        System.out.println(maximumNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));
    }
}
