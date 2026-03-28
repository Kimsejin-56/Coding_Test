import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static String[] answer=new String[2501];
 
    
    static String solution(int n){
		answer[1]="0";
        answer[2]="8";
        answer[3]="48";
        for(int i=4; i<=n; i++){
            String str="";
            	
            int tmp=i-2;
            str+=answer[tmp];
            str+=answer[2];
           
            //System.out.println("str"+i+"="+str);
            answer[i]=str;
        }
        
       return answer[n];
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            System.out.println(solution(n));
		}
	}
}