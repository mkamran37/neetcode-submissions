class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(int row, int col, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        grid[row][col] = '0';
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()) {
            row = q.peek()[0];
            col = q.poll()[1];
            for (int[] direction: directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (
                    r < grid.length &&
                    c < grid[0].length &&
                    r >= 0 &&
                    c >= 0 &&
                    grid[r][c] == '1') {
                        grid[r][c] = '0';
                        q.offer(new int[]{r, c});
                    }
            }
        }
    }
}
