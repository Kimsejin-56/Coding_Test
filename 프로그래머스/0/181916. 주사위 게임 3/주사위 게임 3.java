import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = {a,b,c,d};
        int[] arrCnt = new int[6];
        int[] num= new int[2];
        
        for(int i=0; i<arr.length; i++){
            arrCnt[arr[i]-1]++;
        }
        
        for(int i=0; i<arrCnt.length; i++){
            
            if(arrCnt[i] == 4){
                answer = 1111*(i+1);
                return answer;
                
            } else if( arrCnt[i] == 3){
                for(int j=0; j<6; j++){
                    if(arrCnt[j] == 1) num[0] = j+1;
                }
                answer = (10 * (i+1) + num[0]) * (10 * (i+1) + num[0]);
                return answer;
                
            } else if(arrCnt[i] == 2){
                //same 2
                for(int j=0; j<6; j++){
                    if(i == j) continue;
                    if(arrCnt[j] == 2){
                        answer = ((j+1) + (i+1)) * (Math.abs(((j+1) - (i+1))));
                        return answer;
                    }
                }
                
                //same 1, other 2
                int idx=0;
                for(int j=0; j<6; j++){
                    if(arrCnt[j] == 1) num[idx++] = j+1;
                }
                answer = num[0] * num[1];
                return answer;
            } 
        }
        
        answer = arr[0];
        for(int i=1; i<arr.length; i++){
            if(answer > arr[i]) answer = arr[i];
        }
        
        return answer;
    }
    
    
               
}