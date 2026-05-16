class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int[] edge: edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            dq.addLast(i);
            while(!dq.isEmpty()) {
                int tmp = dq.removeFirst();
                for(int nbr: map.getOrDefault(tmp, new ArrayList<>())) {
                    if (!visited.contains(nbr)) {
                        visited.add(nbr);
                        dq.addLast(nbr);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
