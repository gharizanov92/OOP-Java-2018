# How to create a JUnit test\
#### Create a normal Java project in IntelliJ
![Initial](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test1.PNG)
#### Create a test sources directory
![Create directory](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test2.png)
#### Mark directory as test sources
![Mark as test sources](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test3.png)
#### Create a new test by using ```ALT+ENTER``` and then chose "Create Test"
![Creating a test](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test4.png)
#### Select JUnit4
![JUnit4](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test5.png)
#### Click on fix to include JUnit to your classpath
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test6.png)
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test7.png)
#### You should see the following result
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test8.png)
#### To test if a statement is true, use ```assertThat(...)```
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test9.png)
#### Last argument should be from the [hamcrest](http://www.vogella.com/tutorials/Hamcrest/article.html) library, select ```Import Static ... ```
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test10.png)
#### Last argument should be from the hamcrest library, select ```Import Static``` and after that select the dependency that starts with ```CoreMatchers```
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test10.png)
![FIX](https://github.com/gharizanov92/OOP-Java-2018/blob/JUnit/JUnit/images/test11.png)

There are different Matchers (is, equalTo, hasItems, etc..), for now we will be only using _is_.
