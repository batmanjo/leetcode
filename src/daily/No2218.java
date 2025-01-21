package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2218 {
    /**
     * 常规解法， 每次都拿最大的
     * [[80,62,78,78,40,59,98,35],[79,19,100,15],[79,2,27,73,12,13,11,37,27,55,54,55,87,10,97,26,78,20,75,23,46,94,56,32,14,70,70,37,60,46,1,53]]
     * 测试未通过
     */
    public int errorMaxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] max = new int[k + 1];
        max[0] = 0;
        int n = piles.size();
        int[] indexes = new int[n];
        int[] sum = new int[n];

        for (int i = 1; i <= k; i++) {
            int sumIndex = getMaxSumIndex(sum, piles, i - 1);
            int maxIndex = getMaxNum(indexes, piles);
            if (sum[sumIndex] > piles.get(maxIndex).get(indexes[maxIndex]) + max[i - 1]) {
                max[i] = sum[sumIndex];
                reset(indexes);
                indexes[sumIndex] = i;
            } else {
                max[i] = max[i - 1] + piles.get(maxIndex).get(indexes[maxIndex]);
                indexes[maxIndex]++;
            }
        }

        return max[k];
    }

    private void reset(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private int getMaxSumIndex(int[] sum, List<List<Integer>> piles, int i) {
        int max = sum[0];
        int index = 0;
        for (int j = 0; j < sum.length; j++) {
            if (i < piles.get(j).size()) {
                sum[j] += piles.get(j).get(i);
                if (sum[j] > max) {
                    max = sum[j];
                    index = j;
                }
            }
        }
        return index;
    }

    private int getMaxNum(int[] indexes, List<List<Integer>> piles) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] < piles.get(i).size()) {
                if (max < piles.get(i).get(indexes[i])) {
                    max = piles.get(i).get(indexes[i]);
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        No2218 self = new No2218();
        List<List<Integer>> piles = new ArrayList<>();
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(100));
//        piles.add(Arrays.asList(1, 1, 1, 1, 1, 1, 700));
        //[[80,62,78,78,40,59,98,35],[79,19,100,15],[79,2,27,73,12,13,11,37,27,55,54,55,87,10,97,26,78,20,75,23,46,94,56,32,14,70,70,37,60,46,1,53]]
        piles.add(Arrays.asList(80, 62, 78, 78, 40, 59, 98, 35));
        piles.add(Arrays.asList(79, 19, 100, 15));
        piles.add(Arrays.asList(79, 2, 27, 73, 12, 13, 11, 37, 27, 55, 54, 55, 87, 10, 97, 26, 78, 20, 75, 23, 46, 94, 56, 32, 14, 70, 70, 37, 60, 46, 1,53));


        System.out.println(self.maxValueOfCoins(piles, 25));

    }

    /**
     * 动态规划求解
     * dp[i][j]标识前i堆中取前j个硬币的最大值
     * j不变时，增加第i+1堆硬币能拿到的最大值为
     */
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                dp[i][coins] = dp[i - 1][coins];
                int currentPileSum = 0;
                for (int take = 1; take <= Math.min(piles.get(i - 1).size(), coins); take++) {
                    currentPileSum += piles.get(i - 1).get(take - 1);
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - take] + currentPileSum);
                }
            }
        }

        return dp[n][k];
    }


}
