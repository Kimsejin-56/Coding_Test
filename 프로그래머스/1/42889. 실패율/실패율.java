import java.util.*;

class Stage implements Comparable<Stage>{
    int k;
    double v;
    
    public Stage(int k, double v){
        this.k=k;
        this.v=v;
    }
    
    public int compareTo(Stage s){
        if(this.v==s.v) return this.k - s.k;
        return Double.compare(s.v, this.v);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> list=new ArrayList<>();
        TreeMap<Integer, Integer> count=new TreeMap<>();
        double total=stages.length;
        
        for(int i=0; i<stages.length; i++){
            count.put(stages[i], count.getOrDefault(stages[i], 0)+1);
        }
        
        for(int i=1; i<=N; i++){
            if(count.get(i)==null){
                list.add(new Stage(i, 0.0));
                continue;
            }
            list.add(new Stage(i, count.get(i)/total));
            total-=count.get(i);
        }
        Collections.sort(list);
            
        int idx=0;
        for(Stage s : list){
            answer[idx++]=s.k;
        }
        
        return answer;
    }
}