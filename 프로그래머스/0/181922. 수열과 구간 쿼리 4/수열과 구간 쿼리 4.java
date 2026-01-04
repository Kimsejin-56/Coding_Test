class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int k = query[2];
            
            for(int j=query[0]; j<=query[1]; j++){
                if(j % k == 0){
                    arr[j]++;
                }
                
            }
        }
        
        return arr;
    }
}