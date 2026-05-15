class Solution {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(n, 0, board);
        return result;
    }

    private void backtrack(int n, int r, char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            board[r][c] = 'Q';
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            backtrack(n, r + 1, board);
            board[r][c] = '.';
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }

    }
}
