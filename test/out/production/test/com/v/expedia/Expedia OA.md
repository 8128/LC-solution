# **Expedia的oa，感觉自己被白嫖了**

https://www.1point3acres.com/bbs/thread-574275-1-1.html

两道题，一道是类似于Longest Ordered Subsequence of Vowels，这个链接的代码： [https://www.geeksforgeeks.org/lo ... sequence-of-vowels/](https://www.geeksforgeeks.org/longest-ordered-subsequence-of-vowels/)
另一道是best friend，就是汤姆索亚历险记里面汤姆被罚刷墙的那个故事。基本就是这个链接的思路： https://www.geeksforgeeks.org/painting-fence-algorithm/

# **旅游网OA题**

[https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=573350&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D23%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline](https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=573350&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption[3046][value]%3D23%26searchoption[3046][type]%3Dradio%26sortid%3D311%26orderby%3Ddateline)

周末做的OA，发过来希望能帮到有需要的人，顺便攒攒人品，祝自己找到工作！第一题已经贴图，要求时间差；  第二题是去除字符串里面所有的元音字母； 第三题是要实现一个收银机，收到的钱和商品的钱，返回应该退多少钱。

# **旅游购票公司OA**

[https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=572625&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D23%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline](https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=572625&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption[3046][value]%3D23%26searchoption[3046][type]%3Dradio%26sortid%3D311%26orderby%3Ddateline)

第一题输入是一堆用户名，然后输出要求是按原来的顺序排列用户名，不过相同的用户名需要添加上后缀。比如：
input: [alex, frank, alex, xiaohong, xiaohong, alex]
output: [alex, frank, alex2, xiaohong, xiaohong2, alex3]
题目不难，就是用一个map记录下用户名和他们依次出现的频率。从头到尾扫一遍输入的list，第一次遇到就直接添加到要返回的list里，并记录在map里面。重复遇到的就从map里取值并加到用户名后面， 再依次添加到最后返回的list里就好。
第二题题目挺长的，又是party又是employee什么。但实际上是给你一堆unique id，其中数字1表示host，其他数字表示客人，并附上他们之间的connections，然后问host邀请客人去参加party的排列顺序。比如：
Sample 1：
  输入是 ：[1, 2], [2, 3], [2, 4]，
  它的顺序有可能是：
  [1, 2, 3, 4] 或者
  [1, 2, 4, 3]
  但题目要求同一层的order必须按照数字大小的先后顺序来排列，所以答案只可能是[1, 2, 3, 4], 然后因为1是host，所以不算在内。答案为[2, 3, 4]。
Sample 2：
输入是 ：[1, 2], [1, 3], [2, 4], [3, 5], [1, 5]
  它的顺序可能是：
  [1, 2, 3, 5, 4]
  [1, 2, 5, 3, 4]
  [1, 3, 2, 5, 4]
  [1, 3, 5, 2, 4]
  [1, 5, 2, 3, 4]
  [1, 5, 3, 2, 4]
  但题目要求同一层的order必须按照数字大小的先后顺序来排列，所以答案只可能是[1, 2, 3, 5, 4], 然后因为1是host，所以不算在内。答案为[2, 3, 5, 4]。
解法大概是建一个图，把所有connections丢进图里。然后把host的所有的下一步可能去的地方都加到一个最小堆里。然后bfs逐层扫，把每次扔出的id添加到我们答案里，把该id相关的connections放到最小堆里。最后堆为空的时候返回答案就好。记得，此处要加一个set来去重。
第三题是在一个数列里找最大的任意组合之和并且该组合的和要小于或等于阈值。比如：
Sample 1:
[1, 2, 3, 4, 5, 6, 7, 16], threshold = 15
那么输出为15 （因为【1,2,3,4,5】之和为15并且小于等于15）
Sample 2:
[1, 2, 4, 5], threshold = 10
那么输出为10 （因为【1,4,5】的和为10）
Sample 3:
[7, 3, 4, 4], threshold = 9
那么输出为8 （因为【4,4】的和为8且小于10且比其他小于10组合的值要大）
题目三当时借鉴了利口上一个discussion的解法，就是先把array的值sort一遍，然后bfs逐层求和，把当前层最大并小于等于threshold的组合记下。但是这个解法时间复杂度挺高的，只能过一半的test cases（7/14）。当时我又试了试其他解法，比如recursive，但是也没过几个test cases。最后时间到了，就只能交上去了。
后来私下又捣鼓了一下，发现其实这道题的跟利口的coin change挺像的。可以用dp来解。事不宜迟，我自己就在IDE里写下了dp的代码。这里分享一下给需要的同学们。
public static int getMaxSum(int[] nums, int threshold) {
     int n = nums.length;
     // 当前包含前n个element时，小于或等于threshold的最大的subsequence之和
     int[][] dp = new int[n + 1][threshold+ 1];

​     for(int i = 0; i <= n; i++){
​        dp*******************[0] = 0;
​     }
​     for(int j = 1; j <= threshold; j++){
​        dp[0][j] = 0;
​     }


    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= threshold; j++) {
          // exclude the current element
          dp[j] = dp[i-1][j];
          // include the current element if possible
          if (nums[i-1] <= j) {
             dp\*[j] = Math.max(dp[i-1][j-nums[i-1]] + nums[i-1], dp**[j]);
          }
          //System.out.print(dp****************[j] + ", ");
        }
        //System.out.println();
     }

