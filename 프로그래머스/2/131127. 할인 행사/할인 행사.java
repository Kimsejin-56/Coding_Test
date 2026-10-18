import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0; i<10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(isAvailable(map, want, number)) answer++;
        
        for(int i=10; i<discount.length; i++){
            String out = discount[i-10];
            map.put(out, map.get(out)-1);

            String in = discount[i];
            map.put(in, map.getOrDefault(in, 0)+1);
            
            if(isAvailable(map, want, number)) answer++;
        }
        
        return answer;
    }
    
    public boolean isAvailable(Map<String, Integer> map, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            int cnt = map.getOrDefault(want[i], 0);

            if (number[i] > cnt) return false;
        }

        return true;
    }
}