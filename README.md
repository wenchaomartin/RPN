# RPN 的思路分析和问题汇总


## RPN 是什么？ 

  
1.  RPN(数据结构中的逆波兰表达式) 对栈这种数据结构练习, 比 中缀表达式更好 没有operator优先级和小括号的进栈出栈    
2. 邓俊辉老师视频有对RPN的介绍：[看完基本思路就很明确了](https://www.bilibili.com/video/av41572620/?p=133)
    

### 解题思路

1. 数字直接进栈，遇到操作符 则之前的数字出栈在与操作符计算 压栈
    1. 解决undo 撤销 问题
    1. 遇到sqrt 需要运用 [BigDecimal](https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html)
### undo
    
  undo 思路来源于[Memento and command pattern](https://stackoverflow.com/questions/3448943/best-design-pattern-for-undo-feature)  
    
   ####Memento java  
  
    ```
    # 将 myObject 包装了一下
    public class Memento {
    
        MyObject myObject;
    
        public MyObject getState() {
            return myObject;
        }
    
        public void setState(MyObject myObject){
            this.myObject = myObject;
        }
    }
    
      # Command java
      public abstract class Command {
      
          MyObject myObject; //memnto 中 myobject的镜象
      
          Memento memento;
      
          public abstract void execute(); // 当 命令执行时 ， 将新的myObject 给 memento
      
          public abstract void undo();  //将旧的 myobject 给 memento
      }

    ```
    
  1. 每个命令执行要进栈 undo 栈就要 pop 执行 undo
         
     需要注意的是 memento 中的 myObject 与 command 中的 myObject 
     
     ``deep copy`` [offer three methods deep copy](https://www.baeldung.com/java-deep-copy)
     
 参考资料
  1. https://stackoverflow.com/questions/7374545/the-undo-and-redo-implementation-in-java
  1. https://www.codeproject.com/Articles/8303/Using-the-Command-pattern-for-undo-functionality
  
 ####java BigDecimal 遇到的问题
 
  [BigDecimal get started](http://www.opentaps.org/docs/index.php/How_to_Use_Java_BigDecimal:_A_Tutorial)
   1. [why we need BigDecimal](https://stackoverflow.com/questions/3413448/double-vs-bigdecimal)
   1. [BigDecimal Round](https://stackoverflow.com/questions/905795/java-bigdecimal-problems-with-division)
   1. [arithmeticException-non-terminating-decimal-expansion](https://stackoverflow.com/questions/4591206/arithmeticexception-non-terminating-decimal-expansion-no-exact-representable?noredirect=1)
   1. [bigdecimal_toengineeringstring](https://www.tutorialspoint.com/java/math/bigdecimal_toengineeringstring.htm)
   1. [How_to_remove_trailing_zero_from_BigDecimal](https://java2blog.com/java-bigdecimal/#How_to_remove_trailing_zero_from_BigDecimal)
   1. [java-bigDecimal-round](https://stackoverflow.com/questions/4134047/java-bigdecimal-round-to-the-nearest-whole-value)
   1. [sqrt in BigDecimal](https://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java)
  
 ####test
 
   1.[junit test throw an exception](https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown)
 
  