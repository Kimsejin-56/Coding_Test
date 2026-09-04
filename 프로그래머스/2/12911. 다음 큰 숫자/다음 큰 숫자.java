import java.util.*;

class Solution {
    public int solution(int n) {
        int answer=0;
        int cnt=binary(n);
        int num=n+1;
        
        while(true){
            if(cnt==binary(num)) return num;
            num++;
        }
    }
    
    public int binary(int n){
        int cnt=0;
        while(n>0){
            if(n%2==1) cnt++;
            n/=2;
        }
        
        return cnt;
    }
}