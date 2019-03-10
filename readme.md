# Leetcode Solution





Only problems later than Mar-4 are gathered here

## DFS/BFS



## Window



## Dynamic Programming

85. Maximal Rectangle：

    Height[] find the continous heigh; Left: if equal to zero,add one, if not show the number. Right:all five, if equal to zero, minus one, if not , show the number. Then the minus result will be the continous length, ans the height shows the depth

139. Word Break:

     Firstly test whether the string contains the word in dictionary, stored them in dp[length], use the second cursor to find the point where the former part is recorded and the second part contains the word in dictionary.

198. House Robber

     Store premax and current max, current max is to choose add the largest one from the next two values

## Queue and Stack

227. Basic Calculator II:

     Set the default sign to +, so the first time when it's not a number it will be pushed into the stack. Otherwise if it's x or /, use stack pop and calculate the result, and then push it back

## Priority Queue



## Sql



## HashMap and HashSet

202. Happy Number:

     Calculate the square and check if it's already in the hashset


## Bitwise Calculation

191. Number of 1 Bits:

     Solution1:test one bit and let the tester left move one bit <<=

     Solution2:use x &= x-1 to test how many 1 bit

