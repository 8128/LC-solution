# Bloomberg 面经



## 非常重要 98 Validate Binary Search Tree 

**要求stack**

三种解法：

1. 使用DFS

2. 使用stack 来取代 DFS，从而成为了BFS

   需要注意的就是，stack 里面加入的内容不是简单的一个节点， 和DFS一样，也应该包含上下限

3. 使用 inorder traversal



## 非常重要 445 Add Two Numbers II

非常简单的一个题目，利用一个stack就好了。 

把两个链表遍历出来，用stack 存储遍历出来的数字，然后按照后进先出的原则来相加，相加的时候需要注意没有没有进位



## 394 Decode String

```
s = "3[a2[c]]", return "accaccacc".
```

Use stack to read. "]" is the key point. 



##  412 Fizz Buzz & Followup 

412非常简单的一道题目

1195 用到了 thread 自己不是很清楚这是什么



## 1169 Invalid Transactions

非常的繁杂，算法倒不是什么高大上

首先判断数额超过的， 

然后按照人分成字典， 每一个人里面的交易按照时间排序

然后排序之后搜索时间上有问题的， 输出， 重复没什么问题， 最后用set缩减就行

最后输出的时候使用set缩减一下



## 28 Implement strStr()

要求：O(n^2)即可





## 723 Candy Crush 

一维版(stack) ，糖果消消乐

不适合找连通区域

要对每一个单元进行分别的判断



## 42 Trapping Rain Water

算出两边最大柱高，再算水面高度， 最后算出水容量



## 226 invert Binary Tree

非常简单的一个递归求解DFS

也可使用queue来实现BFS



## 235 Lowest Common Ancestor of a Binary Search Tree

充分利用二叉搜索树的性质来求解，父节点的值永远都在两个子节点之间



## 49 Group Anagram

使用了哈希表的相关问题

但是问题在于list不能用作 dict  的 key，那就转换成 str 使用





## 约瑟夫环

第二题，给你一个num表示有多少个小屁孩围在一起坐，编号从1，2 ...., num， 再给一个count。让第一个小孩从1开始报数，哪个小孩报到count，就把他踢出去，然后下一个小孩重新从1开始报数，如此循环，找出最后留下来的小孩的编号。
比如num是6， count 是4， 那么小孩编号座位就像下面这样
   1 — 2 — 3
   |               |
   6 — 5 — 4
第一轮，从1号开始报数，4号被kick out
第二轮，从5号开始报数，2号 out
‍‌‍‍‌‌‌‍‌‍‌‌‌‍‌‌...
第三轮，从3号开始报数，1 out
第四轮，从3号开始报数，3 out
第五轮，从5号开始报数，6 out
最后留下 5

约瑟夫环

使用list就够了，参考这里面的一个图

https://blog.csdn.net/u011500062/article/details/72855826



## 71 Simplify Path

关键是要找对思路，

首先把字符串按照 slash 分割， 忽略其中的空字符串和单点字符串

然后关注点放在 双点 符号上面，如果双点符号出现，就删除前一位的路径（除非无路径可删）

最后把所有的字符串用 slash 连接起来



## 987 Vertical Order Traversal of a Binary Tree

树的节点是char

很重要的是学习了 sorted sort 函数的 key 和 cmp 参数的含义





## 78 Subsets

两种方法

递归求解，每个数可以加也可以不加

或者巧妙一点使用非递归





## 509 Fibonacci number

很简单



## 208 Implement Trie (Prefix Tree)

Implement a Trie class





## 387 First Unique Character in a String

非常简单，全部统计一遍，存在哈希表里面

然后从头来，遍历一遍





## 425 Word Square

“我觉得自己并没有面的非常好，没想到还是给了onsite，可能bb更加看重综合表达能力？”



## 935 Knight Dialer

自己只想到了暴力的求解方法

主要是递归的基础上面使用到了 动态规划 的东西, 
就是用一个数组把前面已经算过的东西存起来



## 200 Number of Islands

需要用一个 visited 数组来记录









