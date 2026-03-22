import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public int solution(int[] arr, int[] p, int[] c, int[] visited){
        int answer=0;
        List<Integer> list= new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
         	   if(arr[i] > 0){
                   for(int j=0; j<p.length; j++){
                    	if(visited[j] == 0) {
                         	visited[j] = arr[i];
                            break;
                        }
                       if(j==p.length-1) list.add(arr[i]);
                   }
               } else if(arr[i] < 0){
                	    for(int j=0; j<p.length; j++){
                         	if(visited[j] == Math.abs(arr[i])){
                             	answer+=p[j]*c[visited[j] -1];
                                visited[j]=0;
                                
                                if(!list.isEmpty()) {
                                    visited[j]=list.get(0);
                                    list.remove(0);
                                }
                                break;
                            }
                        }
              	}
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
			int n=sc.nextInt();
            int m=sc.nextInt();
            
            int[] p =new int[n];
            int[] visited =new int[n];
            int[] c=new int[m];
            int[] arr=new int[2*m];
            for(int i=0; i<n; i++){
             	   p[i]=sc.nextInt();
            }
			
             for(int i=0; i<m; i++){
             	   c[i]=sc.nextInt();
            }
            
            for(int i=0; i<2*m; i++){
             	arr[i]=sc.nextInt();   
            }
            
            System.out.println("#"+test_case+" "+s.solution(arr, p, c, visited));
		}
	}
}