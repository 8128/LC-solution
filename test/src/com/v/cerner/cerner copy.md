## 1
题目地里都有 一个temperature 一个提醒病人吃药 一模一样 自己想想就好了
第一个面试官让写class
第二个面试官在我描述完class之后直接让我实现一个方法
我觉得主要关注的还是能不能和面试官及时沟通 考虑到各种情况 code不一定需要写得很完美

## 2
1. Allergy class
让你设计一个类来表示一个allergy。一个allergy可能有各种sympton和reaction。一个allergy可以由一个病人或其亲属来report。一个allergy有它的严重程度。
2. Medicine schedule
一个病人要吃药，吃药的pattern有很多：吃n次，吃n天，余生都要吃，按需吃。给你一个start date，让你输出一个schedule包含每次吃药的时间。会给一个他们自己的Calendar类的文档让你来操作。
各个日期还是用Date类存放，文档里可能会缺乏Calendar对Date的转换。面试之前最好对java 1.7和 1.8的Date, TimeZone, LocalDate, Calendar和SimpleDateFormat 之类的接口了解一下，实际码一码。有可能还有设计Birthday的问题。
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=141006&highlight=cerner

3. Temperature class
给病人测体温，病人的体温一天内会有一度的波动，各个病人的体温也不同，体温可以由不同单位表示，可以由不同部位测。 如何设计一个体温的类。如何判断一个病人是否发烧。
encapsulation和enum多用就行，其它pattern啥的其实没啥要求

## 3
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=579810&extra=&highlight=cerner%2Bonsite&page=1

第一轮（实际上是原计划的第二轮）是个印度叔叔给面的，是真的没在客气，问了我Multithreading那题，doc和地里的一毛一样，关键是还问了我，process and thread的区别，我晕。。当场胡编啊，最后发现编错了，真的哭都没地儿哭，其他的包括我的个人经验也caught me off guard，我以为会问我简历写的，结果我忘记个人网站上include了早年写的ai pacman game，结果他就问了我这个。。还有乱七八糟的别的一堆，我感觉这场真的发挥一般吧。准备的answer都不是他问的，只好freestyle。然后technical的还问了那个提醒吃药的，也是写了一堆，followup一堆，各种问，只能说挂了就是自己菜
. 1point3acres
第二轮（原计划第一轮）就是今天面的，白人大叔，特别friendly，然后问了我好多bq，太多了，生平都跟他讲了一遍，反正有一道题我印象很深刻就是他问我有没有过和别人讲解一个概念但是对方不明白的经历，现在想的时候感觉当时回答的不好，主要是没答到点上，我主要说的就是每次解释我会用很多visualization来帮助讲解，如果一遍不懂就下一遍用更easier words来解释一些complicated concepts。但是我应该再解释一下 给别人讲解的key是在target specific problems，我感觉这个也是他想让我回答的，可惜，当时没get到55555 然后technical part就是temperature那题，大哥说我structure不错然后就过去了。

## 4
第一轮：一个senior software engineer. 3 behavioral: two proudest projects. tell me about a time when you help automate things. tell me a time when you tutor people in different ways.
1 OO question: make a temperate class. You can measure from mutiple spots, armpit, mouth, ear, in different units, celcius, farenheit, kelvin. Detemine if a patient has a fever.bq我之前准备了不少，但是那个automation还是caught me off guard, 总体觉得表现正常，还是都用star答出来了
第二轮：一个工作26年的architect.       3 behavioral: tell me about your summer intern. tell me about this project. tell me about a time when you have to deal with classified information.
1 OO question: make a device that notifies the nurse of patients' medication schedule. 这里是给了一个calendar api，但是他让我直接不用看，自己写pseudo code, 只要make sense就行。建议了解一下date, calendar, localdate, 可能思路稍微会清晰一点。
这一轮面试官非常laid back, oo写了一半就说 you stormed through everything, you can stop now. 接下来10分钟就随便聊了聊天，让我问问问题啥的。出去之前说i'm looking forward to working w you整体来说就是bq尽量多准备一些自己的经历，因为每个人都会拿着一个booklet进来 然后挑题目给你答。oo的话要用enum，多注意encapsulation, 多写method, 要用convertion的时候就写一下.

