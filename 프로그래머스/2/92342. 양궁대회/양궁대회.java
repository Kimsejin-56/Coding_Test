import java.util.*;

class Solution {
    static int[] answer;
    static int max;
    
    public int[] solution(int n, int[] info) {
        answer=new int[] {-1};
        max=0;
        
        dfs(0, 0, new int[11], n, info);
        
        return answer;
    }

    public void dfs(int depth, int start, int[] arr, int n, int[] info){
        if(depth==n){
            int cur=calc(arr, info);
            
            if(cur<=0) return;
            
            if(max<cur || (max==cur && isBetter(answer, arr))){
                max=cur;
                answer=arr.clone();
            }
        }else {
            for(int i=start; i<11; i++){
                arr[i]++;
                dfs(depth+1, i, arr, n, info);
                arr[i]--;
            }
        }
    }
    
    public int calc(int[] arr, int[] info){
        int my=0;
        int you=0;
        
        for(int i=0; i<11; i++){
            if(arr[i]==0 && info[i]==0) continue;
            
            if(arr[i]>info[i]) my+=10-i;
            else you+=10-i;
        }
        
        return my-you;
    }
    
    public boolean isBetter(int[] max, int[] cur){
        for(int i=10; i>=0; i--){
            if(max[i]!=cur[i]) return max[i]<cur[i];
        }
        
        return false;
    }
}