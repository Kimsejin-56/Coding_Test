import java.util.*;

class Solution {
    public long solution(int n) {
        if(n==1) return 1;
        long[] jump=new long[n+1];
        jump[1]=1;
        jump[2]=2;
        
        for(int i=3; i<=n; i++){
            jump[i]=(jump[i-1]+jump[i-2])%1234567;
        }
        
        return jump[n];
    }
}