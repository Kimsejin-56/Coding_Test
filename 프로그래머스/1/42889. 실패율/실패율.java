import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> percent=new HashMap<>();
        TreeMap<Integer, Integer> count=new TreeMap<>();
        double total=stages.length;
        
        for(int i=0; i<stages.length; i++){
            count.put(stages[i], count.getOrDefault(stages[i], 0)+1);
        }
        
        for(int i=1; i<=N; i++){
            if(count.get(i)==null){
                percent.put(i, 0.0);
                continue;
            }
            percent.put(i, count.get(i)/total);
            total-=count.get(i);
        }
        
        List<Map.Entry<Integer, Double>> list=new ArrayList<>(percent.entrySet());
        list.sort((o1, o2)-> {
            if(o1.getValue() == o2.getValue()) return o1.getKey()-o2.getKey();
             return Double.compare(o2.getValue(), o1.getValue());
            });
        
        int idx=0;
        for(Map.Entry<Integer, Double> e : list){
            answer[idx++]=e.getKey();
        }
        
        return answer;
    }
}