class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int [queries.length];
        int[] query = new int[3];
        int k;
        
        for(int i=0; i<queries.length; i++){
            query = queries[i];
            k = query[2];
            int min = 1000001;
            
            for(int j=query[0]; j<=query[1]; j++){
                if(arr[j] > k){
                    if(min > arr[j]){
                        min = arr[j];
                    }
                    
                }
            }
            
            if(min == 1000001){
                min = -1;
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}