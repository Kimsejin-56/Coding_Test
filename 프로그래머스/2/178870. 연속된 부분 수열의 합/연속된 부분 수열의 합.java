import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<int[]> list=new ArrayList<>();
        int idx=0;
        int sum=0;
        
        for(int i=0; i<sequence.length; i++){
            sum+=sequence[i];
            
            while(sum>k){
                sum-=sequence[idx++];                    
            }
            
            if(sum==k){
                int[] tmp=new int[2];
                tmp[0]=idx;
                tmp[1]=i;
                list.add(tmp);
            }
        }
        
        int len=Integer.MAX_VALUE;
        if(list.size()>1){
            for(int i=0; i<list.size(); i++){
                int[] tmp=list.get(i);
                
                if(len>tmp[1]-tmp[0]){
                    len=tmp[1]-tmp[0];
                    idx=i;
                }
            }
        }else idx=0;
        
        answer=list.get(idx);
        
        return answer;
    }
}