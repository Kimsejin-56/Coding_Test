import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] arr=new char[3][3];
        int cntO=0;
        int cntX=0;
        int to=0;
        int tx=0;
        
        //2차원 배열 생성
        for(int i=0; i<3; i++){
            String str=board[i];
            for(int j=0; j<3; j++){
                arr[i][j]=str.charAt(j);
                if(arr[i][j]=='O') to++;
                else if(arr[i][j]=='X') tx++;
            }
        }
        
        if(to < tx) return 0;
        if(to-tx > 1) return 0;
        
        //가로 
        for(int i=0; i<3; i++){
            cntO=0;
            cntX=0;
            for(int j=0; j<3; j++){
                if(arr[i][j]=='O') cntO++;
                else if(arr[i][j]=='X') cntX++;
            }
            
            if(!isValid(cntO, cntX, to, tx)) return 0;
        }
        
        //세로
        for(int i=0; i<3; i++){
            cntO=0;
            cntX=0;
            for(int j=0; j<3; j++){
                if(arr[j][i]=='O') cntO++;
                else if(arr[j][i]=='X') cntX++;
            }
            
            if(!isValid(cntO, cntX, to, tx)) return 0;
        }
        
        //대각선(\)
        cntO=0;
        cntX=0;
        for(int i=0; i<3; i++){
            if(arr[i][i]=='O') cntO++;
            else if(arr[i][i]=='X') cntX++;
        }
        
        if(!isValid(cntO, cntX, to, tx)) return 0;
        
        //대각선(/)
        cntO=0;
        cntX=0;
        for(int i=0; i<3; i++){

            if(arr[i][2-i]=='O') cntO++;
            else if(arr[i][2-i]=='X') cntX++;
        }
        
        if(!isValid(cntO, cntX, to, tx)) return 0;
        
        return 1;
    }
    
    public boolean isValid(int cntO, int cntX, int to, int tx){
        if(cntO==3){
            if(to==tx) return false;
        }
            
        if(cntX==3){
            if(to>tx) return false;
        }
        
        return true;
    }
}