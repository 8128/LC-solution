# 一轮店面

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 百老汇演员面试(误) 技术电面面经 [[复制链接\]](https://www.1point3acres.com/bbs/thread-551948-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/551948)

### https://www.1point3acres.com/bbs/thread-551948-1-1.html

这个公司是真的小众。





受到技术面试 上来面试官先跟我介绍自己公司介绍了5min
然后让我说说自己的intern 让我一顿吹 觉得我还行
先写算法 很简答的String 转进制 数字大小不会超过int范围 因此可以很简单的做出来，记得超过10的数字要用字母表示就好

做算法就是求TOP K 分别有 sort、heap、quick select方法
动态TOP K 用BST 复杂度 O(logn + k)
然后是求平均数
avg = avg * count / (count + 1) + newNum ‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍/ (count + 1)
我看基本上这几年都是这几题。



## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 新鲜Broadway Tech第一轮电面过经 [[复制链接\]](https://www.1point3acres.com/bbs/thread-553335-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/553335)

### https://www.1point3acres.com/bbs/thread-299962-1-1.html

上一周做的oa，oa题和地里一样。今天上午10点phone interview，题也和地里一样，一道进制置换，一道topK。面试官是个亚裔阿姨，口音很好。
先介绍简历和项目，花了不少时间。
进制转换给的constraints很少，要自己想，比如进制范围等等。
TopK是给一些trading records，每一行包括公司名称和交易金额，求交易出现最多的K个公司的名字。
followup了两道，一个是online topK，用treeSet；第二个是求online的某个公司名字的平均交易金额，用map做。问如果交易金额很大会怎么样（overflow），怎么解决，答map里的value存平均数。（感觉也会overflow，但是面试官说这样就可以了）




‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍上午面完过了两小时直接收到next step的邮件，是3小时背靠背virtual interview。

最后求大米，求人品爆发！！！

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 百老汇科技 第一轮电面 [[复制链接\]](https://www.1point3acres.com/bbs/thread-552181-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/552181)

### https://www.1point3acres.com/bbs/thread-552181-1-1.html

OA过了约的电面





上来先自我介绍聊简历  随便问了一段实习   然后问了几个常规问题   what's the most challenging part，how did you deal with it,  conflicts between you and your mentor/boss/manager

coding第一题

转base     基本思路是从某个base转成base10  然后再从base10转成新的base   先问完所有的edge cases之后开始写         写完一半  说我现在已经转成base10了
然后再写完剩下一半 说现在转成新的base了

面试官问   那你会怎么测试code是否正确运行呢   
我说我就把下面一部分 comment out  然后输出上一部分的结果  如果转成正确的十进制数 上面一半就没问题   
测试下面一部分的结果也是同理    这样可以知道是哪一部分出了问题
她表示满意    也没测试任何的testcase 直接进入下一题


coding第二题
问有一堆的transactions  比如公司名  加上交易额  让输出交易次数最多的公司
我说用priority_queue做 里面存一个pair   然后写个comparator   按照出现次数高低排序    需要输出的时候就直接pq.front()就行了  
她问priority_queue是用什么实现的  我说用max heap实现的   
她问max heap和BST有什么区别   我说max heap只保证爹比儿子大  

followup是说现在不停的有‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍交易 让你实时输出出现频率最高的k个公司... 详见利口 有一道很像的题
我说那我们就需要两个哈希表 一个key是公司 value是出现次数      另一个key是出现次数 value是一个set 里面存了所有出现频率那么多的公司
每次就第二个哈希表往外读就行了
然后这样时间复杂度是nlogn
她说那你存那么多 是不是有点浪费啊 是不是可以就存k个........我忘记我怎么回答的了
只记得她说可以klogk。。。

最后问了点问题  然后就结束了

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) broadway technology 一面 [[复制链接\]](https://www.1point3acres.com/bbs/thread-552908-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/552908)

### https://www.1point3acres.com/bbs/thread-552908-1-1.html

今天刚面， 题目就是那几道
1. convert from original base to another base
2. top K
BTW， 这公司其实还是挺有效率的， 三姐面我的时候口音也很棒， 就是不知道结果咋样

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 新出炉的百老汇科技电面 [[复制链接\]](https://www.1point3acres.com/bbs/thread-551205-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/551205)

### https://www.1point3acres.com/bbs/thread-551205-1-1.html

前15分钟: 聊简历，做过的最有挑战的project以及用了什么architecture实现。
40分钟: Q1. 给一个代表一个数字的string，一个原base，一个新base，输出一个转化成新base的数字string

注意事项: 需要确认base的范围，例如2到36进制。需要考虑到Letter当超过10进制。需要确认会不会出现负数。

Q2. 不需要写代码，如果给一个static file里面每一行是公司名字和transaction。要求输出前K个被交易次数最多的公司名字。

我回答的可以直接Sorting, O(nlgn)。 或者Heap. O(n)创建, klogn extract k largest. Randomized Selection, expected O(n).

Q2 follow up. 如果不是static file而是一个stream，怎么办？

答 可以用balanced augmented bst, 每个node存subtrre sizes

后5分钟: 提问

今天通知过了电面下一轮3小‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍时的virtual interview 有面过的可以一起准备啊～

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 百老汇科技校园面试 [[复制链接\]](https://www.1point3acres.com/bbs/thread-447444-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/447444)

### https://www.1point3acres.com/bbs/interview/software-engineer-447444.html

百老汇科技，这个公司地里没有面经啊。。来贡献点数据。九月21号面了on campus，一个小时的interview。面我的是个白人校友。Behavior照常问了我的internship和resume和感兴趣的领域，详细问了project用了什么strategy和challenge之类的。





tech部分问了两道题：
\1. 蠡口思瑶吴，写了代码，然后问了follow up是利口四散，要求利用前一个题目的function
\2. 第二题是给了一堆交易，每一条交易的形式是“公司名称+交易号码”，每个公司可能多次交易，找出k个最频繁被traded的那个公司. 用了HashMap, Priority Queue, 问了时间复杂度，follow up是如果是real-time，不断有新的交易，如‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍何实时输出k个最频繁交易的公司



拿到了onsite。。。攒攒人品~~~

## 17年 | [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 小众【百老汇科技】校园面体验 [[复制链接\]](https://www.1point3acres.com/bbs/thread-294446-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/294446)

### https://www.1point3acres.com/bbs/interview/software-engineer-294446.html

之前想在地里搜面经，结果完全没找到。。。来贡献一个数据点

公司是个fintech，目前150人左右的规模，开发软件给各种大银行投行用。。面试内容跟glassdoor上的interview questions差别不太大，挺实际的。。on campus是1小时。

头发花白的大胡子白人老爷爷，语速飞快，上来噼里啪啦介绍了一圈自己公司，然后问proj：which one is the most challenging? why? tell me about your internship, is there any challenge that makes you astonished in the process? （第一次遇到这么问的... 答曰没有觉得很astonished诶，new tech stack对我来说很challenging但是我觉得学新东西很好玩，pm和ood的部分在学校proj里都做过所以并不觉得有啥意外的... 不知道是不是把天聊死了囧）

然后开始coding。

1. warm up：Add numbers原题，input是两个由string表示的数。followup1是时间复杂度和有哪些corner cases。followup2是两个string表示的数字相乘怎么做。

2. 有很多很多股票transaction，输出在这堆股票交易里，交易次数最多的k个公司的名称。伪代码，尽可能优化，followup是时间复杂度。

3. 有很多很多股票transaction，实时输出每个时刻的交易次数最多的k个公司的名称。伪代码，尽可能优化，followup也是时间复杂度。感觉应该类似sliding window maximum吧。

4. 有很多很多股票transaction，实时输出每个时刻的每支股票的平均交易价格。伪代码，应该是slidng window average吧。followup是如果数据量巨大，使用乘法a*b会爆内存，怎么优化（这个followup应该来自于我一开始用了ave2 = (ave1 * cnt + price2) / (cnt + 1)的做法）。

然后让我提问。。问了一下公司的结构，老爷爷说基本上就是纯tech，没什么pm，没什么management职位，所以只有engineer这一条‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍track。一两年entry level associate，n年staff engineer，n年senior engineer I II III，然后lead engineer基本上就到顶了。

没注意时间，出来才发现逼逼了1h20min，对不起后面那位同学了-.-    感觉人生很圆满...居然有生之年体验了一波fintech

补充内容 (2017-9-29 06:19):
发了onstie！秋招迄今面了6家，除了巨硬之外全都过了第一轮.. 可能跟巨硬天生气场不合吧-_-

## https://instant.1point3acres.com/discuz_thread/294446)

# 三轮VO

## 17年 | [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) 百老汇科技昂赛数据点 [[复制链接\]](https://www.1point3acres.com/bbs/thread-299962-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/299962)

### https://www.1point3acres.com/bbs/thread-299962-1-1.html

补个数据点。
四轮面试，每轮一小时，上午两轮下午两轮。考题比较偏数据结构基础，没有像on campus那样虐我sliding window maximum....
Round 1是白人大叔，coding + data structure。
coding是一个sorted的成环双向链表，给定一个随机起点，给定一个input value，插入这个input。
data structure是手写实现generic variable的hashmap的底层，实现put和get，并处理hashing collision, 和loadfactor超过之后怎样expand和rehash。
Round 2是天竺叔叔，两道coding。
第一题我至今没明白他到底point是啥... 原题是“想象一个marching band，所有人站成一排，每个人只能跟自己左边和自己右边的人交换一个note，请设计一个算法，让他们所有人可以同时开始演奏”。。。我：?????
不让换位置，所以没得树状传播信息啊？这是想考什么..... 懵逼了几个来回之后天竺叔叔说你想想怎么count这一排的总人数。。。。我说那我暴力了啊，左边右边同时开始报数，然后每个人就知道自己左边多少人右边多少人了，然后加上自己就知道总人数了。。。。他说对的，请问big O和space complexity是多少。。。。。我：所以你只是想问这个？？？？？他说是啊这虽然很简单，但的确是一个algorithm啊。。。。我：@_@
第二题终于正常了，给一个binary tree，想象它是一个左边、底边、右边的三角形，打印所有处于边缘上的node。注意左边和右边是可以拐弯的，一直打印到leaf才能停。
Round 3是白人高傲小哥，OO design + 问project。
设计一个task scheduler，用户可以添加任务并定义该任务的先行任务，可以开始任务，可以结束任务，可以获取当前可以开始的所有任务。光写API不够，代码要全写出来。
proj是自己选一个用了很多library并且写了很多代码的项目，然后问到database schema design，问到REST API，问到你到底写了哪些内容，问到为什么这么设计、为什么这么写、为什么选用这个tool，以及怎么test。
Round 4是白人和蔼小哥，data structure + coding。
data structure是问arraylist和linkedlist的区别，分别分析两者的implementation，问insert(index, value), append(value), delete(index), get(index)在两者的big O，以及space complexity（我愣了一波然后明白他其实是想问linked list的pointer会占用几个字节......卧槽）。然后说如果你设计一个win记事本类似的程序，你要怎么优化它的查找时间（他引导我往linkedlist of arraylist的方向说....）
（其实他说记事本的时候我一直以为是想问自动补全然后问trie.......结果一直是设计设计设计设计设计。。。不过小哥讲的设计我真心服气）
coding是给一个m*n矩阵（地图），每个格子里面都有一个数字（想象海拔高度），只能上下左右四个方向滑，只能从大数字滑到小数字（往山下滑）。如果一个格子的上下左右都比它自己大，那就停了（停在谷底）。要求output这个矩阵的每一个格子作为起点会停在哪里。用dfs + memorization写了。followup是给你其中一个谷底，给你一个山上的目的地，上山需要用绳子，绳子长度为数字之差（高度差），下山不用绳子，问最少需要多少绳子，以及怎么走。用dijkstra做就可以。
问及“对萌新有何建议么”，曰，每天刷几道题 :-)  （捂脸遁走....
早上状态没调动起来，Round1的逻辑很顺畅但是写码磕磕巴巴的，Round2没明白第一题到底搞什么，吃完午饭的Round3一开始想搞topological sor‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍t但是后来只写了暴力解，只有Round4比较无暇。最近精神状态不太好，尽力了，move on。。。。
他家onsite真的慷慨.... 三晚世贸对面的hilton，每天管吃管住管酒管party，食物质量很高（一整个周末，白天各种吃吃玩玩bowling + laser tag + bubbleball，晚上拉去pub搞party，无限量供应牛排和龙虾卷和任意酒水，结束了还可以去after party继续喝，真的服气）.... 感觉公司真的很有钱.... 来onsite的人里随便抓一个都是一把实习和TA的经历。。。就我最weak chicken。。。。这波膜拜大神来得不亏>_<

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) Broadway Tech虚拟昂赛面经 [[复制链接\]](https://www.1point3acres.com/bbs/thread-554556-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/554556)

### https://www.1point3acres.com/bbs/thread-554556-1-1.html

新鲜的virtual onsite面经。之前的电面参考我以前的帖子：https://www.1point3acres.com/bbs/thread-553335-1-1.html
virtual onsite一共三轮，用zoom视频背靠背面试，从10点半面到1点半（我真的饿死了啊），面试内容就是coding和ood，不问简历甚至连自我介绍都不用，每个面试官都直接切入正题。
题目可参考去年这位大佬的昂赛面经：以下内容需要积分高于 150 您已经可以浏览
https://www.1point3acres.com/bbs/thread-299962-1-1.html
题几乎一模一样
面试官1: 一个德州美国哥，他简单的自我介绍之后直接切入正题：
第一道题以下内容需要积分高于 150 您已经可以浏览
去年那位大佬的面经题，什么乐队传note，每个人只能和左边和右边临近的人传，问怎么让乐队所有人同时歌唱。 不用写代码嘴巴说就行，我觉得这是道智力题。答出来之后有个followup，说如果传的note不可以写数字，怎么办。想了好久，在提示下做出来了。这里就不发答案了，希望‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍各位能自己思考。提示：找队伍中间的人
第二道题以下内容需要积分高于 150 您已经可以浏览
也是原题，利口唔似无。要求写代码，写testcase，并且跑代码
面试官2:一个不知道哪个国家的人，有一些口音但不影响交流
第一道题：以下内容需要积分高于 150 您已经可以浏览
设计一个Task Scheduler类，也就是大佬面经里round3的第一题。是个OOD，有3个API，分别是addDependency；addCompletedTask；getRunnableT‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍asks。 基本思路也就是拓扑排序
第二道题：以下内容需要积分高于 150 您已经可以浏览
大佬round4的第二题。dfs+dp 没啥好说的
面试官3:一个在多伦多的白人小哥
以下内容需要积分高于 150 您已经可以浏览
两道题和大佬round1一模一样。利口疑似妻和设计哈希表
总的来说题和一年前大佬的昂赛几乎一模一样，真是服了。。。以为不会考原题没仔细看，导致一些题没有bug free。。。
面试官非常喜欢让你自己想test case，一方面我代码确实有bug，另一方面就算bug free了面试官也想考察你思维是否缜密。建议多想想testcase。
最后求大米，求offer！！！

## [[面试经验\]](https://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311) Broadway tech三连vo [[复制链接\]](https://www.1point3acres.com/bbs/thread-554236-1-1.html) |[试试Instant~](https://instant.1point3acres.com/discuz_thread/554236)

### https://www.1point3acres.com/bbs/thread-554236-1-1.html

百老汇三轮vo和地理看到的一毛一样
第一轮高冷白人小哥
task scheduler 就是有prequisite的那种
用hashmap记录就好
一个矩阵 只能下山 问你每个点最低到多少 dfs+dp
然后改成可以上山 问你刺杀国王最少要多少绳子 用dijskra
第二轮黑哥哥
打印binary tree边界
以及一个我也没听懂的一队‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍人同时演奏怎么搞
我就乱说的😂
第三轮 白人大叔
双联表插入数据
设计hashMap

