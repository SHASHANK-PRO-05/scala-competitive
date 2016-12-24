###Fast Input Output

One of the things that everyone should care in Competitive Programming is Fast IO. In Java/Scala don't use Scanner class. It is a huge overhead on IO.
Rather go for buffered readers. They are fast and efficient.

***

###Whey BufferedReader is fast?
Simple it reads data in character stream. If you don't use it then your input stream(whatever may it be) will be read first and then converted into character stream which is highly inefficient for your program.
Rather wrap around BufferedReader will start providing inputs to your program as soon as it gets inputs. Just give this [document](https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html) a read.

Note:I saw this on CodeForces. [Here](http://codeforces.com/blog/entry/21074), you can also learn from masters.


