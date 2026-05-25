import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> s1=new HashMap<>();
        Map<String, Integer> s2=new HashMap<>();
        List<String> union=new ArrayList<>();
        List<String> inter=new ArrayList<>();
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            String str="";
            for(int j=i; j<=i+1; j++){
                if(Character.isLetter(str1.charAt(j))){
                    str+=str1.charAt(j);
                } else break;   
            }
            if(str.length()==2) s1.put(str, s1.getOrDefault(str, 0)+1);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String str="";
            for(int j=i; j<=i+1; j++){
                if(Character.isLetter(str2.charAt(j))){
                    str+=str2.charAt(j);
                } else break;   
            }
            if(str.length()==2) s2.put(str, s2.getOrDefault(str, 0)+1);
        }
        
        if(s1.size()==0 && s2.size()==0) return 65536;
        
        Set<String> multi=new HashSet<>();
        for(String str : s1.keySet()){
            if(s1.get(str)>=2) multi.add(str);
            union.add(str);
        }
        
        for(String str : s2.keySet()){
            if(s2.get(str)>=2) multi.add(str);
            if(union.contains(str)) inter.add(str);
            else union.add(str);
        }
        
        if(multi.size()==0) {
            double div=(double)inter.size()/union.size();
            return (int)(div*65536);
        }
        
        for(String str : multi){
            union.removeAll(List.of(str));
            inter.removeAll(List.of(str));
            int cnt1=0, cnt2=0;
            
            if(s1.get(str)==null) cnt1=0;
            else cnt1=s1.get(str);
            if(s2.get(str)==null) cnt2=0;
            else cnt2=s2.get(str);
            
            for(int i=0; i<Math.max(cnt1, cnt2); i++) union.add(str);
            for(int i=0; i<Math.min(cnt1, cnt2); i++) inter.add(str);
        }
        
        double div=(double)inter.size()/union.size();
        return (int)(div*65536);
    }
}