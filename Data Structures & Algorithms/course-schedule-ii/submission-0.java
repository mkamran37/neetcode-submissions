class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int finish = 0;
        for (int[] pre: prerequisites) {
            indegree[pre[0]]++;
            map.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.addLast(i);
            }
        }
        while(!dq.isEmpty()) {
            finish++;
            int i = dq.removeFirst();
            result.add(i);
            for(int nbr: map.getOrDefault(i, new ArrayList<>())) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    dq.addLast(nbr);
                }
            }
        }
        return finish == numCourses
                ? result.stream().mapToInt(i -> i).toArray()
                : new int[0];

    }
}
