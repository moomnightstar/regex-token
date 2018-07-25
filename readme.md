# 债券经纪商的报价指令是怎么阅读

信用债报价主要有这几个要素：
剩余期限：                4.92Y
券号：                      101562004
名称：                      15镇江文旅MTN001
买方价格/卖方价格： bid/ofr
买方量/卖方量：        --/3000
评级：                      AA

# readtxtline

按行读取txt文件，对每一行按空格、制表符切割字符。
temp=reader.readLine()
String [] arr=temp.split("\\s+");
for(String ss:arr){
    System.out.print(ss+" ");
}
对于带有表头的txt文件，可以先读取第一行，按空格（制表符）或者其它分隔符分割，分析表头的正确性，使用map表头元素顺序。
对于后面的每一行使用map存储。

# 正则表达式

在其他语言中，\\ 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。

在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。

java中，mathcer.group是针对（）子表达式来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。

# junit
quote.java 使用简单的junit测试，测试正则表达式的正确性。

# lucene smartchinese analyzer
lucene自带的中文分词工具在中英文语境下，会将中文，英文，数字分开来切分成最小的索引单位。
