import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] arr=new int[3];
        int idx=0;
        int n=0;
        String num="";
        
        for(int i=0; i<dartResult.length(); i++){
            char pre=dartResult.charAt(i);
            
            if(Character.isDigit(pre)) num+=pre;
            else if(pre=='S' || pre=='D' || pre=='T'){
                n=Integer.parseInt(num);
                num="";
                if(pre=='D') n=(int)Math.pow(n,2);
                else if(pre=='T') n=(int)Math.pow(n,3);
                
                arr[idx++]=n;
            }else if(pre=='*'){
                if(idx==1) arr[idx-1]*=2;
                else {
                    arr[idx-2]*=2;
                    arr[idx-1]*=2;
                    continue;
                }    
            }else if(pre=='#'){
                arr[idx-1]= -arr[idx-1];
                continue;
            }
        }
        
        for(int i=0; i<3; i++) answer+=arr[i];
        
        return answer;
    }
}

