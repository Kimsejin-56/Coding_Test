import java.util.*;

class Task{
    String name;
    int start, time, work;
    
    public Task(String name, int start, int time){
        this.name=name;
        this.start=start;
        this.time=time;
        this.work=0;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        int n=plans.length;
        String[] answer = new String[n];
        List<Task> order=new ArrayList<>();
        Deque<Task> s=new ArrayDeque<>();
        int idx=0;
        
        for(int i=0; i<n; i++){
            String name=plans[i][0];
            int start=getNum(plans[i][1]);
            int m=Integer.parseInt(plans[i][2]);
            
            Task t=new Task(name, start, m);
            order.add(t);
        }
        
        order.sort((a, b) -> a.start-b.start);
                
        for(int i=1; i<n; i++){
            Task cur=order.get(i-1);
            Task next=order.get(i);
            int diff=next.start-cur.start;
            
            if(diff>=cur.time){
                int rest=diff-cur.time;
                answer[idx++]=cur.name;
                
                while(rest>0 && !s.isEmpty()){
                    Task prev=s.pop();
                    if(prev.work>rest){
                        prev.work-=rest;
                        rest=0;
                        s.push(prev);
                    }else{
                        rest-=prev.work;
                        answer[idx++]=prev.name;
                    }
                }
                
            }else{
                cur.work=cur.time-diff;
                s.push(cur);
            }
        }
        
        answer[idx++]=order.get(n-1).name;
        
        while(!s.isEmpty()){
            answer[idx++]=s.pop().name;
        }
        
        return answer;
    }
    
    public int getNum(String str){
        String[] arr=str.split(":");
        int h=Integer.parseInt(arr[0]);
        int m=Integer.parseInt(arr[1]);
        
        return h*60+m;
    }
}