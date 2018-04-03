package com.zjgsu.offer.RobotMove;

/**
 * 机器人的运动范围
 * (迷宫问题)
 */
public class RobotMove {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int threshold = 5;
        int result = movingCount(threshold,m,n);
        System.out.println(result);
    }

    private static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        //初始化是true,重新覆盖
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = false;
            }
        }
        int count = movingCountCore(threshold,rows,cols,0,0,visited);
        return count;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        //判断能否进入这个格子
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
            + movingCountCore(threshold, rows, cols, row, col + 1, visited)
            + movingCountCore(threshold, rows, cols, row + 1, col, visited)
            + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        //边界判断
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
