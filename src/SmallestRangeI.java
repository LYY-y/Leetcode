import java.util.Arrays;

public class SmallestRangeI {
    //31.63%，36.40%
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0]+K;
        int max = A[A.length-1];
        if (max - K <= min){
            return 0;
        }
        return max-K-min;
    }

    //100.00%,92.99%
    public int smallestRangeI2(int[] A, int K) {
        int min = 10000;
        int max = 0;
        for (int a:A){
            if (a<min){
                min = a;
            }
            if (a>max){
                max = a;
            }
        }
        min = min + K;
        max = max-K;
        if (max<=min){
            return 0;
        }else {
            return max-min;
        }
    }

    public int smallestRangeI3(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < A.length; i++){
            if(A[i] > max) max = A[i];
            if(A[i] < min) min = A[i];
        }
        return Math.max(max - min - 2 * K, 0);
    }
}
