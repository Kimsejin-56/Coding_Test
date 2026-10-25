import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n=scoville.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            if(pq.peek()>=K) break;
            if(pq.size()<2) return -1;
            
            int n1=pq.poll();
            int n2=pq.poll();
            
            int num=n1+(n2*2);
            
            pq.offer(num);
            
            answer++;
        }
        
        return answer;
    }
}