## 5
两轮。每轮一小时。  manager直接找你聊。
类型为 behavior question + OOD!  
其中behavior question 超级多 ，面试官有一个题库，大概两页纸，会问半小时左右。重点在这里

OOD 范围只有四道题。从四道里面出两道题让你做。   记住最终要的是你要和面试官一点一点讨论你设计的过程， 千万不要上来直接说答案，不然直接挂你

1. Allergy：对病人信息的统计，找到某个地区的病人，找到某个年龄的病
2. 提醒病人吃药的程序。吃药的模式有很多，比如吃n次，吃n天，余生都要吃，按照医嘱吃。给你一个start date，让你输出一个schedule包含每次吃药的时间。会给一个他们自己的Calendar类的文档让你来操作。
3. 给病人测体温，病人的体温一天内会有一度的波动，各个病人的体温也不同，体温可以由不同单位表示，可以由不同部位测。 如何设计一个体温的类。如何判断一个病人是否发烧。
4. Log file and concurrency， 会给你一个document. 很简单。

## 6
2/1當天virtual onsite (Hirevue)
第一輪是一位烙印lead sde：
問了30分鐘的behavioral，典型的自我介紹，介紹最近期的project，由於履歷多半ML相關還小問了supervise learning跟unsupervise差在哪並給例子，
還問了python跟java差異在哪(履歷都是python project為主但有提到會java)，還小問了oop的重要概念有哪些（回答了inheritance, polymophism,abstract等等）
還問了如何跟意見不合的人共事還有leadship經驗等等聊的挺開心的而再30分鐘後準備要考oo design的時候出現了點小插曲....面試官一直打不開連結然後耗了將近12-14分鐘....
最後我只剩15分鐘能寫題目是design temperature class to alert the nurse他是在一個叫whiteboard的tab上面打自己的碼我很快的大概把框架邊說邊寫了出來(這部分是不執行代碼的寫半碼即可)
但也沒完成(用的是java)最後考官說ok你快趕去下一個面試吧，最後補了一句you did awsome.


第二輪是跟烙印manager：
這裡我還很傻的在前一個Hirevue的聊天室裡等過了5分鐘想到要去另一個連接...進去後趕緊道歉我遲到以為是在上一間聊天室等...考官說沒事然後一樣開始30分鐘BQ問得一樣的介紹，然後我想在cerner做什麼為什麼選他們公司，
還有現在科技日新月異你怎麼讓自己可以一直update不同的新知，然後介紹實習project，用到的technical difficulty有哪些然後30分鐘後也是開始進入class design，這裡題目是design a medical schedule class of patients for nurses. 這裡也是先跟面試官討論了一些相關內容比如說doses這邊就是總共需要的劑量所以根據doses以及服用頻率可以決定要吃多久的藥(所以不一定有end date)，再來是medication這裏考官說到一個病人可能有多的medication你怎麼handle，我就說我用list array存然後會對應到start date, frequency doses等等然後frequency 我用的是enum來判定頻率是日週等等。老實說我這部分有些像車禍現場但我不斷地講自己的思路考官有不清楚的地方我就針對性地回答這樣，當初其實以為會掛在這一輪....這個主管面的全程都在打哈欠看起來是很累哈哈

## 7
第一轮是个白哥哥。问的medication schedule. 一开始写的只是system.out.println, 然后白哥哥说如果想一次print出所有的怎么办，我说存到一个list里。在permanent_medicine case里纠结了一下，就是要一直吃的药 要怎么提醒？我一开始写了一个while true, 然后白哥哥很诧异的说那不是不会停止了么，后来我又说用max_calander da'te感觉白哥哥还不是很满意，但是放了我一马没有追问。

第二轮是一个印度哥哥带着一共shadow的印度姐姐， 问的是tempurature design. 就是测病人的体温有没有发烧。题目很open, 要跟面试官讨论了很久最后还剩10分钟才开始写sturcutre. 最后讨论的结果就是用一个list 存每个temperature, 每存一个要算一次stream的average temperature, 然后用input和average temperature相比。然后又问了取median 和average的区别是什么，感觉最后越面越偏简直车祸。

