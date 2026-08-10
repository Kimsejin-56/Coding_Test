import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list=new ArrayList<>();
        
        for(int p : people){
            list.add(p);
        }
        
        int idx=list.size()-1;
        Collections.sort(list);
        int i;
        
        for(i=0; i<list.size(); i++){
            if(i>=idx) break;
            
            int cur=list.get(i);
            while(cur+list.get(idx)>limit){
                answer++;
                idx--;
                if(i>=idx) break;
            }
            
            if(i<idx && cur+list.get(idx)<=limit){
                answer++;
                idx--;
            }else if(idx==i) answer++;
        }
        
        if(i==idx) answer++;
        
        return answer;
    }
}