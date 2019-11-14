# String
Java实验String

二、实验过程：

2.1实验思路：

1.如何输入
  利用main方法做输入 
public static void main(String[] args){
}
1）	在DOS窗口运行并输入：
按住shift在桌面单击鼠标右键，在此处运行命令提示符。输入命令javac Test//此处是文件名.java编译成功后，在运行java Test

2）	在eclipse中输入命令行参数：
  运行java程序的时候，run as中有个open Run Dialog 然后去那里找一个（x）=Arguments 然后在第一个文本框里依次输入命令行参数即可！
 

		 

2.如何获取输入值
  因为输入是最为array形式输入，故需要遍历Array，通过一个变量接收，边喝获取参数：
   for (int j = 0; j < args.length; j++) {  
					str = args[j]; 。 

3.如何异常处理
  因当输入值为null时：在做如下操作时。系统会报出
  
4.String转化StringBuilder：
  因为输入接收后的为String，但是String是不可变的，故而会占用不必要的内存，所以要转换为StringBuilder。
  String str = "" ;
		StringBuilder s=null;
		for (int j = 0; j < args.length; j++) {  
					str = args[j]; 
		try {
			s  = new StringBuilder(str);
			System.out.println("loading..."); 
		}
		catch(Exception e) {
			System.out.println("您调用main方法时没有指定任何参数！"); 
		}

2.2.关键逻辑与技术：

 1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
 1.1：因为每次添加标点和空白符的时候都会改变原有的文本长度，故而在文本长度上做一些规律的判断，总觉得会事倍功半，因此引入新的变量作为计数方法 int i。
1.2： 在每两句诗后要换行，故而会出现，有的句子长度是8，而还有的是9.（这里有对实验的不足，在之后有详细写）。所以在做for(int x = 7; x <= s.length(); x = x+a)这一句中x = x+a的值是要变化的因此在每次判断加“，”和“.”后还要判断a的取值。
int i=0;
for(int x = 7; x <= s.length(); x = x+a){
	    	i++;
	    	if(i%2!=0) {
	    		System.out.println("simple"+x);
	    		s.insert(x,",");
	    		a=8;
	    	}
	    	if(i%2==0) {
	    		System.out.println("double"+x);
	    		s.insert(x,".\n");
	    		a=9;
	    	}
        
2.允许提供输入参数，统计古诗中某个字或词出现的次数
      通过String类的.indexOf()和.substring()方法实现，在通过.indexOf()方法找到位置后计数，在通过.substring()方法截取之后还没统计的文本信息，利用重载最终实现：
public static void getCount(String txt,String c){
        int index = 0;
        int count = 0;
        while((index = txt.indexOf(c)) != -1){
            count++;
            txt = txt.substring(index + 1);
        }
        System.out.println(c +"共出现了"+count+"次");
	}
并通过Scanner方法输入：
Scanner sc = new Scanner(System.in);
		  String chr = sc. nextLine() ;
通过该语句调用getCount(str,chr);


四、实验感想


  在本次实验中了解了Java中String类和String Builder类的各种方法即其中不同，其实还有String Buffer。是不过在本次实验中对线程并无要求。故而选择了String Builder类，但在查阅资料的同时，也充分了解了String Buffer。当对字符串进行修改的时候，需要使用 String Buffer 和 String Builder 类。
和 String 类不同的是，String Buffer 和 String Builder 类的对象能够被多次的修改，并且不产生新的未使用对象。
String Builder 类在 Java 5 中被提出，它和 String Buffer 之间的最大不同在于 String Builder 的方法不是线程安全的（不能同步访问）。
由于 String Builder 相较于 String Buffer 有速度优势，所以多数情况下建议使用 String Builder 类。然而在应用程序要求线程安全的情况下，则必须使用 String Buffer 类。
但是本次实验中，还接触了匿名函数Lambda，因为在for(int x = 7; x <= s.length(); x = x+a)句中a会随着特定条件变化，此时想到了Lambda函数：（int i）->{if(i%2==0)return 8;if(i%2!=0)return 9}这样就大大简化了代码，但是代码编译不过关，后发现虽然在Java8中迎来了Lambda，但是在函数式编程时，不好使用lambda。故而还是选这里报告中的方法。

 
