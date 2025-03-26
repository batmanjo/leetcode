package daily;

import java.util.HashSet;
import java.util.Set;

public class No2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                int left = j,right = j;
                int top = i,bottom = i;
                while (--left >= 0 && --top >= 0) {
                    set1.add(grid[top][left]);
                }
                while (++bottom < grid.length && ++right < grid[0].length) {
                    set2.add(grid[bottom][right]);
                }
                res[i][j] = Math.abs(set1.size() - set2.size());
            }
        }
        return res;
    }
}
