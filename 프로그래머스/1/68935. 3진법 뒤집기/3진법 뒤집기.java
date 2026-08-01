import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int num=n;
        String str3="";
        
        while(num!=0){
            str3+=num%3;
            num/=3;
        }
        
        int idx=str3.length()-1;
        for(int i=0; i<str3.length(); i++){
            int tmp=Integer.parseInt(String.valueOf(str3.charAt(i)));
            int m=(int)Math.pow(3, idx--);
            answer+=tmp*m;
        }
        
        return answer;
    }
}