class Twitter {

    HashMap<Integer, List<int[]>> tweets;    // only own tweets
    HashMap<Integer, Set<Integer>> follow;   // follow relationships
    int time = 0;

    public Twitter() {
        tweets = new HashMap<>();
        follow = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]      // max heap by time
        );

        // own tweets
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) pq.add(t);
        }

        // followees' tweets
        if (follow.containsKey(userId)) {
            for (int f : follow.get(userId)) {
                if (tweets.containsKey(f)) {
                    for (int[] t : tweets.get(f)) pq.add(t);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int limit = 10;

        while (!pq.isEmpty() && limit-- > 0) {
            result.add(pq.poll()[0]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}

