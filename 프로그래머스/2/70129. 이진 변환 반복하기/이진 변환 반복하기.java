import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;
        int iter=0;
        
        while(!s.equals("1")){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0') cnt++;
            }
            
            s=s.replace("0", "");
            s=binary(s.length());
            iter++;
        }
        answer[0]=iter;
        answer[1]=cnt;
        
        return answer;
    }
    
    public String binary(int n){
        int num=n;
        String str="";
        String answer="";
        
        while(num!=0){
            str+=num%2;
            num/=2;
        }
        
        for(int i=str.length()-1; i>=0; i--){
            answer+=str.charAt(i);
        }
        
        return answer;
    }
}