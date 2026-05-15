class Solution {
    Set<String> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int start) {
        if (start == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word.charAt(start) || visited.contains(row + "," + col)) {
            return false;
        }
        visited.add(row + "," + col);
        boolean res = dfs(board, row + 1, col, word, start + 1)
            || dfs(board, row - 1, col, word, start + 1)
            || dfs(board, row, col + 1, word, start + 1)
            || dfs(board, row, col - 1, word, start + 1);
        visited.remove(row + "," + col);
        return res;
    }
}
