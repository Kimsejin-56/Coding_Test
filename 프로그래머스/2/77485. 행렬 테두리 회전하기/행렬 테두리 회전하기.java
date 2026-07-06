import java.util.*;

class Solution {
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr=new int[rows][columns];
        int cnt=1;
        int len=queries.length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j]=cnt++;
            }
        }
        
        for(int l=0; l<len; l++){
            int[] info=queries[l];
            int x1=info[0]-1;
            int y1=info[1]-1;
            int x2=info[2]-1;
            int y2=info[3]-1;
            
            int temp=arr[x1][y1];
            int min=temp;
            
            for(int i=x1; i<x2; i++){
                arr[i][y1]=arr[i+1][y1];
                min=Math.min(min, arr[i][y1]);
            }
            
            for(int i=y1; i<y2; i++){
                arr[x2][i]=arr[x2][i+1];
                min=Math.min(min, arr[x2][i]);
            }
            
            for(int i=x2; i>x1; i--){
                arr[i][y2]=arr[i-1][y2];
                min=Math.min(min, arr[i][y2]);
            }
            
            for(int i=y2; i>y1; i--){
                arr[x1][i]=arr[x1][i-1];
                min=Math.min(min, arr[x1][i]);
            }
            
            arr[x1][y1+1]=temp;
            answer.add(min);
        }
        
        return answer;
    }
}