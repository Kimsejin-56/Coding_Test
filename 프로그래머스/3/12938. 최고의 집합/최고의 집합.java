import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
       if(s<n) return new int[]{-1};
       int[] answer=new int[n];
        
        int base=s/n;
        int remain=s%n;
        
        for(int i=0; i<n; i++){
            answer[i]=base;
        }
        
        int cnt=n-1;
        for(int i=0; i<remain; i++){
            answer[cnt--]+=1;
        }
        
        return answer;
    }
}