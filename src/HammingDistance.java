public class HammingDistance {
    //100.00%,19.75%
    public int hammingDistance(int x, int y) {
        int res = x^y;
        int dis = 0;
        while (res != 0){
            if ((res & 1) != 0){
                dis++;
            }
            res = res>>1;
        }
        return dis;
    }

    //布赖恩·克尼根算法
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'.当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。
            xor = xor & (xor - 1);
        }
        return distance;
    }

}
