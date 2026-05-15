class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int islands = 0;
        List<int[]> directions = List.of(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
        );
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    Deque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
                    dq.add(new Pair<>(r, c));
                    while (!dq.isEmpty()) {
                        Pair<Integer, Integer> pair = dq.removeFirst();
                        visited.add(pair.getKey() + "," + pair.getValue());
                        for (int[] dir: directions) {
                            if ((pair.getKey() + dir[0]) >= 0 &&
                            (pair.getValue() + dir[1]) >= 0 &&
                            (pair.getKey() + dir[0]) < grid.length &&
                            (pair.getValue() + dir[1]) < grid[0].length &&
                            !visited.contains((pair.getKey() + dir[0]) + "," + (pair.getValue() + dir[1])) &&
                            grid[pair.getKey() + dir[0]][pair.getValue() + dir[1]] == '1') {
                                dq.add(new Pair<>((pair.getKey() + dir[0]), (pair.getValue() + dir[1])));
                                visited.add((pair.getKey() + dir[0]) + "," + (pair.getValue() + dir[1]));
                            }
                        }
                    }

                    islands++;
                }
            }
        }
        return islands;
    }
}
