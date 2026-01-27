import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length/m;
        int arr[][] = new int[len][m];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            list.add(score[i]);            
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i=0; i<len; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = list.get(j);
            }
            list = list.subList(m, list.size());
        }
        
        int[] min = new int[len];
        for(int i=0; i<len; i++){
            min[i] = k;
        }
        
        for(int i=0; i<len; i++){
            for(int j=0; j<m; j++){
                if(min[i] > arr[i][j]){
                    min[i] = arr[i][j];
                }
            }
        }
        
        for(int i=0; i<len; i++){
            answer += min[i]*m;
        }
        
        return answer;
    }
}