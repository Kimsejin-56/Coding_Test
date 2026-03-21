import java.util.*;
import java.io.FileInputStream;

class Solution{
    
    public Long solution(int n, int[] arr){
        Long answer=0L;
        int max=arr[n-1];
        
        for(int i=n-2; i>=0; i--){
         	   if(arr[i] < max){
                	answer+=max - arr[i];   
               }else if(max < arr[i]) max=arr[i];
        }
        
        return answer;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        Solution s=new Solution();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[] arr = new int[n];
            
            for(int j=0; j<n; j++){
                int num=sc.nextInt();
             	arr[j]=num;
            }
            System.out.println("#"+test_case+" "+ s.solution(n, arr));
		}
	}
}