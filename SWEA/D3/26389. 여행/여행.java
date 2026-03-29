
import java.util.*;
import java.io.FileInputStream;


class Solution
{
    public static String solution(String[] arr){
     	String answer="Yes";
        //System.out.println("s="+Arrays.toString(arr));
      
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("N")){
                for(int j=i-1; j>=0; j--){
                 	if(arr[j].equals("S")) {
                        arr[j]="X";
                        arr[i]="X";
                    }
                }
            }else if(arr[i].equals("S")){
				for(int j=i-1; j>=0; j--){
                 	if(arr[j].equals("N")) {
                        arr[j]="X";
                        arr[i]="X";
                    }
                }
            }else if(arr[i].equals("W")){
               for(int j=i-1; j>=0; j--){
                 	if(arr[j].equals("E")) {
                        arr[j]="X";
                        arr[i]="X";
                   	}
                } 
            }else if(arr[i].equals("E")){
               for(int j=i-1; j>=0; j--){
               		if(arr[j].equals("W")) {
                        arr[j]="X";
                        arr[i]="X";
                    }
               }
            }
        }
             
         //System.out.println("e="+Arrays.toString(arr));
        for(int i=0; i<arr.length; i++){
        	if(!arr[i].equals("X") && !arr[i].equals("O")) return"No";
        }
        return answer;
    }
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
            
            String[] arr={"O","O","O","O"};
            boolean flag=false;
            int idx=0;
            for(int i=0; i<str.length(); i++){
                for(int j=0; j<4; j++){
					if(arr[j].equals(String.valueOf(str.charAt(i)))) {
                        flag=true;
                        break;
                    }
                }
                
             	if(!flag) arr[idx++]=String.valueOf(str.charAt(i));
                flag=false;
            }
			
            System.out.println(solution(arr));
		}
	}
}