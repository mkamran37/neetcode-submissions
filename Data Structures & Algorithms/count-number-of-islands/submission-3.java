class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                String v = i + "," + j;
                if(grid[i][j] == '1' && !visited.contains(v)) {
                    islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j, Set<String> visited) {
        String v = i + "," + j;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited.contains(v)) {
            return;
        }
        if (grid[i][j] == '1' && !visited.contains(v)) {
            visited.add(v);
            dfs(grid, i + 1, j, visited);
            dfs(grid, i - 1, j, visited);
            dfs(grid, i, j + 1, visited);
            dfs(grid, i, j - 1, visited);
        }
    }
}
