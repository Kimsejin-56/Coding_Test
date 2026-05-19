import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        
        int ty=Integer.parseInt(today.substring(0, today.indexOf(".")));
        String rest=today.substring(today.indexOf(".")+1);
        int tm=Integer.parseInt(rest.substring(0, rest.indexOf(".")));
        int td=Integer.parseInt(rest.substring(rest.indexOf(".")+1));
        
        for(String s : terms){
            String str=String.valueOf(s.charAt(0));
            int i=Integer.parseInt(s.substring(s.indexOf(" ")+1));
            map.put(str, i);
        }
        
        for(int i=0; i<privacies.length; i++){
            String str=privacies[i];
            int y=Integer.parseInt(str.substring(0, str.indexOf(".")));
            String r=str.substring(str.indexOf(".")+1);
            int m=Integer.parseInt(r.substring(0, r.indexOf(".")));
            int d=Integer.parseInt(r.substring(r.indexOf(".")+1, r.indexOf(" ")));
            String alpha=String.valueOf(str.charAt(str.length()-1));
            
            int term=map.get(alpha);
            m+=term;
            if(m>12){
                if(m%12==0){
                    y+=m/12-1;
                    m=12;
                } else{
                    y+=m/12;
                    m=m%12;
                }
            }
            
            if(ty>y) answer.add(i+1);
            else if(ty==y){
                if(tm>m) answer.add(i+1);
                else if(tm==m){
                    if(td>=d) answer.add(i+1);
                }
            }
        }
        
        int[] result=new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i]=answer.get(i);
        }
        return result;
    }
}