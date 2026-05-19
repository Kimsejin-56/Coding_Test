import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        
        int td=getDate(today);
        
        for(String s : terms){
            String str=String.valueOf(s.charAt(0));
            int i=Integer.parseInt(s.substring(s.indexOf(" ")+1));
            map.put(str, i);
        }
        
        for(int i=0; i<privacies.length; i++){
            String str=privacies[i];
            String param=str.substring(0, str.indexOf(" "));
            int cur=getDate(param);
            String alpha=String.valueOf(str.charAt(str.length()-1));
            cur+=map.get(alpha)*28;
            if(cur<=td) answer.add(i+1);
           
        }
        
        int[] result=new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i]=answer.get(i);
        }
        return result;
    }
    
    public int getDate(String str){
        int y=Integer.parseInt(str.substring(0, str.indexOf(".")));
        String r=str.substring(str.indexOf(".")+1);
        int m=Integer.parseInt(r.substring(0, r.indexOf(".")));
        int d=Integer.parseInt(r.substring(r.indexOf(".")+1));
        
        return y*12*28 + m*28 + d;
    }
}