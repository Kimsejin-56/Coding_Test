import java.util.*;

class Solution {
    static int[][] board;
    static int answer;
    static boolean[] visited;
    public int solution(int n) {
        answer = 0;
        board=new int[n][n];
        visited=new boolean[n];
        
        dfs(0, n);
        return answer;
    }
    
    public void dfs(int depth, int n){
        if(depth==n){
            answer++;
            return;
        } else {
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                
                boolean pass=false;
                int cnt=1;
                for(int j=depth-1; j>=0; j--){
                    if(i+cnt<n && board[j][i+cnt]==1){
                        pass=true;
                        break;
                    }
                    
                    if(i-cnt>=0 && board[j][i-cnt]==1){
                        pass=true;
                        break;
                    }
                    cnt++;
                }
                
                if(pass) continue;
                
                board[depth][i]=1;
                visited[i]=true;
                dfs(depth+1, n);
                visited[i]=false;
                board[depth][i]=0;
            }
        }
    }
}