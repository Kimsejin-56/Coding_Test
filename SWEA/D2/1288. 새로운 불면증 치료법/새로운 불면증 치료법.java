import java.util.*;
import java.io.FileInputStream;


class Solution
{
    
    public int solution(int n){
     	Set<Integer> set = new HashSet<>();   
        int idx=1;
        
        while(true){
        	int tmp = n * idx;
            String str=String.valueOf(tmp);
            
            for(int i=0; i<str.length(); i++){
                String s=String.valueOf(str.charAt(i));
                set.add(Integer.parseInt(s));
            }	
            
            if(set.size() == 10) return tmp;
            idx++;
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        Solution s=new Solution();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            System.out.println("#"+test_case+" "+s.solution(n));
		}
	}
}