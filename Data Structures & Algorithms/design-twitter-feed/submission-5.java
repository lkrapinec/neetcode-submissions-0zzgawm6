class Twitter {
    Map<Integer, Set<Integer>> userFollowers;
    Map<Integer, List<int[]>> userTweets;
    int time;
    public Twitter() {
        userFollowers = new HashMap<>();
        userTweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[] {time, tweetId});

        time++;

        userTweets.put(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>(Comparator.comparing((int[] tweet) -> tweet[0]));

        Set<Integer> followers = userFollowers.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        for (int followerId : followers) {
            List<int[]> tweets = userTweets.get(followerId);
            if (tweets != null && !tweets.isEmpty()) {
                for (int[] tweet : tweets) {
                    maxHeap.offer(tweet);
                    if(maxHeap.size() > 10){
                        maxHeap.poll();
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }
        Collections.reverse(result);

        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = userFollowers.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);

        userFollowers.put(followerId, followers);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = userFollowers.get(followerId);
        if (followers != null && !followers.isEmpty()) {
            followers.remove(followeeId);

            userFollowers.put(followerId, followers);
        }
    }
}
