class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j, 0), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int area) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 
        + dfs(grid, r + 1, c, area + 1)
        + dfs(grid, r - 1, c, area + 1)
        + dfs(grid, r, c + 1, area + 1)
        + dfs(grid, r, c - 1, area + 1);
    }
}
