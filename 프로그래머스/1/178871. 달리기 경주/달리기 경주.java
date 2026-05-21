import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n=players.length;
        Map<String, Integer> psm=new HashMap<>();
        Map<Integer, String> pim=new HashMap<>();
        for(int i=0; i<n; i++){
            psm.put(players[i], i);
            pim.put(i, players[i]);
        } 
        
        for(String cur : callings){
            int num=psm.get(cur);
            String before=pim.get(num-1);
            
            psm.put(cur, num-1);
            psm.put(before, num);
            pim.put(num, before);
            pim.put(num-1, cur);
        }
        
        String[] answer= new String[n];
        for(int i=0; i<n; i++){
            answer[i]=pim.get(i);
        }
        
        return answer;
    }
}