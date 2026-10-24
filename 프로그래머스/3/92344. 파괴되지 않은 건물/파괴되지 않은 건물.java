import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] diff=new int[board.length+2][board[0].length+2];
        
        for (int[] sk : skill) {
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];

            int degree = sk[0] == 1 ? -sk[5] : sk[5];

            diff[r1+1][c1+1] += degree;
            diff[r1+1][c2+2] -= degree;
            diff[r2+2][c1+1] -= degree;
            diff[r2+2][c2+2] += degree;
        }
        
        for(int i=1; i<diff.length; i++){
            for(int j=1; j<diff[0].length; j++){
                diff[i][j]+=diff[i][j-1];
            }
        }
        
        for(int i=1; i<diff.length; i++){
            for(int j=1; j<diff[0].length; j++){
                diff[i][j]+=diff[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]+=diff[1+i][1+j];
            }
        }
       
        return getLiving(board);
    }
    
    public int getLiving(int[][] board){
        int cnt=0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]>0) cnt++;
            }
        }
        return cnt;
    }
}