class Twitter {
    private static final int tweetAmout = 10;
    private Map<Integer,List<int[]>> usersTweets;
    private Map<Integer,Set<Integer>> usersFollowees; 
    private int time;

    public Twitter() {
        usersTweets = new HashMap<>();
        usersFollowees = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        usersTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));


        Set<Integer> users = usersFollowees.getOrDefault(userId, new HashSet<>());
        users.add(userId);
        for(int followee : users){
            List<int[]> tweets = usersTweets.get(followee);
            if(tweets == null || tweets.isEmpty()){
                continue;
            }
            int position = tweets.size() - 1;
            int[] tweet = tweets.get(position);
            maxHeap.offer(new int[]{tweet[0],tweet[1], position, followee});
        }

        List<Integer> result = new ArrayList<>();
        while(result.size() < 10 && !maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();

            result.add(curr[0]);

            int nextIndex = curr[2] - 1;
            if(nextIndex >= 0){
                int[] tweet = usersTweets.get(curr[3]).get(nextIndex);
                maxHeap.offer(new int[]{tweet[0], tweet[1], nextIndex, curr[3]});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        usersFollowees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = usersFollowees.get(followerId);
        if(followees == null || followees.isEmpty()){
            return;
        }

        followees.remove(followeeId);
    }
}
