import java.util.*;

class Task{
    String name;
    int start;
    int playtime;

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
        Stack<Task> stack=new Stack<>();

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
                int pt=nt.start-t.start;
                t.playtime-=pt;
                
                if(t.playtime<0){
                    addAnswer(t, answer);
                    if(!stack.isEmpty()){
                        int rest=t.playtime;
                        while(!stack.isEmpty()){
                            Task p=stack.pop();
                            p.playtime+=rest;
                            rest=p.playtime;
                            if(rest>0) {
                                stack.push(p);
                                break;
                            }else addAnswer(p, answer);
                        }
                    }
                    continue;
                }
            }
            
            if(t.playtime<=0){
                addAnswer(t, answer);
            }else stack.push(t);
        }
        
        while(!stack.isEmpty()){
            Task t=stack.pop();
            addAnswer(t, answer);
        }
        
        return answer;
    }
        
    public void addAnswer(Task t, String[] answer){
        answer[idx++]=t.name;
    }
}