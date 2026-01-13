import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int temp=0;
        
        for(int i=-1000; i<=1000; i++){
            temp=0;
            for(int j=0; j<num; j++){
                temp += i+j;
            }    
            
            if(temp == total){
                for(int j=0; j<num; j++){
                    answer[j] = i+j;
                }
            }
        }
        
        
        return answer;
    }
}