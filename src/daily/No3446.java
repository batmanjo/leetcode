package daily;

import java.util.Arrays;

public class No3446 {

    public int[][] sortMatrix(int[][] grid) {
        int[][] sort = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int[] temp = new int[grid.length - i];
            int x = i;
            int y = 0;
            for (int j = 0; j < temp.length; j++) {
                if(x >= grid.length || y >= grid[0].length){
                    break;
                }
                temp[j] = grid[x][y];
                x++;
                y++;
            }
            Arrays.sort(temp);
            x = i;
            y = 0;
            for (int j = 0; j < temp.length; j++) {
                sort[x][y] = temp[temp.length - j - 1];
                x++;
                y++;
            }
        }


        for (int i = 1; i < grid.length; i++) {
            int[] temp = new int[grid.length - i];
            int x = 0;
            int y = i;
            for (int j = 0; j < temp.length; j++) {
                if(x >= grid.length || y >= grid[0].length){
                    break;
                }
                temp[j] = grid[x][y];
                x++;
                y++;
            }
            Arrays.sort(temp);
            x = 0;
            y = i;
            for (int j = 0; j < temp.length; j++) {
                sort[x][y] = temp[j];
                x++;
                y++;
            }
        }
        return sort;
    }
}
