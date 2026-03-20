import java.util.*;
import java.io.FileInputStream;


class Solution
{
    public int solution(String str){
        int answer=0;
    	List<Integer> list=new ArrayList<>();
        
        for(int i=0; i<str.length(); i++){
            String tmp=String.valueOf(str.charAt(i));
        	int num=Integer.parseInt(tmp);
            list.add(num);
        }
        
		int[] arr=new int[list.size()];
        
        for(int i=0; i<arr.length; i++){
        	if(list.get(i) != arr[i]){
                for(int j=i; j<arr.length; j++){
                    arr[j]=list.get(i);
                }
                answer++;
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
        
		for(int test_case = 1; test_case <= T; test_case++){
			String str = sc.next();
			System.out.println("#"+test_case+" "+ s.solution(str));
		}
	}
}