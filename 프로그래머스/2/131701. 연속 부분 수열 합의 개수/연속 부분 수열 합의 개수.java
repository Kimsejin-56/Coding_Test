import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set=new HashSet<>();
        int n=elements.length;
        for(int i=1; i<=n; i++){
            int sum=0;
            int idx=0;
            
            for(int j=0; j<i; j++) sum+=elements[j];
           
            set.add(sum);
            
            int ip=i;
            for(int j=0; j<n; j++){
                if(ip==n){
                    ip=0;
                }
                sum+=elements[ip];
                sum-=elements[idx++];
                set.add(sum);
                ip++;
            }
        }
        
        return set.size();
    }
}