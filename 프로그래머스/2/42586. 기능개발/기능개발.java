import java.util.*;

class Point{
    int n,idx;
    public Point(int n, int idx){
        this.n=n;
        this.idx=idx;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Point> q=new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            q.offer(new Point(progresses[i], i));
            
        }
        
        while(!q.isEmpty()){
            int cnt=0;
            boolean pass=false;
            Point p=q.poll();
            if(p.n>=100){
                cnt++;
                for(Point ps : q){
                    if(p.idx>ps.idx){
                        pass=true;
                        break;
                    } 
                }
                
                if(pass) {
                    q.offer(p);    
                    continue;
                }
                
                while(!q.isEmpty() && q.peek().n>=100){
                    q.poll();
                    cnt++;
                }
                list.add(cnt);
            }else {
                p.n+=speeds[p.idx];
                q.offer(p);
            }
        }
        
        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        return answer;
    }
}