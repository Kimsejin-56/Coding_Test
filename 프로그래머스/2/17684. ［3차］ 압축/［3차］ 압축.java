import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        int idx=1, last=27;
        
        for(char c='A'; c<='Z'; c++){
            map.put(String.valueOf(c), idx++);
        }
        
        int i=0;
        while(i<msg.length()){
            String tmp="";
            
            while(i<msg.length() && map.containsKey(tmp+msg.charAt(i))){
                tmp+=msg.charAt(i);
                i++;
            }
            answer.add(map.get(tmp));
            
            if(i<msg.length()) map.put(tmp+msg.charAt(i), last++);
        }
        
        return answer;
    }
}