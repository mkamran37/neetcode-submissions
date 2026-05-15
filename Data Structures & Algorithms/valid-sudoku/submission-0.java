class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean validRow = true;
        boolean validColumn = true;
        for (int i = 0; i < 9; i++) {
            char[] row = new char[9];
            for (int j = 0; j < 9; j++) {
                row[j] = board[i][j];
            }
            validRow = validRow && isValid(row);
        }
        for (int i = 0; i < 9; i++) {
            char[] column = new char[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            validColumn = validColumn && isValid(column);
        }
        return validRow && validColumn && isValidSubgrid(board);
    }

    private boolean isValid(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    private boolean isValidSubgrid(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int rowIndex = i/3;
                int colIndex = j/3;
                String key = String.valueOf(rowIndex) + "+" + String.valueOf(colIndex);
                if (!map.containsKey(key)) {
                    Set<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    map.put(key, set);
                } else {
                    if (map.get(key).contains(board[i][j])) {
                        return false;
                    } else {
                        map.get(key).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
