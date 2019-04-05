# Amazon 4.4 面经

1. introduce youself
2. 简历说到一半被打断，说要问点BQ的内容，然后问了工作中有没有做extra work。我说我做完daily job之后会帮助协调组与组之间沟通，帮忙开会，又问我为什么要开会，我回答说要develop新平台，各个组都有构想但是想法不一样，问为什么想法不一样，我就举了个例子用户需要array但是返回值是arraylist，所以需要沟通调解问题。英文差可能没讲清楚，他半信半疑，又问我有没有其他extra work，我说我提供emergency pipeline，他问我为什么要这样做，我回答测试平台有时候会出问题，需要其他管道来解决问题。他说一般花多久，我说半个钟头
3. 问有没有software development的经历，我说了个Android application的，问我为什么要这么做，我说因为当时垃圾图片很多，user可能需要分类
4. 小知识点：先问OS是干什么的……我傻了，说了个management of resources like cpu and memory……然后问还有什么，我说硬件管理，又问还有什么，我说thread process分配，还能方便用户使用，有的提供界面改善user experience，他接着还问还有什么……我就蒙蔽摇头，不知道
5. 问inheritance，举了个人和动物的例子，然后说这特性方便维护，答得不是特别好。然后问java composition：这玩意我是真没想起来，面试官笑笑说你肯定用过但你不知道
6. 问hashset的原理和复杂度，我就答了O（1），可是面试官没啥表情，我不知道是我答错了还是怎么地，就解释了hashset的原理
7. 开始做题，题是一道meeting room改版，啥输入输出都没给，自己问。然后我问他返回什么他说返回所有collision，我就用array sort先sort再用i，j两个指针判断是否重合，i表示遍历过的end最远的时间段。最后算复杂度的时候他问我sort worst复杂度是什么，一开始答错说了个ON2他问我确定吗，我改口nlogn他说OK，然后说我其中使用了contains好不好，我说不好，我应该在循环外部判断是否需要加入第一项。他制止我然后问能不能直接改良，我说可以考虑hashset但是hashset会导致数据丢失，他问我为什么会丢失，我就说假如两个interval完全一样那hashset只会保存一个，output里就只有一个了，他听明白了然后点头说great
8. 问我有没有什么问题，我说你们怎么解决communication的问题的（之前我说过team有交流问题），他说了一大串什么他们的组很小，他们也有问题但在不断改进当中之类的内容
9. 结束，总共一个多小时