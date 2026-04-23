import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int idx=1;
        int h=0;
        if(n%w==0) h=n/w;
        else h=n/w+1;
        
        int[][] arr = new int[h][w];
        for(int i=0; i<h; i++){
            
            if(i%2==0){
                for(int j=0; j<w; j++){
                    if(idx > n) break;
                    arr[i][j]=idx++;
                }
            }else if(i%2==1){
                for(int j=w-1; j>=0; j--){
                    if(idx > n) break;
                    arr[i][j]=idx++;
                }
            }
        }
        
        int col=0;
        int row=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j]==num){
                    col=i;
                    row=j;
                }
            }
        }
        if(arr[h-1][row]==0) h=h-1;
        answer=h-col;
        
        return answer;
    }
}