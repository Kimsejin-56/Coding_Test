import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len=p.length();
        long ip=Long.parseLong(p);
        List<Long> numbers=new ArrayList<>();
        
        for(int i=0; i<t.length()-len+1; i++){
            String s="";
            for(int j=0; j<len; j++){
                s+=String.valueOf(t.charAt(i+j));
            }
            numbers.add(Long.parseLong(s));
        }
        
        for(long n : numbers){
            if(n <= ip) answer++;
        }
        
        return answer;
    }
}