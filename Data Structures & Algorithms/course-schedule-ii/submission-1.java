class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int[] p: prerequisites) {
            map.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            indegree[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.addLast(i);
            }
        }
        while(!dq.isEmpty()) {
            int tmp = dq.removeFirst();
            result.add(tmp);
            for(int nbr: map.getOrDefault(tmp, new ArrayList<>())) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    dq.addLast(nbr);
                }
            }
        }
        if (result.size() != numCourses) {
            return new int[0];
        }
        int[] re = new int[numCourses];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}
