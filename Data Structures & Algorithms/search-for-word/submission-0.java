class Solution {
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(board, word, new HashSet<>(), 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(
        char[][] board, 
        String word, 
        Set<String> visited, 
        int i,
        int r,
        int c) {
            if (i >= word.length()) return true;
            if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited.contains(r+","+c) || word.charAt(i) != board[r][c]) {
                return false;
            }
            visited.add(r+","+c);
            boolean res = dfs(board, word, visited, i + 1, r + 1, c) || dfs(board, word, visited, i + 1, r - 1, c) || dfs(board, word, visited, i + 1, r, c + 1) || dfs(board, word, visited, i + 1, r, c - 1);
            visited.remove(r+","+c);
            return res;
    }
}
