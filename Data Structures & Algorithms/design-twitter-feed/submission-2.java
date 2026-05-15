class Twitter {
    private final Map<Integer, Set<Integer>> followerMap; // userId -> followees
    private final Map<Integer, List<Pair<Integer, Integer>>> tweetMap; // userId -> [time, tweetId]
    int time;
    public Twitter() {
        time = 0;
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Pair(time++, tweetId));
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Comparator<Pair<Integer, Integer>> comp = (a,b) -> Integer.compare(a.getKey(), b.getKey());
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(comp);
        List<Integer> result = new ArrayList<>();

        followerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int follower: followerMap.get(userId)) {
            if (tweetMap.containsKey(follower))
            for (Pair<Integer, Integer> tweet: tweetMap.get(follower)) {
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()) {
            result.add(pq.poll().getValue());
        }
        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.get(followerId).remove(followeeId);
    }
}
