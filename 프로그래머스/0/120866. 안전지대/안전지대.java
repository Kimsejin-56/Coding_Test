import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len =board.length;
        int[][] arr = new int[len+2][len+2];
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(i == 0) arr[i][j] = -1;
                if(j == 0) arr[i][j] = -1;
                if(i == len+1) arr[i][j] = -1;
                if(j == len+1) arr[i][j] = -1;
            }
        }
        
        for(int i=1; i<=len; i++){
            for(int j=1; j<=len; j++){
                arr[i][j]=board[i-1][j-1];
            }
        }
        
        for(int i=1; i<=len; i++){
            for(int j=1; j<=len; j++){
                if(board[i-1][j-1] == 1){
                    for(int k=i-1; k<=i+1; k++){
                        for(int l=j-1; l<=j+1; l++){
                            arr[k][l]=-1;
                        }
                    }
                }
            }
        }
        
        for(int i=1; i<=len; i++){
            for(int j=1; j<=len; j++){
                if(arr[i][j] == 0) answer++; 
            }
        }
        
        System.out.println(Arrays.deepToString(arr));
        
        return answer;
    }
}