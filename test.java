package str;
import java.util.*;
public class test {
	public static void main(String[] args){
		@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String chr = sc. nextLine() ;
		
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
		getCount(str,chr);
	    int i=0;
	    int a=8;
	    for(int x = 7; x <= s.length(); x = x+a){
	    	i++;
	    	if(i%2!=0) {
	    		//System.out.println("simple"+x);
	    		s.insert(x,",");
	    		a=8;
	    	}
	    	if(i%2==0) {
	    		//System.out.println("double"+x);
	    		s.insert(x,".\n");
	    		a=9;
	    	}
	    	
	    	
	    }
	    System.out.println(s);
		}
	}
	public static void getCount(String txt,String c){
        int index = 0;
        int count = 0;
        while((index = txt.indexOf(c)) != -1){
            count++;
            txt = txt.substring(index + 1);
        }
        System.out.println(c +"共出现了"+count+"次");
	}
}
		
