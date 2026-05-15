class Solution {
    public boolean validTree(int n, int[][] edges) {
                if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int[] edge: edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        dq.addFirst(0);
        visited.add(0);

        while(!dq.isEmpty()) {
            int tmp = dq.removeFirst();
            for (int nbr: map.getOrDefault(tmp, new ArrayList<>())) {
                if (!visited.contains(nbr)) {
                    visited.add(nbr);
                    dq.addLast(nbr);
                }
            }
        }
        return visited.size() == n;
    }
}
