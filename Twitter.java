package com.leetcode;

import org.apache.commons.collections.map.ListOrderedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Twitter {
    Map<Integer, List<Integer>> userFollowMap;
    Map<Integer, Integer> tweetMap;

    public Twitter() {
        tweetMap = new ListOrderedMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.put(tweetId, tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        return null;
    }
    
    public void follow(int followerId, int followeeId) {
//        if(userFollowMap.containsKey(followerId)) {
//            userFollowMap.get(followerId).remove()
//        }
//        userFollowMap.put(followeeId, followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowMap.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}