​     return dp[n][threshold];
  }

如何提示不够memory的话，我们可以稍微简化一下上面的space complexity。代码如下：

 public static int getMaxSum2(int[] nums, int threshold) {
     int[] dp = new int[threshold + 1];
     for(int i = 0; i <= threshold; i++){
        dp = 0;
     } 

​     for(int i = 1; i <= nums.length; i++){
​        for(int j = threshold; j >= 0; j--){
​          if (nums > j) {
​              continue;
​          }
​          dp[j] = Math.max(dp[j], dp[j - nums*] + nums****);
​        }
​     }
​     return dp[threshold];
  }

*****这个答案应该能过大部分的test cases，但是由于threshold的范围很大而且是个long，返回的值也是个long（我自己在ide的代码返回的是int，所以看到题目的同学要注意long和int的区别），题目里写的是 1 <= threshold <= 10^18。而array最大的size是Integer.MAX_VALUE，显然上面的答案会在threshold特别大的时候出错。我想到了两点可能的解决办法，一是threshold的值大于数组所有数之和，我们直接就返回该数组之和就好，不需要进行额外的计算。如果数组之和也非常大比如比Integer.MAX_VALUE还大，那么应该可以用map来代替array进行dp计算。因为我是在自己的ide下面调试的，所以也没办法去验证能不能过题目给出的test cases。只能祝碰到这道题的同学们说一声祝你好运了。。最后，贴上recursive加memoization的解法。还有，记得自己在ide上面写一下，跑一下，这样可以做到心中有数。因为我的代码有可能有bug。。。*********
public static int getMaxSumRecursive(int[] nums, int threshold) {
     Integer[] dp = new Integer[threshold+ 1];
     return getMaxSumHelper(nums, 0, threshold, 0);
  }
private static int getMaxSumHelper(int[] nums, int sum, int k, int index, Integer[] dp) {
     if (sum < 0 || sum > k) {
        return -1;
     }
     if (index == nums.length) {
        if (sum <= k) {
          return sum;
        } else {
          return -1;
        }
     }

​     if (dp[sum] != null) {
​        return dp[sum];
​     }

​     int sum1 = 0;
​     // include the current element
​     if (nums[index] <= k) {
​        sum1 = getMaxSumHelper2(nums, sum + nums[index], k, index + 1, dp);
​     }
​     // exclude the current element
​     int sum2 = getMaxSumHelper2(nums, sum, k, index + 1, dp);
*********          *********dp[sum] = Math.max(sum1, sum2);
​     return dp[sum];
  }*********

# **Expedia OA 挂经**

[https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=565918&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D23%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline](https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=565918&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption[3046][value]%3D23%26searchoption[3046][type]%3Dradio%26sortid%3D311%26orderby%3Ddateline)

1. circular array





break a Palindrome

two junctions

University Career Fair

