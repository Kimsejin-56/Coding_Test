import java.util.*;

class Solution {
    static int answer;
    static boolean[] col, dia1, dia2;
    public int solution(int n) {
        answer = 0;
        col=new boolean[n];
        dia1=new boolean[2*n-1];
        dia2=new boolean[2*n-1];
        
        dfs(0, n);
        return answer;
    }
    
    public void dfs(int depth, int n){
        if(depth==n){
            answer++;
            return;
        } else {
            for(int i=0; i<n; i++){
                int d1=depth+i;
                int d2=depth-i+n-1;
                
                if(col[i]) continue;
                if(dia1[d1]) continue;
                if(dia2[d2]) continue;
  
                
                
                col[i]=true;
                dia1[d1]=true;
                dia2[d2]=true;
                
                dfs(depth+1, n);
                
                col[i]=false;
                dia1[d1]=false;
                dia2[d2]=false;
            }
        }
    }
}