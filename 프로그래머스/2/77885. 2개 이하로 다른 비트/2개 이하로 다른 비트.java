import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            String s=binary(numbers[i]);
            
            if(numbers[i]%2==0){
                answer[i]=numbers[i]+1;
                continue;
            }
            
            s="0"+s;
            for(int j=s.length()-1; j>=1; j--){
                String tmp="";
                tmp+=s.charAt(j-1);
                tmp+=s.charAt(j);
                if(tmp.equals("01")){
                    String str="";
                    for(int k=0; k<j-1; k++){
                        str+=s.charAt(k);
                    }
                    
                    str+="10";
                    
                    for(int k=j+1; k<s.length(); k++){
                        str+=s.charAt(k);
                    }
                    
                    answer[i]=Long.parseLong(str, 2);
                    break;
                }
            }
            
          
        }
        
        
        return answer;
    }
    
    public String binary(long n){
        String s="";
        while(n!=0){
            s=n%2+s;
            n/=2;
        }
        
        return s;
    }
}