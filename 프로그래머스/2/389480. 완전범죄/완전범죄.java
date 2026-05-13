import java.util.*;

class Solution {
    static int answer;
    static int n, m;
    static int[][] info;
    static int[][][] memo;
  
    public int solution(int[][] inputInfo, int inputN, int inputM) {
        answer = Integer.MAX_VALUE;
        n=inputN;
        m=inputM;
        info=inputInfo;
        memo=new int[info.length][n][m];
        
        for(int i=0; i<info.length; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        dfs(0, 0, 0);
        if(answer>=n) return -1;
        return answer;
        
    }
    
    public int dfs(int idx, int aSum, int bSum){
        if(idx==info.length) {
            answer=Math.min(answer, aSum);
            return aSum;
        }
        if(memo[idx][aSum][bSum]!= -1) return memo[idx][aSum][bSum];
        
        int a=info[idx][0];
        int b=info[idx][1];
        
        int result=Integer.MAX_VALUE;
        if(aSum+a<n){
            int takeA=dfs(idx+1, aSum+a, bSum);
            result=Math.min(result, takeA);
        }
        
        
        if(bSum+b<m){
            int takeB=dfs(idx+1, aSum, bSum+b);
            result=Math.min(result, takeB);
        }
        
        return memo[idx][aSum][bSum]=result;
    }
}