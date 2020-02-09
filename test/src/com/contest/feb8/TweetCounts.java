package com.contest.feb8;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2/8/20 9:46 PM
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class TweetCounts {


    HashMap<String, List<Integer>> twToFreq;

    public TweetCounts() {
        this.twToFreq = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        this.twToFreq.putIfAbsent(tweetName, new ArrayList<>());
        List<Integer> freq = twToFreq.get(tweetName);
        freq.add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else if (freq.equals("day")) {
            interval = 86400;
        }
        List<Integer> li = this.twToFreq.get(tweetName);
        Collections.sort(li);
        //System.out.println(li);
        int end = startTime + interval;
        int temp = 0;
        for (int i = 0; i < li.size(); i++) {
            int time = li.get(i);
            if (time < startTime) continue;
            if (time > endTime) break;
            while (time >= end) {
                ans.add(temp);
                end += interval;
                temp = 0;
            }
            temp += 1;
            //System.out.println(temp);
        }
        if (temp != 0) {
            ans.add(temp);
        }
        //System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59));// All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
         // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60)); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
        tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
        System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
    }

}
