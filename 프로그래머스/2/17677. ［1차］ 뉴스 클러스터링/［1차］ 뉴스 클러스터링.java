import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> s1=new ArrayList<>();
        List<String> s2=new ArrayList<>();
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
            if(str.length()==2) s1.add(str);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String str="";
            for(int j=i; j<=i+1; j++){
                if(Character.isLetter(str2.charAt(j))){
                    str+=str2.charAt(j);
                } else break;   
            }
            if(str.length()==2) s2.add(str);
        }
        
        if(s1.size()==0 && s2.size()==0) return 65536;
        
        union.addAll(s1);
        boolean[] flag=new boolean[s2.size()];
        Set<String> multi=new HashSet<>();
        int idx=0;
        for(int i=0; i<s1.size(); i++){
            int cnt=0;
            for(int j=0; j<s2.size(); j++){
                if(s1.get(i).equals(s2.get(j))) {
                    inter.add(s1.get(i));
                    flag[j]=true;
                    cnt++;
                }
            }
            if(cnt>=2) multi.add(s1.get(i));
            
            cnt=0;
            for(int j=0; j<s1.size(); j++){
                if(s1.get(i).equals(s1.get(j))) cnt++;
                
            }
            
            if(cnt>=2) multi.add(s1.get(i));
        }
        
        for(int i=0; i<s2.size(); i++){
            if(!flag[i]) union.add(s2.get(i));
        }

        
        if(multi.size()==0) {
            double div=(double)inter.size()/union.size();
            return (int)(div*65536);
        }
        
        for(String str : multi){
            union.removeAll(List.of(str));
            inter.removeAll(List.of(str));
            int cnt1=0;
            int cnt2=0;
            
            for(String s : s1){
                if(str.equals(s)) cnt1++;
            }
            
            for(String s : s2){
                if(str.equals(s)) cnt2++;
            }
            
            for(int i=0; i<Math.max(cnt1, cnt2); i++) union.add(str);
            for(int i=0; i<Math.min(cnt1, cnt2); i++) inter.add(str);
        }
        
        double div=(double)inter.size()/union.size();
        return (int)(div*65536);
    }
}