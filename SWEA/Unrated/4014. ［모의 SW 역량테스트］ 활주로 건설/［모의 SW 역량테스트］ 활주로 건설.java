import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int h, n, x;
    static int[][] arr;
    public static int solution(){
		 int answer=0;
        answer+=cal1();
        answer+=cal2();
    	
		return answer;
	}
    
    //세로 계산
    static int cal2(){
        int cnt=0;
        boolean [][] visited =new boolean[n][n];
		boolean pass=false;
        for(int i=0; i<n; i++){
            pass=false;
            for(int j=0; j<n-1; j++){
				if(arr[j][i] - arr[j+1][i] == 1){
					if(j+x<n){
                        int tmp=arr[j+1][i];
				    	for(int k =j+1; k<=j+x; k++){
							if(arr[k][i] ==tmp) visited[k][i]=true;
                            else pass=true;
						}
					}else  pass=true;
				}else if(arr[j][i] - arr[j+1][i] == 0){
					
				}else if(arr[j][i] - arr[j+1][i] == -1){
					if(j-x+1>=0){
                        int tmp=arr[j][i];
                     	for(int k=j; k>=j-x+1; k--){
                         	if(!visited[k][i] && tmp==arr[k][i]){
                                visited[k][i]=true;
                            }else  pass=true;
                        }
                    } else  pass=true;
				}else{
                 	pass=true;   
                }
                
                if(pass) break;
                
            	if(j == n-2) {
                    //System.out.println("arr[j][i]="+arr[j][i]+" i="+i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    //가로 계산
    static int cal1(){
        int cnt=0;
        boolean [][] visited =new boolean[n][n];
		boolean pass=false;
        for(int i=0; i<n; i++){
            pass=false;
            for(int j=0; j<n-1; j++){
				if(arr[i][j] - arr[i][j+1] == 1){
					if(j+x<n){
                        int tmp=arr[i][j+1];
				    	for(int k =j+1; k<=j+x; k++){
							if(arr[i][k] ==tmp) visited[i][k]=true;
                            else pass=true;
						}
					}else  pass=true;
				}else if(arr[i][j] - arr[i][j+1] == 0){
					
				}else if(arr[i][j] - arr[i][j+1] == -1){
					if(j-x+1>=0){
                        int tmp=arr[i][j];
                     	for(int k=j; k>=j-x+1; k--){
                         	if(!visited[i][k] && tmp==arr[i][k]){
                                visited[i][k]=true;
                            }else  pass=true;
                        }
                    } else  pass=true;
				} else{
                	pass=true;
                }
                
                if(pass) break;
                
            	if(j == n-2) {
                    //System.out.println("arr[i][j]="+arr[i][j]+" i="+i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
        
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n=sc.nextInt();
            x=sc.nextInt();
            arr=new int[n][n];
            h=0;
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j]=sc.nextInt();
                    h=Math.max(arr[i][j], h);
                }
            }
            
            System.out.println("#"+test_case+" "+solution());
		}
	}
}