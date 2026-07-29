import java.util.*;

class Solution {
    static int n, m;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        n = lock.length;
        m = key.length;
        int padding=m-1;
        int[][] board=new int[n+2*padding][n+2*padding];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[padding+i][padding+j]=lock[i][j];
            }
        }

        //이동 완탐 구현
        for(int s=0; s<4; s++){
            int[][] tk=spin(key, s);
            
            for(int sx=0; sx<board.length-padding; sx++){
                for(int sy=0; sy<board.length-padding; sy++){
                    boolean flag=false;
                    
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            board[sx+i][sy+j]+=tk[i][j];
                        }
                    }
                    
                    //검사 로직
                    for(int i=0; i<n; i++){
                        for(int j=0; j<n; j++){
                            if(board[padding+i][padding+j]>=2 || board[padding+i][padding+j]==0){
                                flag=true;
                                break;
                            }
                        }
                        if(flag) break;
                    }
                    if(!flag) return true;

                    //복구 로직
                    board=new int[n+2*padding][n+2*padding];
                    for(int i=0; i<n; i++){
                        for(int j=0; j<n; j++){
                            board[padding+i][padding+j]=lock[i][j];
                        }
                    }
                }
            }
        }
        
        return answer;
    }

    public int[][] spin(int[][] key, int num) {
        int[][] temp = new int[m][m];
        int[][] tk = new int[m][m];

        // 초기 키 배열 복사
        for (int r=0; r<m; r++) {
            for (int c=0; c<m; c++) {
                tk[r][c]=key[r][c];
            }
        }

        if (num==0) return tk;

        for (int i=1; i<=num; i++) {
            for (int r=0; r<m; r++) {
                for (int c=0; c<m; c++) {
                    temp[c][m-1-r]=tk[r][c];
                }
            }

            for (int r=0; r<m; r++) {
                for (int c=0; c<m; c++) {
                    tk[r][c]=temp[r][c];
                }
            }
        }
        return temp;
    }
}