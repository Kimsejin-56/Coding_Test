import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int lt=1;
        int rt=100000;
        
        while(lt<=rt){
            int mid=(lt+rt)/2;
            long total=0;
            
            for(int i=0; i<diffs.length; i++){
                int d=diffs[i];
                if(d<=mid){
                    total+=times[i];
                } else{
                    int n=d-mid;
                    total+=(times[i]+times[i-1])*n+times[i];
                }
            }
            
            if(total<=limit){
                if(answer>mid){
                    answer=mid;
                    rt=mid-1;
                }else{
                    lt=mid+1;
                }
            }else {
                lt=mid+1;
            }
        }
        
        return answer;
    }
}