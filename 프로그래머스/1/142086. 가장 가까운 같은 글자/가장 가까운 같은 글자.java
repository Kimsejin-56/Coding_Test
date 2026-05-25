import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map=new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            Character ch=s.charAt(i);
            if(map.get(ch)==null) answer[i]=-1;
            else {
                int diff=i-map.get(ch);
                answer[i]=diff;
            }
            map.put(ch, i);
        }
        
        
        return answer;
    }
}