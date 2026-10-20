import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> kind=new HashMap<>();
        Map<String, Integer> map=new HashMap<>();
        int idx=0;
        int len=Integer.MAX_VALUE;
        
        for(int i=0; i<gems.length; i++){
            kind.putIfAbsent(gems[i], 0);
        }
        
        for(int i=0; i<gems.length; i++){
            String key=gems[i];
            map.put(key, map.getOrDefault(key, 0)+1);
            
            while(map.get(gems[idx])>1){
                map.put(gems[idx], map.get(gems[idx])-1);
                idx++;
            }
            
            if(map.size()==kind.size() && len>i-idx){
                len=i-idx;
                answer[0]=idx+1;
                answer[1]=i+1;
            }
        }
        
        return answer;
    }
}