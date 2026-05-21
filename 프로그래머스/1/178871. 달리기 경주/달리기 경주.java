import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n=players.length;
        Map<String, Integer> map=new HashMap<>();
        String[] answer=Arrays.copyOf(players, n);
        
        for(int i=0; i<n; i++) map.put(players[i], i);
        
        for(String cur : callings){
            int num=map.get(cur);
            map.put(cur, num-1);
            map.put(answer[num-1], num);
            
            String tmp=answer[num-1];
            answer[num-1]=answer[num];
            answer[num]=tmp;
        }
        
        return answer;
    }
}