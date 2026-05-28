import java.util.*;

class Solution {
    public int solution(int m, int n, String[] sboard) {
        int answer = 0;
        char[][] board=new char[m][n];
        
        for(int i=0; i<m; i++){
            String str=sboard[i];
            for(int j=0; j<n; j++){
                board[i][j]=str.charAt(j);         
            }
        }
        
        //배열 복사
        char[][] cboard=new char[m][];
        boolean change=true;
        while(change){
            for(int b=0; b<m; b++){
                cboard[b]=Arrays.copyOf(board[b], board[b].length);
            }
            change=false;
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    char ch = board[i][j];
                    if(ch=='0') continue;
                    boolean pass=true;
                    
                    for(int r=0; r<2; r++){
                        for(int c=0; c<2; c++){
                            if(ch != board[i+r][j+c]){
                                pass=false;
                                break;
                            }
                            if(!pass) break;
                        }
                    }
                
                    if(pass){
                        change=true;
                        for(int r=0; r<2; r++){
                            for(int c=0; c<2; c++){
                                cboard[i+r][j+c]='0';
                            }
                            System.out.println();
                        }
                    }
                }
            }
            
            for(int b=0; b<m; b++){
                board[b]=Arrays.copyOf(cboard[b], cboard[b].length);
            }
            
            down(board, n, m);
        }        
        
        for(int di=0; di<m; di++){
            for(int dj=0; dj<n; dj++){
                if(board[di][dj]=='0') answer++;
            }
        }
        return answer;
    }
    
    public void down(char[][] board, int n, int m){
        for(int j=0; j<n; j++){
            boolean pass=false;
            int idx=-1;
            
            for(int i=m-1; i>=0; i--){
                if(board[i][j]=='0' && !pass){
                    pass=true;
                    idx=i;
                } else if(board[i][j]!='0' && pass){
                    char tmp=board[i][j];
                    board[i][j]=board[idx][j];
                    board[idx][j]=tmp;
                    idx--;
                }
            }
        }
    }
}