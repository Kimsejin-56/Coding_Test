import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        int result = 0;
        String binary="";
        
        for(int i=l; i<=r; i++){
            try{
                
                if(i % 5 !=0) continue;
                
                result = i/5;
                binary = String.valueOf(result);
                Integer.parseInt(binary, 2);
                
                answer = Arrays.copyOf(answer, answer.length+1);
                result = Integer.parseInt(binary);
                answer[answer.length-1] = result*5;
            }catch(Exception e){
                continue;
            }
        }
        
        if(answer.length == 0){
            int [] arr=new int[1];
            arr[0] = -1;
            return arr;
        }
        
        return answer;
    }
}