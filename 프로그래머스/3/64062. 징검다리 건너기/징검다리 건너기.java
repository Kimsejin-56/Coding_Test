import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int max=0;
        Set<Integer> set=new HashSet<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a, b) -> stones[b]-stones[a]
        );
        
        for(int i=0; i<k; i++){
            pq.offer(i);
        }
        
        set.add(stones[pq.peek()]);
        
        for(int i=k; i<stones.length; i++){
            pq.offer(i);
            
            while(pq.peek()<=i-k){
                pq.poll();
            }
            
            set.add(stones[pq.peek()]);
        }
            
        for(int i : set){
            answer=Math.min(answer, i);
        }
        
        return answer;
    }
}