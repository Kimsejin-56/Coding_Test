import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        
        for(int i=0; i<arr.length; i++){
            if(stk.length == 0){
                stk = Arrays.copyOf(stk,1);
                stk[0] = arr[i];
                continue;
            }
            
            if(stk[stk.length - 1] < arr[i]){
                stk = Arrays.copyOf(stk, stk.length + 1);
                stk[stk.length-1] = arr[i];
                continue;
            } else{
                stk = Arrays.copyOfRange(stk, 0, stk.length-1);
                i--;
            }
        }
        
        return stk;
    }
}