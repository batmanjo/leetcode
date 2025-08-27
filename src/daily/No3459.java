package daily;

public class No3459 {


    public static int[][] direction = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static int maxLength = 0;

    public int lenOfVDiagonal(int[][] grid) {
        maxLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // 找到一个起点
                    for (int k = 0; k < 4; k++) {
                        int currentLength = search(grid, i, j, k, true, 1);
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }
                    }
                }
            }
        }

        return maxLength;
    }

    // 沿一个方向搜索
    public int search(int[][] grid, int x, int y, int direct, boolean canSpin, int length) {
        if(!judgeMax(grid,x,y,length,direct,canSpin)){
            return 0;
        }

        int x1 = x + direction[direct][0];
        int y1 = y + direction[direct][1];
        boolean b = judgeBoard(grid, x1, y1);
        if (b && grid[x1][y1] == getNextValue(grid[x][y])) {
            int length1 = search(grid, x1, y1, direct, canSpin, length + 1);
            int length2 = 0;
            if (canSpin) {
                length2 = search(grid, x, y, spin(direct), false, length);
            }
            return length1 > length2 ? length1 : length2;
        } else {
            if (canSpin) {
                return search(grid, x, y, spin(direct), false, length);
            } else {
                return length;
            }
        }

    }

    // 旋转
    private int spin(int i) {
        if (i == 3) {
            return 0;
        }
        return i + 1;
    }

    private int getNextValue(int i) {
        switch (i) {
            case 1, 0:
                return 2;
            case 2:
                return 0;
            default:
                return 9;
        }
    }

    private boolean judgeBoard(int[][] grid, int x, int y) {
        // 检查是否出界
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0) {
            return false;
        }
        return true;
    }
    // 剪枝
    private boolean judgeMax(int[][] grid, int i, int j, int current, int direct, boolean canSpin) {
        int remain = 0;
        switch (direct) {
            case 0:
                if (canSpin) {
                    remain = Math.max(grid.length - i, grid[0].length - j);
                } else {
                    remain = Math.min(grid.length - i, grid[0].length - j);
                }
                break;
            case 1:
                if (canSpin) {
                    remain = Math.max(grid.length - i, j);
                } else {
                    remain = Math.min(grid.length - i, j);
                }
                break;
            case 2:
                if (canSpin) {
                    remain = Math.max(i, j);
                } else {
                    remain = Math.min(i, j);
                }
                break;
            case 3:
                if (canSpin) {
                    remain = Math.max(i, grid[0].length - j);
                } else {
                    remain = Math.min(i, grid[0].length - j);
                }
                break;
            default:
                break;
        }
        if (current + remain > maxLength) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        No3459 self = new No3459();
        int[][] gird = {{2, 2, 2, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}};
        System.out.println(self.lenOfVDiagonal(gird));

    }
}
