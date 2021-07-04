// Solution: hashtables
// Time complexity:
// postTweet O(1)
// follow O(1)
// unfollow O(1)
// getNewsFeed O(nlogn)
// Space complexity: O(n)
class Twitter {
    private static final int kMaxTweets = 10;
    private int time_;
    private Map<Integer, Deque<int[]>> user_tweets_;
    private Map<Integer, Set<Integer>> user_followers_;
    /** Initialize your data structure here. */
    public Twitter() {
        time_ = 0;
        user_tweets_ = new HashMap<>();
        user_followers_ = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Deque<int[]> tweets = user_tweets_.get(userId);
        if (tweets != null && tweets.size() == kMaxTweets)
            tweets.pollFirst();
        if (tweets == null) tweets = new LinkedList<int[]>();
        tweets.offerLast(new int[]{++time_, tweetId});
        user_tweets_.put(userId, tweets); // Java注意要加这行。
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>();
        Deque<int[]> tweets = user_tweets_.get(userId);
        if (tweets != null) feed.addAll(tweets);
        if (user_followers_.containsKey(userId)) {
            for (int uid : user_followers_.get(userId)) {
                if (!user_tweets_.containsKey(uid)) continue;
                feed.addAll(feed.size(), user_tweets_.get(uid));
            }
        }
        feed.sort((a, b) -> (b[0] - a[0]));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(kMaxTweets, feed.size()); ++i)
            ans.add(feed.get(i)[1]);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        user_followers_.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {  
        if (followerId == followeeId) return;
        user_followers_.computeIfAbsent(followerId, k -> new HashSet<Integer>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
