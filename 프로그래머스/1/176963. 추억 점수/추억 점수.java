import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            String n=name[i];
            int y=yearning[i];
            map.put(n, y);
        }
        
        for(int i=0; i<photo.length; i++){
            int sum=0;
            for(String str : photo[i]){
                if(map.get(str)==null) continue;
                sum+=map.get(str);
            }
            answer[i]=sum;
        }
        
        return answer;
    }
}