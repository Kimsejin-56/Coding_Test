import java.util.*;

//5:28
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1=makeQueue(queue1);
        Queue<Integer> q2=makeQueue(queue2);
        long sum1=getSum(queue1);
        long sum2=getSum(queue2);
        long mid=(sum1+sum2)/2;
        int cnt=0;
        int val=0;
        
        while(cnt<3*queue1.length){
            if(sum1==0 || sum2==0) break;
            
            if(sum1==mid) {
                answer=cnt;
                break;
            }else if(sum1>mid){
                val=q1.poll();
                q2.offer(val);
                sum1-=val;
                sum2+=val;
                cnt++;
            }else{
                val=q2.poll();
                q1.offer(val);
                sum1+=val;
                sum2-=val;
                cnt++;
            }
        }
        
        return answer;
    }
    
    public Queue<Integer> makeQueue(int[] queue){
        Queue<Integer> q=new ArrayDeque<>();
        
        for(int i : queue){
            q.offer(i);
        }
        
        return q;
    }
    
    public long getSum(int[] queue){
        long sum=0;
        
        for(int i : queue){
            sum+=i;
        }
        
        return sum;
    }
}