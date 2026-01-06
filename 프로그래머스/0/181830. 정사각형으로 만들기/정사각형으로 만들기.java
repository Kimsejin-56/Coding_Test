import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int [][] answer;
        
        if(arr.length >= arr[0].length){
            answer = new int[arr.length][arr.length];
            
        } else {
            answer = new int[arr[0].length][arr[0].length];
        }
        
        
        for(int i=0; i<arr.length; i++){
            int[] temp = arr[i];
            
            if(temp.length != arr.length){
                if(arr.length > temp.length){
                    for(int j=0; j<arr.length-temp.length; j++){
                        temp = Arrays.copyOf(temp, temp.length+1);
                        temp[temp.length-1] = 0;
                    }
                }
            }
            
            //answer[i]=temp;
            
            for(int j=0; j<temp.length; j++){
                answer[i][j] = temp[j];
            }
        }
        
        return answer;
    }
}