import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> s1=makeMap(str1);
        Map<String, Integer> s2=makeMap(str2);
    
        if(s1.size()==0 && s2.size()==0) return 65536;
        
        Set<String> keys=new HashSet<>();
        keys.addAll(s1.keySet());
        keys.addAll(s2.keySet());
        
        int union=0, inter=0;
        for(String key : keys){
            int cnt1 = s1.getOrDefault(key, 0);
            int cnt2 = s2.getOrDefault(key, 0);
            
            union+=Math.max(cnt1, cnt2);
            inter+=Math.min(cnt1, cnt2);
        }
        
        double div=(double) inter/union;
        return (int)(div*65536);
    }
    
    public Map<String, Integer> makeMap(String str){
        str=str.toLowerCase();
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0; i<str.length()-1; i++){
            String s="";
            for(int j=i; j<=i+1; j++){
                if(Character.isLetter(str.charAt(j))){
                    s+=str.charAt(j);
                } else break;   
            }
            if(s.length()==2) map.put(s, map.getOrDefault(s, 0)+1);
        }
        return map;
    }
}