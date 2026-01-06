import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int [][] answer;

        if(arr.length >= arr[0].length){
            answer = new int[arr.length][arr.length];
        } else {
            answer = new int[arr[0].length][arr[0].length];
        }

        for(int i = 0; i < arr.length; i++){
            int[] temp = arr[i];

            if(temp.length != answer.length){
                if(answer.length > temp.length){
                    for(int j = 0; j < answer.length - temp.length; j++){
                        temp = Arrays.copyOf(temp, temp.length + 1);
                        temp[temp.length - 1] = 0;
                    }
                }
            }

            for(int k = 0; k < temp.length; k++){
                answer[i][k] = temp[k];
            }
        }

        return answer;
    }
}
