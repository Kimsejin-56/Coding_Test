
import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public int solution(int n, int m){
		int range = 2*m+1;
        int idx=1;
        
        while(true){
            if(range*idx>=n) return idx;
            idx++;
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		Solution s=new Solution();
		for(int test_case = 1; test_case <= T; test_case++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println("#"+ test_case +" " + s.solution(n, m));
		}
	}
}