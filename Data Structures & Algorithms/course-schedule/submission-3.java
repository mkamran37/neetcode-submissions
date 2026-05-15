class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Deque<Integer> q = new ArrayDeque<>();
        int finish = 0;
        for (int[] prereq: prerequisites) {
            map.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
            indegree[prereq[1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.addLast(i);
            }
        }
        while(!q.isEmpty()) {
            finish++;
            int tmp = q.removeFirst();
            for (Integer nbr: map.getOrDefault(tmp, new ArrayList<>())) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.addLast(nbr);
                }
            }
        }
        return finish == numCourses;
    }
}
