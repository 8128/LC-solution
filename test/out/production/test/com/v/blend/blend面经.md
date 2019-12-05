## why blend

1. So blend is doing something meaningful, that is to improve the consumer lending experience, and I would like to contribute to something meaningful
2. I think blend's principles are great. So blend trusts each individual to make decisions in their area of responsibility, and that would be helpful in individual contribution, make people want to do more for the whole company
3. I see that you can have a flexible work schedule at blend, and I think that's great

## Question

1. for the new grad role, how large will the team be? i mean, the project team, commonly how large is the size of a development group?



Technical questions:

1. I'm interested in the main language used at blend, so i saw on the career page that experience with JavaScript, Angular.js, Node.js, Go, and Python would be a plus. So I do have javascript and python experience, but my main language is still Java, so I'm wondering which is main language at blend, maybe I need to spend more time on that one.



Blend principle

### Embrace the difficult path

We think beyond shortcuts and invest in solving the right problems.

### Decisions over outcomes

We focus on improving our decision-making quality instead of fixating on immediate outcomes.

### We work smart and hard

We view working “smart” as just the start. Working smart and hard drives improvements and accelerates career growth.

### Empowerment over control

We hire world-class talent and trust each individual to make decisions in their area of responsibility.





### Development

- Thoughtful, regular compensation reviews
- Support for workshops and lectures to develop your craft
- Meaningful equity and a 401(k) plan

### Wellness

- Comprehensive health benefits covered 100%
- Sponsored gym memberships, ClassPass credits, or wellness stipend.
- Lunch, dinner, snacks, and Pizza Fridays
- On-site meditation, yoga, and massages

### Flexibility

- Flexible work schedule, with open vacation policy
- 4 months of paid parental or personal leave
- Convenient location, with parking programs, and flexible commuter options

## Leetcodes



### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=571086&highlight=blend

第一轮利口武器 第二轮，有很多interval 比如[1, 6), [3, 7), [10, 99), 左闭右开， 要求所有端点（所有interval的start和end）处的count， count就是这个点处在几个interval中， 比如3在[1, 6), [3, 7)， 3的count就是2 用一个treemap存下所有interval的start和end， key是start或者end， value是1（start）或者-1（end）然后遍历这个map，依次加上每个点的value，就能算出每个端点的count

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=560530&highlight=blend

1. lc41 两种写法

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=534357&highlight=blend

1. 560

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=558756&highlight=blend

1. 2 sum

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=473809&highlight=blend

1.  Subarray sum to K
2. 不知道这题有没有什么好一点的解法，我用了比较naive的方法...最后没时间也就稍微讨论了一下time/space complexity
     input: a list of pair (3,7) (5,7) (5,7) (7,15) (8,12) (8,20) (14,20) 第一个表示一条record开始时间，第二个表示结束时间
     output: a list of pair (3, 1) (5, 2) (7, 1) (8, 3) (12, 2) (14, 3) (15, 2) (20, 0) 表示(time -> count) time 3时候有1条record active， time 5的时候有两条record active etc. input只有integer，区间范围左闭右开

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=388024&highlight=blend

 phone:

​          \1. LC 易柳柳

​     onsite:

​          \1. LC 思咦

​          \2. 设计一个网站点多少次的hit counter，注意要如何统计所有地方人的所有点击并且实时update加在一起的sum

​          \3. airbnb面经题menu item，就类似于combination sum，但写完了dfs让我写dp优化，这个return所有解还让我写dp也是醉

​          \4. 类似于 LC 起舞就

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=473165&highlight=blend

请多指教，请赏大米~ --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 问题描述： 几乎和LintCode 838一样。给定一个integer array和一个整数target，求出这个数组中的一个subarray元素加起来等于target。如果有多个满足要求的subarray，找出任意一个就行。如果找不到这样的subarray，返回null. 注意：要求返回一个数组  我在面试时的解答: 基本题目，利用preSum array和HashMap

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=466925&highlight=blend

