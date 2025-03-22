package daily;

public class No2643 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > res[1]) {
                res[0] = i;
                res[1] = count;
            }
        }
        return res;

    }



}
