public class AAATools {
    public int[] formatArray(String str){
        String[] stringArr = str.split("[,\\[\\]]");
        int[] arr = new int[stringArr.length - 1];
        int i = 0;
        for (String s : stringArr){
            if (!s.equals("")) {
                arr[i++] = Integer.parseInt(s);
            }
        }
        return arr;
    }

    public static void main(String[] args){
        AAATools tool = new AAATools();
        tool.formatArray("[-2,1,-3,4,-1,2,1,-5,4]");
    }
}
