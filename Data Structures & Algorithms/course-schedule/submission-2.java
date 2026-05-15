public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[0],k -> new ArrayList<>()).add(pre[1]);
            indegree[pre[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            finish++;
            for (int nei : adj.getOrDefault(q.poll(), new ArrayList<>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}