import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx=1;
        int sum=0;

        for(int i=1; i<=n; i++){
            while(sum<n){
                sum+=idx++;
            }

            if(sum==n) {
                answer++;
                idx=i+1;
                sum=0;
            }
            else if(sum>n){
                sum-=i;
            }
        }

        return answer;
    }
}