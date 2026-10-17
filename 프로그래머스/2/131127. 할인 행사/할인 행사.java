import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> cur=new ArrayList<>();
        
        for(int i=0; i<10; i++){
            cur.add(discount[i]);
        }
        
        if(isAvailable(cur, want, number)) answer++;
        
        for(int i=10; i<discount.length; i++){
            cur.remove(0);
            cur.add(discount[i]);
            
            if(isAvailable(cur, want, number)) answer++;
        }
        
        return answer;
    }
    
    public boolean isAvailable(List<String> cur, String[] want, int[] number){
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0; i<10; i++){
            String key=cur.get(i);
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        for(int i=0; i<want.length; i++){
            int cnt=map.getOrDefault(want[i], 0);
            if(number[i]>cnt) return false;
        }
        
        return true;
    }
}