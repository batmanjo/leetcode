package daily;


import java.util.Arrays;

public class No1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length / 3;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + piles[piles.length - 2 * i - 2];
        }
        return sum;
    }

    static final int[] VAL_CNT = new int[10001];

    // 桶排序
    public int maxCoins2(int[] piles) {
        Arrays.fill(VAL_CNT, 0);
        int n = piles.length / 3, sum = 0, max = 0;
        for (int v : piles) {
            VAL_CNT[v]++;
            if (v > max) {
                max = v;
            }
        }
        boolean first = false;// 每次出现的元素值中能否从首位开始选取
        for (int v = max, c = 0; v >= 0 && c < n; v--) {
            if (VAL_CNT[v] == 0) {
                continue;
            }
            int times = VAL_CNT[v] >> 1;
            if (c + times >= n) {
                return sum + (n - c) * v;
            }
            if ((VAL_CNT[v] & 1) > 0) {
                if (first) {
                    times++;
                }
                first = !first;
            }
            sum += times * v;
            c += times;
        }
        return sum;
    }
}
