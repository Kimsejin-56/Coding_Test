import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] diff=new int[board.length+2][board[0].length+2];
        
        for(int l=0; l<skill.length; l++){
            int[] sk=skill[l];
            
            action(diff, sk[0], sk[1], sk[2], sk[3], sk[4], sk[5]);
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
    
    public void action(int[][] diff, int type, int x1, int y1, int x2, int y2, int degree){
        if(type==1){
            diff[x1+1][y1+1]-=degree;
            diff[x1+1][y2+2]+=degree;
            diff[x2+2][y1+1]+=degree;
            diff[x2+2][y2+2]-=degree;
        }else {
            diff[x1+1][y1+1]+=degree;
            diff[x1+1][y2+2]-=degree;
            diff[x2+2][y1+1]-=degree;
            diff[x2+2][y2+2]+=degree;
        }
    }
}