第一轮：spiral matrix



第二轮：/*Substring Search: given a text of length n, a target string of length m,determine whether there is a substring of the text that matches the target string exactly

/*
Substring Search: given a text of length n, a target string of length m,
determine whether there is a substring of the text that matches the target string exactly

"hi my name is amelia", "amelia" => true
"hi my name is amelia", "foo bar baz" => false
"aazaaa", "aaa" => true
"abcbcd", "abcd" => false
"abababac", "ababac" => true
"foo bar baz", "ababac" => false
"ABC ABCDAB ABCDABCDABDE", "ABCDABD" => true
*/

其实就是利口28，然而要求我用O(n)的时间复杂度实现。我：要用KMP吗？面试官：你知道KMP？KMP太复杂了，你写不完的。用rolling hash写。我：...（内心mmp）

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=281475&highlight=blend

![IMG_5137.JPG](https://oss.1point3acres.cn/forum/201705/27/020725t3tiese17ne1nvjk.jpg)

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=465827&highlight=blend

本来第一轮没遇到地里的题还想着是不是开始出新题了，所以还狂刷利口来着。第二轮两个背靠背都是地里原题，matrix的那道，跟电话号码那个，各有一个follow up.求点大米。 

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=461318&highlight=blend

timeline:  10月中旬内推 10月底oa，地里原题, 不难 11.8电面： 面了merge k LinkedList，第一步是给的sorted string，要先把string转成linkedlist，自己定义listNode class，实现它要求的两个function, parseString 和print函数，然后第二步才是merge k LinkedList。给的input是array of sort strings，然后把所有string 转成linkedlist，再merge所有linkedlist后打印出来。  电面两个工作日后收到next-step消息，是两轮背靠背。  求加米！！

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=460257&highlight=blend

店面面的是fraction to Decimal, onsite面的是地里的generate matrix和lisp interpreter

```python
def fractionToDecimal(self, numerator, denominator):
       if denominator*numerator == 0:
           return "0"
       res = ""
       if denominator*numerator < 0:
           res += "-"
       numerator, denominator = abs(numerator), abs(denominator)
       n, remainder = divmod(numerator, denominator)
       if remainder == 0:
           return res + str(n)
       res += str(n) + "."
       counter = {}
       while remainder:
           if remainder in counter:
               res = res[:counter[remainder]] + "(" + res[counter[remainder]:]+")"
               break
           counter[remainder] = len(res)
           remainder *= 10
           n, remainder = divmod(remainder, denominator)
           res += str(n)
       return res


import copy
def move(grid):
    def robotMove(grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or  j >= len(grid[0]):
            return 0
        if grid[i][j] == 1:
            return 0   
        if i == len(grid)-1 and j == len(grid[0]) - 1:
            return 1   
        arr = copy.deepcopy(grid)
        arr[i][j] = 1
        return   robotMove(arr,i-1,j) + robotMove(arr, i, j+1) + robotMove(arr, i,j-1) + robotMove(arr, i+1,j)
     
    return robotMove(grid, 0, 0)



import copy
def move(grid):
  def robotMove(grid, i, j):
  if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
  return 0
  if grid[i][j] == 1:
  return 0 
  if i == len(grid)-1 and j == len(grid[0]) - 1:
  return 1 
  arr = copy.deepcopy(grid)
  arr[i][j] = 1
  return robotMove(arr,i-1,j) + robotMove(arr, i, j+1) + robotMove(arr, i,j-1) + robotMove(arr, i+1,j)
 
return robotMove(grid, 0, 0)

def letterCombinations(self, digits):
        if not digits:
            return []
        phoneMap = { '2' : "abc", '3': "def", '4':"ghi", 
           '5':"jkl", '6':"mno", '7':"pqrs", '8':"tuv",'9': "wxyz" }
 
        result = []
        self.dfs(digits, "", result,phoneMap)
        return result
 
    def dfs(self, digits, path, result,phoneMap):
        if not digits and path:
            result.append(path)
            return
        for letter in phoneMap[digits[0]]:
            self.dfs(digits[1:], path+letter, result,phoneMap)



import random
import copy
class MineSweeper():
    def __init__(self, row, col, mine_count):
        self.board = [["-" for _ in range(col)] for _ in range(row)]
        self.row = row
        self.col = col
        self.mines = self.place_mines(mine_count)
        self.gameOver = False
        self.visited = set()
        self.iteration = 0
        self.print_board()
        self.print_mine()
 
    def print_mine(self):
        print("Mines -------------")
        tmp = copy.deepcopy(self.board)
        for (row, col) in self.mines:
            tmp[row][col] = "X"
        for row in tmp:
            print(" ".join(row))        
 
    def print_board(self):
        print("Board at " + str(self.iteration)+ "th iteration: -----------------")
        for row in self.board:
            print(" ".join(row))
        self.iteration += 1
 
 
    def place_mines(self, mine_count):
        cnt = 0
        locations = set()
        while cnt < mine_count:
            row, col = self.generate_random()    
            if (row, col) not in locations:
                cnt += 1
                locations.add((row, col))
        return locations
 
 
    def click(self, row = None, col = None):
        if len(self.visited) == self.row*self.col:
            print("You win")
            self.gameOver = True
            return
 
        if row ==None and col ==None:
            row, col = self.generate_random()
            while (row, col) in self.visited:
                row, col = self.generate_random()
        print("Clicked at number {0} row, number {1} col".format(row, col))
        if (row, col) in self.mines:
            self.board[row][col] = "X"
            self.print_board()
            print("Game over!")
            self.gameOver = True
            return
        else:
            self.reveal(row, col)
            self.print_board()
 
    def reveal(self, row, col):
        mine_count = 0
        self.visited.add((row, col))
 
        for i in range(row-1, row+2):
            for j in range(col-1, col+2):
                if (i, j) in self.mines:
                    mine_count += 1
        if mine_count == 0:
            self.board[row][col] = "0"
        else:
            self.board[row][col] = str(mine_count)
            return
        for i in range(row-1, row+2):
            for j in range(col-1, col+2):
                if 0 <= i < self.row and 0 <= j < self.col and (i, j) not in self.visited:
                    self.reveal(i, j)
 
    def generate_random(self):
        return random.randint(0, self.row-1), random.randint(0, self.col-1)
 
 
if __name__ == "__main__":
    while True:
        config = input("Enter the number of rows, columns of the board size and mines with a space in between")
        config = config.strip().split()
        if len(config) != 3:
            print("Invalid input.")
            continue
        row, col, mines = int(config[0]), int(config[1]), int(config[2])
        minesweeper = MineSweeper(row, col, mines)
 
        while not minesweeper.gameOver:
            click = input("Enter row number and col number you want to click.").strip().split()
            row, col = int(click[0]) , int(click[1])
            minesweeper.click(row, col)    
          

          
          
def generateMatrix(self, n):
        if n == 0: return []
        if n == 1: return [[1]]
        result = [[0]*n for _ in range(n)]
        left, right, top, bottom = 0, n-1, 0, n-1
        num = 1
        while left <= right and top <= bottom:
            for j in range(left, right + 1):
                result[top][j] = num
                num += 1
            for j in range(top+1, bottom+1):
                result[j][right] = num
                num += 1
            for j in reversed(range(left, right)):
                if top < bottom:
                    result[bottom][j] = num
                    num += 1
            for j in reversed(range(top+1, bottom)):
                if left < right:
                    result[j][left] = num
                    num += 1
               
            left, right, top, bottom = left + 1, right - 1, top + 1, bottom - 1

        return result

# 11111 matrixm with 1 space between
def generateMatrix(width, height):
    if width == 0 or height == 0:
        print("")
        return
    if height == 1:
        print("1"*width)
        return
    if width == 1:
        for _ in range(height):
            print("1")
        return
    result = [[" "]*width for _ in range(height)]
    left, right, top, bottom = 0, width-1, 0, height-1
   
    while left < right and top < bottom:
        for j in range(top, bottom+1):
            result[j][left] = "1"
            
        for j in range(left+1, right + 1):
            if top < bottom - 1:
                result[bottom][j] = "1"   
               
        for j in reversed(range(top+2, bottom)):
            if left < right - 1:
                result[j][right] = "1"
               
        for j in reversed(range(left+2, right)):
            if top + 2 < bottom -1:
                result[top+2][j] = "1"        
        left, right, top, bottom = left + 2, right - 2, top + 2, bottom - 2
    for row in result:
        print("".join(row))
    return result

```


求大米呀，可怜的我只有15个大米

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=460766&highlight=blend

这次的题目是类似 污而散。给出一个input vector和target，如果有一个subarray的sum等于target，返回这个subarray。如果没有则返回空。如果有多种solution的话，返回最先发现的那个即可。input vector是有负数的，target也是可以为负数。subarray本身并没有最小长度限制，会出现input有一个值就等于target。有几个edge case，要注意如果整个vector的sum等于target的时候情况。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=459508&highlight=blend

先说下，地里的那十几到题都没有考到，现在看来**blend**是基本按照你的简历来针对性的出问题问了有向图如何判断cycle，followup是无向图判断cycle。  遇到的面试官人感觉非常好。详细介绍了公司的情况与小组的区别。然后让我简单介绍了简历上的两个project。因为其中一个project跟地图有关系，所以他很感兴趣。出题前也是明说，既然你比较熟悉，那就考你一下graph的题好了。 解体的过程中会主动给你提建议，跟你探讨会出现的情况，并且引导你作出正确的答案。虽然题不难。最后还给出了一些简历上的意见。最后有说觉得我很有机会进入下一轮。虽然面试官的话只能信一半吧。但当场能有feedback也很高兴。  最后插一句，blend感觉现在在湾区越来越出名了。去年跟今年都上了breakout list。8月份在做mortgage的基础上也开始步入insurance的市场。因为比较unique，感觉潜力很大。（顺便提下另一家flexport， 如果有同学大厂没能把握机会，找类似这两种潜力很大startup也是很好的选择） 求米！

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=457660&highlight=blend

九月份内推的，10月底OA，今天第一轮电面。面试官应该是美国人backend team，语速略快，他讲的挺多的，整个过程一小时，一道hard, 本质是merge k sorted lists. 但本人写了三处typo。。。听天由命 本人用的heap， 面试官最后建议divide&conquer, 就不用extra space了。 求米谢谢大家！

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=418032&highlight=blend

Round 2 - 店面PS1 一群人用电脑，根据各人需要上机的时刻， 判断需要多少台电脑。LZ用扫描线做的。
等待下一个店面PS2
求加米求onsite！

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=341230&highlight=blend

\1. 蠡口 妖污留
\2. 蠡口 污耳酒 相类似的，最后变成一个OOD design
\3. 地里面经题， 蠡口 污私 变形
\4. 路口红绿灯题，考OOD和实现

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=456588&highlight=blend

之前它家考过有道是add和mul的 现在变形成add和sub

 string => int 
4 => 4
( add 2 3 ) => 5 
( sub 5 7 ) => -2
 ( sub ( add 1 2 ) 5 ) => -2 
( sub 7 2 3 ) => 2

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=452682&highlight=blend

一个美国口音男码农用三藩电话打来，扯淡十分钟，干了啥，为什么微服务架构、怎么知道我们公司之类的。
[size=12.789999961853027px]CoderPad做题，莉蔻无而散的变形，输入有负数。给定一个整数数组和一个target，返回一段和是target的子数组。
例子:
输入；

{1, -3, 4, 8, 2, -14, 3}
9
输出: {-3, 4, 8}

完了就是尬聊，约定一个小时半个小时就面完了……

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=456023&highlight=blend

介绍product，然后问了不到十分钟的简历  面的是粒扣奇散遛的简单版 

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=455223&highlight=blend

上周五面的，两轮视频昂赛。挂在第二轮了，面试官问了些BQ，关于**blend**

第一轮好像是别家出现过的面经题？反正有印象见过。这轮还是比较顺利的，面试官也很nice。

Lisp-like Interpreter
  Write a lisp-like interpreter that supports basic add and sub operators with a parenthesized prefix notation
  Sample Test Cases

 string => int 
4 => 4 
( add 2 3 ) => 5 
( sub 5 7 ) => -2
 ( sub ( add 1 2 ) 5 ) => -2 
( sub 7 2 3 ) => 2
第二轮就懵逼了，不会做给一个 double array，如 [0.7, 2.8, 4.9]1. 计算出 rounded sum，比如 8.4 -> 82. 返回新 int array，这个 array 里的每个元素是 double array 里每个元素的取整（向上或向下），需要满足的条件是：这个 int array 的 sum == 8，并且对应元素之间的差值的绝对值之和最小
上面的例子里，int array 可以是：[1,2,5] 此时的差值绝对值之和是：0.3 + 0.8 + 0.1 = 1.2 ； 但如果 int array 是：[0,3,5]，此时差值绝对值之和是：0.7 + 0.2 + 0.1 = 1，此时最小，所以答案是 [0,3,5]
最后的思路是，因为每个元素都可以有两种取法，向上或者向下，跑一次dfs，拿到所有sum == 8 的int array，再去计算差值绝对值之和，取最小那个。不知道思路对不对，最后也没实际跑代码。。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=288894&highlight=blend

**blend** 2018 summer 实习 面筋！！  七月初 HR contact 我，和HR聊了一下，发来了OA。OA和地里以前的一样（自己搜一下，感谢前辈！！） OA过后，约电面。电面LRU，问的比较细。电面过了，约virtual onsite，两轮back to back，一轮是要process string，有点类似于valid parenthesis。一轮是spiral matrix变形。。。  spiral matrix 做得太快了，结果面试官说再来一道吧。。。哭晕在厕所。。新的一道也是spiral matrix 的变形，但是要求更细 （好好仔细看leetcode discussion）！！  发个面筋，攒个人品，求offer！！

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=439451&highlight=blend

上周五面的，李口舞期
面得不好，用的方法是把给的interval放入list里面，再sort一遍开始的点，然后for loop比较值，所以是nlogn。应该直接讨论interval的情况，应该是liner。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=446718&highlight=blend

最近面的。网上海投，投完给的店面，之后给的onsite  店面： 给一个grid，一个机器人在里面move， 可以move四个方向， 找出从左上到右下角move不重复格子路线的数量， 不必走完所有的格子  onsite - 找出所有人都有空的区间，秒了之后在聊天 - 午饭 - 找出一个unsorted 数组里miss的第一个正整数，【1， 2，0】 返回3这样子。写个一个sort的解法，然后想了先扫一遍找到最大值，然后一个开最大值数组，然后扫一遍的解法，最后被提示了之后，开一个从1到数组长度的数组的解法， 然后实现了两种解法，最后写test case 和 test suite

\- [system design](http://https//www.educative.io/courses/grokking-the-system-design-interview?affiliate_id=5749180081373184/)， tiny url shortener，focus在写操作上
\- HM 聊天

\- 利口上找出循环小数那题。。。很累了写得很紧张。。。




发面经攒RP求过

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=450314&highlight=blend

大哥先介绍了他们做什么，感觉他自己也不是很清楚整体结构。。。他刚工作七个月

然后两个部分
\1. 给一个string，比如"1->2->3"，里面数字是sorted，parse成一个linked list
\2. merge k 个这样的string，蠡寇 饵伞

因为我没用python写过linkedlist，所以C++花了不少时间搞定syntax写第一部分
最后第二个部分只写了想法，分析了复杂度

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=323540&highlight=blend

听说发帖能够攒人品拿offer，同时也谢谢地里的人一直以来给我的帮助，并祝各位新春快乐，offer多多。  Timeline：1月底内推，2月初recruiter 打我的电话，2月9号一面，2月16号video onsite  总体来说面试经历很不错，HR回复非常迅速，面试官态度友好。题目和地里面别人说的还真不太一样，所以觉得有发帖的必要。  一面：Write a funtion that takes a list of positive intergers and a target positive integer, return true if there is a contiguous series that equals the target.  ex: [1,5,7,3,9,1,3] , 20-> true(7,3,9,1)  video onsite:  第一轮： **Divide two integers. Surround repeating sequence in decimal part with parentheses. For example,****divide(4, 2) = "2" divide(2, 4) = "0.5" divide(1, 3) = "0.(3)" divide(1, 7) = "0.(142857)"**** ****第二轮：Spiral Matrix（和地里的一样）** 喜欢这家公司，面试官三个都是Caltech/Stanford毕业的，而且很喜欢这样小型/有钱的startup，希望能够拿到Offer!!



### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=224671&fromuid=197541

是一个特别耐心的美国小哥给我面的。这个题目一开始居然没有想到是用merge interval来做，而且到后面命名变量的时候有点儿慌，导致到后面错误使用的变量，然后结果一直不对，幸好在最后写出来了。。。但是。。。感觉面的很是不好啊。。。求人品，求onsite! 刚刚收到pocket gems的据信好伤心啊
Suppose we want to build a scheduling app. We have the times people are currently busy, e.g.
{
 Alice: [(13.5, 14), (15.75, 17)],
 Bob: [(9, 12), (13, 14), (14, 16)],
 Eve: [(9, 11), (12.5, 13.5), (14, 15), (16, 18)]
 Mallory: [(0, 9), (12, 24)]
}

For simplicity, lets represent times as numbers between 0 and 24 and the times people are busy as (start_time, end_time) pairs. For example, (13.5, 14) means that Alice is busy from 1:30PM-2PM.

Given a list of people's schedules, write a function to return a list of the time intervals all the people in the list are free to meet.

For the example above, here's some sample output:
Alice, Bob => [(0, 9), (12, 13.5), (17, 24)]
Bob, Mallory => []
Alice, Bob, Eve => [(0, 9), (12, 12.5), (18, 24)]

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=364536&highlight=blend

还不知道结果，先发了面经吧。

做一个计算器，只要求加法和乘法。输入是一个字符串，类似于：
( mul 2 ( add 1 4 ) 3 )

一开始面试官没说字符串的结构，我也忘了问。然后就使劲parse字符串，弄得非常复杂。
最后我才想起问这个字符串里的空格是什么样子的。她说每个字符之间至少一个空格。
那其实就直接先split转换成数组输入就好了啊。。。。哎。。。

等面完了用了5分钟就写出来了。。。奔。。。

代码也贴这了。。。

```python

import sys
import unittest


def compute(inputs):
    if inputs[0] not in ['add', 'mul']:
        return int(inputs[0])
    elif len(inputs) == 1:
        raise ValueError('input error...')
    operands = [int(x) for x in inputs[1:]]
    if inputs[0] == 'add':
        return sum(operands)
    elif inputs[0] == 'mul':
        return reduce(lambda x, y: x*y, operands, 1)


def calculator(string):
    string = string.split(' ')
    string = [x.strip() for x in string if x not in [' ']]

    stack = []
    i = 0
    while i < len(string):
        if string[i] != ')':
            stack.append(string[i])
        else:
            substring = []
            while stack and stack[-1] != '(':
                substring = [stack.pop()] + substring
            stack.pop()
            res = compute(substring)
            stack.append(res)
        i += 1
    return stack[0]


class MyTest(unittest.TestCase):
    def test(self):
        self.assertEqual(calculator('( 4 )'), 4)
        self.assertEqual(calculator('( add 2 3 )'), 5)
        self.assertEqual(calculator('( mul 4 ( add 2 3 ) )'), 20)
        self.assertEqual(calculator('( mul 2 ( mul 2 ( add 1 3 4 ) 2 ) )'), 64)
        self.assertRaises(ValueError, calculator, '( mul )')

unittest.main()
```

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=341205&highlight=blend

小哥问了蠡口 妖器之后问了一些相关的follow-up，比如怎么快速的查找啊？ -- 生成一个look up table {'23': ['ad', 'ae']} 还有一个follow-up忘了，总之基本就是怎么构建一个look up table之类的。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=304916&highlight=blend

Blend两轮挂第一轮：里口式旗 follow-up是如果要打字的时候，输出单词是在字典里头的怎么办，回答用trie 第二轮：丽抠而吴伞的变形，有很多人，每个人都给一个没空的区间，要得到所有人都有空的区间，方法类似丽抠而吴伞，把大家没空的都merge出来，然后取反就是大家都有空的时间了 莫名被挂不给反馈

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=310645&highlight=blend

上个星期四面完Blend的virtual onsite，就是两个背靠背的视频电面。整个申请Blend的timeline是这样：

11月初，在[linkedin](http://redirect.viglink.com/?key=a1aa544c3b328def412653f9fc432107&u=http%3A%2F%2Flinkedin.com)上勾搭在Blend工作的校友，对方马上表示可以帮忙递简历。
11月中旬，发OA，跟地里有的一模一样。
11.30，第一轮电面，是一个美国小姐姐，面的是地里有的那道不同人有不同available times，用merge求所有人都有空的时间那道题。我当时没想到直接用merge，但是整体思路是对的，用了一个巨麻烦的办法写了很多行，bug无数，中间小姐姐可能都没在听了。我感觉跪了但是12.4收到回复说positive feedback，约第二轮视频电面。
12.14，第二轮视频电面，第一个是一个美国小姐姐，面的电话号码组合那道题，第二个是一个（很帅的）亚裔小哥哥，面的是LRU，这两道题我都做过但都不是很熟。都是最开始把大框架写对了，然后慢慢debug。

Blend是个startup，但是感觉非常不错。我之前把地里关于Blend的面经都看了一遍，发现他们就那几道题，都不换题的，而且不管是第一轮还是第二轮电面，没有难度的递进，都有可能。再然后是不管你是本科硕士博士，都是那几道题，把面经看一遍就行了。因为二面是视频，所以感觉很棒，我好喜欢那个小哥哥，觉得在这样的team里面工作应该很棒。不过地里之前有人说他们家不给办H1B，求证实。

我还没收到结果。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=308278&highlight=blend

先说一下时间线：  10月底内推 做完OA 和HR打了一个十分钟的电话 十一月上电面 期间video被鸽了一周 十二月初二面两轮back-to-back OA和地里前辈发的一样 电面丽扣司诗怡 美国小哥哥 当天就收到邮件约video back-to-back 第一轮美国小哥哥 丽扣无事撕变形。打印m*n matrix row和row，col和col中间空一行。举一个栗子！ 1 1 1 1 1 1       1  1 1 1 1      1 1 1 1 1 1 第二轮abc小姐姐 原题地里也有前辈分享过了（感恩的心）。给一串人各自没有空的时间区间，求指定几个人都有空的时间。 地里的帖子：http://www.1point3acres.com/bbs/thread-224671-1-1.html  Over！ 攒个人品求offer

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=306852&highlight=blend

OA后和recruiter打了个电话就约电面，美国小哥哥面的first missing positive，结束问了下复杂度，尬聊一会就结束了。第二天recruiter说positive feedback 之后约了两轮背靠背，求一波人品，积一下德。 

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=301274&highlight=blend

就简历和算法题 输入1和3，返回一个string把重复的部分包起来如，0.(3) 

| 做除法，注意有更复杂的case，比如1/11,1/12                    |
| ------------------------------------------------------------ |

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=217829&highlight=blend 

最近打算有空的时候就陆续发自己找工的面试题目回馈下大家。。先来发个小众的Startup，Blend。这个是我当时实习时候，参加了旧金山的一个招聘交流会投的一个公司（忘记交流会全名是什么，都是湾区很多很不错的Startup和已经在湾区实习生的一个交流招聘会）。Blend主要业务是给银行做房贷系统。感觉差不多已经开始盈利。然后bar不低，感觉公司至少20%的员工都是Standford毕业的。一开始两轮电面 （由于8月份面的，真的不记得很多detail了）： 1: 第一题是类似leetcode的sprial matrix的小变形。 2: 第二题真的不记得。  Onsite： 他们家要求自己带laptop去写，不是写白板上，但题目都不难。 1: 一个微软跳槽来的小哥。要求实现类似数据库的inner join, outer join。然后为了简化，input就拿矩阵当作table。 中午吃饭，午餐很不错，据说从周边餐厅订的。 2；一个印度小妹演示他们家的系统。 3: 又开始面，很简单的一题，问一个二维矩阵，从左上角走到走下角，不重复走一个格，return几种可能。 4: 三轮的面试官要吹下，Standford的物理PhD，毕业后创办了一个农业科技公司，成功被收购。休息了一段时间，作为第8（9？）个员工加入Blend。不过问的题目很简单。就说他之前农业公司会检查样品，编号比如100，101，102，103，。。。但有时候农民会按错，比如100，101，103，104，。。又或者100，101，1ab，。所以检测这种异常情况。然后如果不连续的数字很大，就假设是故意的，没问题。。比如100，101，200，201.。。。一开始被大神吓到了，后来发现够简单的，可以用库函数，比如Integer.valueOf()，扫一遍就可以。之后就聊聊天，问大神为什么选择Blend。他就吐槽了Facebook，Uber一会。。前者只会让青少年浪费时间点击各种广告，后者n年没几个new feature。。Blend他觉得够cool。。 5: 四面也是很简单，1d和2d的快速求子数组的和。比如求数组array[5,6,...10]的和，数组不可变，连线段树都不用。 6: 五面终极boss，CTO。终于遇到了道难度不低题目（因为之前没见过这题）。其实也是很典型的interval问题。给出一堆员工上班的时间，[5,10）,[8,9）,[9,12）,。。求最多有多少个员工在同时上班。。实现的时候要求避免定义其他辅助类（提高难度）。。我写出来但代码很冗余，经提醒把代码弄的elegant了不少。。后来聊天，刚毕业，CTO大神拿到flag等等n多offer，后来决定加入一个Startup（很有名气，但面试有段时间了，忘记他说哪家了），那家Startup上市做大后决定离开，加入Blend。  后来两天后收到拒信。个人感觉这次面试是偶那么多面试表现的最好之一。被拒主要原因（根据Recruiter的反馈和我自己猜测），技术不是很match，他们需要full stack等网页开发或者后台开发，然后暂时来说他们更想focus在开发各种new feature而不是做什么数据挖掘，我刚毕业的光会做题的确不够bar。

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=195364&highlight=blend

first Missing Positive

### https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=223952&highlight=blend

刚刚面了1面，问了地里面之前面的小伙伴，他们有面过unique paths的 我面的是lru cache, 这个题目单纯写还是要写挺久的，磕磕绊绊半个小时才写完。 小哥非常nice, inital是AL 攒人品！求二面！

