import java.util.*;

class Solution {
    static int[] discount={10, 20, 30, 40};
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, emoticons, users, new int[emoticons.length]);
        
        return answer;
    }
    
    public void dfs(int depth, int[] emoticons, int[][] users, int[] arr){
        if(depth==emoticons.length){
            int plus=0;
            int total=0;
            
            for(int i=0; i<users.length; i++){
                int percent=users[i][0];
                int price=users[i][1];
                int buy=0;
                
                for(int j=0; j<arr.length; j++){
                    if(percent<=arr[j]){
                        buy+=emoticons[j]-((emoticons[j]*arr[j])/100);
                    }
                }
                
                if(price<=buy) plus++;
                else total+=buy;
            }
            
            if(isBetter(plus, total)){
                answer[0]=plus;
                answer[1]=total;
            }
        }else{
            for(int i=0; i<discount.length; i++){
                arr[depth]=discount[i];
                dfs(depth+1, emoticons, users, arr);
            }
        }
    }
    
    public boolean isBetter(int plus, int total){
        if(answer[0]!=plus) return answer[0]<plus;
        return answer[1]<total;
    }
}