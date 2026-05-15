class Solution {
    int TREASURE = 0, WATER = -1, LAND = Integer.MAX_VALUE;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        int steps = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == TREASURE) {
                    dq.addLast(new int[]{i, j});
                }
            }
        }
        while(!dq.isEmpty()) {
            int[] cors = dq.removeFirst();
            int row = cors[0], col = cors[1];
            for (int[] dir: dirs) {
                int r = row + dir[0], c = col + dir[1];
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != LAND) {
                    continue;
                }
                dq.add(new int[]{r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
