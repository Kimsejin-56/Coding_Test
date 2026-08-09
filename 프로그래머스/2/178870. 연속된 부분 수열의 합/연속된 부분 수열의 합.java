import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int idx=0;
        int sum=0;
        int len=Integer.MAX_VALUE;
        
        for(int i=0; i<sequence.length; i++){
            sum+=sequence[i];
            
            while(sum>k){
                sum-=sequence[idx++];                    
            }
            
            if(sum==k){
                if(len>i-idx){
                    len=i-idx;
                    answer[0]=idx;
                    answer[1]=i;
                }
            }
        }
        
        return answer;
    }
}