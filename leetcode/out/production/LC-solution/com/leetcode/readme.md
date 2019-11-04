# Leetcode Solution



4.3 Tomorrow is the day

Only problems later than Mar-4 are gathered here

## DFS/BFS

207. Course Schedule

     Give the courses which are alreay searched tags

210. Course Schedule II

     Don't forget that if there is a circle, you should return an empty array which should be initialized as new int[]{} but not int[numCourses]

     print the class that have entered the ans with 1; print the class haven't been entered with 0, print the class that being entered as -1

## Window



## Dynamic Programming

85. Maximal Rectangle：

    Height[] find the continous heigh; Left: if equal to zero,add one, if not show the number. Right:all five, if equal to zero, minus one, if not , show the number. Then the minus result will be the continous length, ans the height shows the depth

86. Word Break:

    Firstly test whether the string contains the word in dictionary, stored them in dp[length], use the second cursor to find the point where the former part is recorded and the second part contains the word in dictionary.

87. House Robber

    Store premax and current max, current max is to choose add the largest one from the next two values

88. Unique Binary Search Trees

    The possibility from left and the possibility from right

    Eg. When 4 is put into 123, then we can take any one number out and split the question into left part and right part which will not over 3

    i: different root   j:different length of left side and right side

    assume the number is put into the line, and we take out the number from the i position, then left side is G[i-1]and right is G[n-i]

279. Perfect Squares

     Make sure you iterate every square for the number, because 12's best answer is not dp[9]+dp[3], but dp[4]+dp[4]+dp[4]

## Queue and Stack

227. Basic Calculator II:

     Set the default sign to +, so the first time when it's not a number it will be pushed into the stack. Otherwise if it's x or /, use stack pop and calculate the result, and then push it back

## Heap

218. The Skyline Problem

     build a heap that can sort left first than sort y

347. Top K Frequent Elements

     Simple question, just use a priority queue, or add the frequency to a list and counte inversely

## Sql



## HashMap and HashSet

Always to use getOrDefault instead of check contain and use replace

202. Happy Number:

     Calculate the square and check if it's already in the hashset

203. Subarray Sum Equals K

     Use the sum-K, than the sum-K to the sum right now is K value

380. Insert Delete GetRandom O(1)

     design a random hashmap


## Bitwise Calculation

191. Number of 1 Bits:

     Solution1:test one bit and let the tester left move one bit <<=

     Solution2:use x &= x-1 to test how many 1 bit

