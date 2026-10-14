import java.util.*;

class Task{
    String name;
    int start;
    int playtime;
    boolean pass;

    public Task(String name, int start, int playtime){
        this.name=name;
        this.start=start;
        this.playtime=playtime;
    }
}

class Solution {
    static int idx=0;
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Task> list = new ArrayList<>();
        List<Task> prev = new ArrayList<>();

        for(int i=0; i<plans.length; i++){
            String[] plan=plans[i];
            String name=plan[0];
            String[] time=plan[1].split(":");
            int start=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            int playtime=Integer.parseInt(plan[2]);
            Task task=new Task(name, start, playtime);
            list.add(task);
        }

        list.sort((a,b)-> a.start-b.start);

        for(int i=0; i<list.size(); i++){
            Task t=list.get(i);
            
            if(i==list.size()-1){
                t.playtime=0;
            }else{
                Task nt=list.get(i+1);
                int play=nt.start-t.start;
                t.playtime-=play;

                if(t.playtime<0){
                    addAnswer(t, answer);
                    if(!prev.isEmpty()){
                        int rest=t.playtime;
                        for(int l=prev.size()-1; l>=0; l--){
                            if(prev.isEmpty()) break;
                            Task p=prev.get(l);
                            p.playtime+=rest;
                            rest=p.playtime;
                            if(p.playtime<=0) {
                                addAnswer(p, answer);
                                prev.remove(p);
                            }
                            if(rest>=0) break;
                        }
                        
                    }
                    t.playtime=0;
                    continue;
                }
            }
            
            if(t.playtime==0) {
                addAnswer(t, answer);
            }else prev.add(t);
        }
        
        for(int i=prev.size()-1; i>=0; i--){
            Task t=prev.get(i);
            addAnswer(t, answer);
            t.playtime=0;
        }

        return answer;
    }
        
    public void addAnswer(Task t, String[] answer){
        answer[idx++]=t.name;
    }
}