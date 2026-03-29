import java.util.*;
import java.io.FileInputStream;


class Solution
{
    public static int solution(int[] arr){
     	int answer=0;

        for(int i=2; i<arr.length-2; i++){
            
            boolean flag =false;
            
            //왼쪽 2칸
         	for(int j=i-1; j>=i-2; j--){
             	if(arr[j] >= arr[i]) {
                    flag=true;
                    break;
                }
            }
            if(flag) continue;
            
            //오른쪽 2칸
            for(int j=i+1; j<=i+2; j++){
                if(arr[i] <= arr[j]) {
                    flag=true;
                    break;
                }
            }
            if(flag) continue;
            
            //만족하는 경우
            answer++;
            //아래층도 가능한지 확인
            for(int j=arr[i] -1; j>=0; j--){
                for(int k=i-1; k>=i-2; k--){
                    if(arr[k] >= j) {
                    	flag=true;
                    	break;
                	}
            	}
                if(flag) break;
                
                for(int k=i+1; k<=i+2; k++){
                	if(j <= arr[k]) {
                    	flag=true;
                    	break;
                    }
                }
                if(flag) break;
                answer++;
            }
            //System.out.println("arr="+arr[i]+" answer="+answer);
        }
        
        return answer;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int[] arr=new int[n];
            
            for(int i=0; i<n; i++){
            	arr[i]=sc.nextInt(); 	   
            }
			
            System.out.println("#"+test_case+" "+solution(arr));
		}
	}
}