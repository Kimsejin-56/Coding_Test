import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1=new ArrayDeque<>();
        Queue<Integer> q2=new ArrayDeque<>();
        long sum1=0;
        long sum2=0;
        long goal=0;


        for(int i : queue1){
            q1.add(i);
            sum1+=i;
        }

        for(int i : queue2){
            q2.add(i);
            sum2+=i;
        }

        if((sum1+sum2)%2==1) return -1;
        goal=(sum1+sum2)/2;

        for(int i=0; i<300000; i++){
            if(q1.isEmpty() || q2.isEmpty()) return -1;

            if(sum1>goal){
               int n=q1.poll();
               q2.add(n);
               sum1-=n;
               sum2+=n;
            }else if(sum1<goal){
                int n=q2.poll();
                q1.add(n);
                sum1+=n;
                sum2-=n;
            }else{
                return answer;
            }

            answer++;
        }
        
        return -1;
    }
}