## 8
两轮60m 的video，每轮30m BQ + 20m ood + 10m ask questions。两轮都是白人，感觉应该挂在第一个白人那了，我问他clarify question，比如doses 有没有1.5 这种情况，他反问我“你觉得doses 是什么意思”，然后大概解释了一下，让我自行判断。然后我回答BQ什么的，他的反应也都很平淡。 相反，第二轮的面试官会觉得我问clarify question 表明我有在思考，我回答BQ，ood什么的，也会说出具体觉得我哪里说的好。但是没用，还是挂了。
BQ：
    问了很多project， most interesting/difficult/XXX projects
    一堆实习相关的问题（还有问实习是如何采用agile development的）
    自动化任务的经验 （2轮都问了这个问题）
    most difficult / memorable bug
    work in irregular work hours
    negative feedback

OOD：
medicine class 需要注意doses，我一开理解doses 是什么意思，以为就是一次吃几片药而已。所以doses和endDate可以共存。后来面试官说doses是几个疗程的意思，吃完X个疗程之后就不要再吃药了，所以有doses 就不需要endDate

temperature class
让我写了判断发烧的方法
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=410105&highlight=cerner

## 9
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=412008&highlight=cerner
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=348651&highlight=cerner
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193838&highlight=cerner

地里这家的面经比较少，所以来贡献一波。总体来说这家题目都蛮简单的，重点是behaviour和与面试官的交流互动。整个流程如下：
HR 电话面：各种bq，why Cerner，然后问了java里面的Enum和String的使用场景，简单说一下能自圆其说就行。
Hirevue OA：算法题以及思维和口语考察。楼主抽到的是两题，各30分钟，然后每一道题之后需要录一个短视频讲述自己的思路。第一题蠡口幺吾幺，第二题蠡口伞两两。
昂赛：2.28飞Kansas City，入住市中心有近百年历史的一家希尔顿，下午hr过来带着所有考生乘shuttle在市区观光，感觉中西部城市人都比较悠闲，城市也蛮干净的。晚饭在他们新建的酷炫的innovation campus里面和他们的工程师一起吃饭，他们家食堂挺好，炸鸡烤肋排烤西葫芦都蛮好吃的。第二天一大早就集合去他家innovation campus。

一共两轮，题目都是glassdoor上有的那些，设计temperature class和设计medication class，感觉只要事先熟悉一下就行，多跟面试官交流问清楚他的需求就好，感觉这种题面试官心目中都有一个标准做法。还有一个题是看一个log找异常，是两个线程同时读写文件导致的竞争冒险问题，楼主没看太明白，大致讲了一下是因为没上锁，面试官没有深究。此外面试官还问一些常规bq以及简历相关的问题，简历问题问得不是特别细，所以大概说一下就OK。总的来讲心态放松，把面试官当成同事平等交流吧。面试完了之后由两个工程师带着我们参观他们的办公楼。
总的来讲onsite的体验还是不错的。他家new grad应该是三哥三姐的天下，跟LZ一批的考生一共20多个，里面大概70%是三哥，剩下的大部分是美国人。东亚裔一共四个：连LZ两个国人，另一个霓虹妹子，还有个妹子国籍不明。值得一提的是投职位的时候要注意job title，要投Academy Software Engineer - Sponsorship Available这个职位，他家另一个叫Academy Software Engineer的职位是不给sponsor的。
最后说一下时间线：1.9内推 - 1.30hr电话之后收到hirevue - 2.4做完hirevue - 2.8收到昂赛邀请 - 2.28去昂赛 - 3.9收到offer



## 10

1. Introduce yourself
2. Talk about a project that you have completed with a group (面试官似乎满有兴趣就聊了很多)
2-1. How did you pick your part to complete the project?
2-2. What did other teammate do?
2-3. How did your team seperate the works?
3. Talk about your internship (之后就聊了实习时做的 project)
3-1. What did you do when you are doing internship?
3-2. How did you face problems when doing your project?
4. What are the difficulties when you learn to code?
5. How do you debug your code? Talk about a situatoin.
Technical Part
1. Design a class that can track a patient's drug frequency.
吃药的frequency 可以是一天两次或三次或四次，也可以是PRN (Take when needed)。 会规定一个time period，所以要记录start date 和end date。
2. Log file and concurrency
会给一张纸，上面是关于不同thread access 同一个数据库Log。 问根据这个Log，会发现什么奇怪的地方?

