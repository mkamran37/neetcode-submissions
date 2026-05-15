class Solution {
    private static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int max = 0, rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        grid[row][col] = 0;
        int area = 1;
        while(!q.isEmpty()) {
            int r = q.peek()[0], c = q.poll()[1];
            for (int[] direction: directions) {
                int nr = r + direction[0], nc = c + direction[1];
                if (
                    nr >= 0 && 
                    nc >= 0 &&
                    nr < grid.length &&
                    nc < grid[0].length &&
                    grid[nr][nc] == 1
                ) {
                    grid[nr][nc] = 0;
                    area++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}
