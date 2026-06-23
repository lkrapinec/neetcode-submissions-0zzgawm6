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
        if (tweets.size() > 10) {
            tweets.remove(0);
        }

        time++;

        userTweets.put(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>(Comparator.comparing((int[] tweet) -> tweet[0]).reversed());

        Set<Integer> followers = userFollowers.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        for (int followerId : followers) {
            List<int[]> tweets = userTweets.get(followerId);
            if (tweets != null && !tweets.isEmpty()) {
                int index = tweets.size() - 1;
                maxHeap.offer(new int[] {tweets.get(index)[0], tweets.get(index)[1], index - 1, followerId});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] data = maxHeap.poll();
            result.add(data[1]);
            if(data[2] >= 0){
                int[] tweet = userTweets.get(data[3]).get(data[2]);
                maxHeap.offer(new int[]{tweet[0], tweet[1], data[2] - 1, data[3]});
            }
        }

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