履历 & Behavior
1. Talk about a project you have done outside of school
2. What did you do during internship?
3. Talk about a time that you managed to solve a problem that somebody else said something else different. (有的人说这样，有的说那样，你怎么做正确的判断)
4. Talk about an experience that you went to a face to face meeting and need to provide feedback to a sensitive person
1. 因为有很长的statement 所以我还是用中文大概简化一番。 简单说，就是写程序尤其像数据库会有debug。但有时候这些bug 可能需要手动除错，一旦手动就是会很麻烦很讨厌。既然这样很烦，那你之后怎么把它做成 automate 的方式？ 如果你没有这种情况，那想像一下你碰到这样的情况会怎么做
2. Design a class that hold temperature from patient.
这题没什么特别的，就是注意要有单位，温度，这体温是从哪里来的(嘴巴？还是耳朵？)
之後再 implement 一個 hasFever method。
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=139914&highlight=cerner

## 11
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=137099&highlight=cerner

## 12

第一轮：白人大叔
Behavior：
有没有遇到别人给bad feedback，怎么解决
有没有犯过technical的错误，怎么解决
介绍project和intern
OOD:
Design a medication class that helps nurses to maintain the schedule of the frequency that a patient takes drugs.
每个medication可能有不同的吃药的pattern，比如每天吃几个，按需吃药
follow up : what if a patient misses a time to take the drug, how would you make adjustment to your design to handle it

这个结束以后还有个看log找错的问题，就是面经里的那个race condition

第二轮：烙印
Behavior：
怎样automate繁琐的工作
遇到conflict怎么办
intern中遇到过什么问题，如何解决
OOD：
Design a temperature class and determine if a patient has a fever
follow up : what if we have more degree types besides Celcius and Fahrenheit

## 13
1.  第一面：问了些 behavior 问题，但是面我的香港大哥好像不不在意这些，然后草草的跳到了OOD环节，要求设计一个class来存储药剂方，会提供一个关于calendar的api，然后要写一个function是提供一个输入（用药频率，药剂方object），输出一个所有的含有用药时间的calendar 。然后这题结束后有一个服务器存储日志的案例，实际上是race condition，让你说一下具体怎么发生的，然后问怎么解决。
2. 第二面：大量behavior问题，例如做过什么项目，有没有利用什么方法把繁琐的事情自动化的经历。本人的一个项目恰好是实验室数据自动收集软件，所以说了以后面试官说这个问题已经被你回答了。最后behavior结束以后，来了个设计体温的class问题，要求能记录测量的位置，测量时候所用的单位，写一个方法如何判断是否发烧。发烧的条件大概是在同一个位置，同一个单位测量的条件下，体温差大于某个数。
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=140059&highlight=cerner

## 14

考了两道ood


\1. 提醒病人吃药的程序。

给出了吃药的frequency，每天多少，每次多少，总共多少，让自动reminder

会考月份天数不同之类的corner case




\2. 设计一个体温的类，给病人测体温，体温一天内会有一度的波动，各人也不同
体温有不同单位，可以由不同部位测
如何判断一个病人是否发烧
问你怎么把体温跟病人这个class结合起来

总之就是考虑各种情况～




Tech部分：
hashmap的原理，resize的问题，是不是线程安全

问了inheritance, polymophism,abstract




BQ部分：

leadership的经历
Tell me about your internship experience
How do you give a feedback to sb

Do you prefer front-end or back-end?
有效快速debug code

conflict怎么办

大概就记住这些～



第一轮遇到35~40岁左右南亚女Manager， 根本不问任何简历，上来直接问很奇葩的BQ，比如请描述一下你如何采用不同的策略来coach不同的人？比如你不能看代码，程序出问题了，你怎么知道是哪里出问题了。最奇葩的是，做OOD的时候，根本也不把题目发到codepad上，就草草的给你念了一边，我在讲我的design choice的时候以及clearify use cases的时候，她就不耐烦的把题目重新给我读了一遍。。然后她说你怎么处理不同人群体温可能不同，我说我们可以分不同类别的人群，她说你怎么能给人群分类呢？是不是歧视。。。

第二轮欧洲中年大叔，人很nice，整个过程很舒服也很开心