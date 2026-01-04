class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] min = {101, 101, 101};
        int[] idx = new int[3];
        
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                for(int j=0; j<3; j++){
                    if(rank[i] < min[j]){
                        if(j!=2){
                            for(int k=2; k>0; k--){
                                min[k] = min[k-1];
                                idx[k] = idx[k-1];
                            }   
                        }
                        
                        
                        min[j] = rank[i];
                        idx[j] = i;
                        break;
                    }
                }
            }
        }
        
        return 10000*idx[0] + 100*idx[1] + idx[2];
    }
}