import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list=new ArrayList<>();
        
        for(int p : people){
            list.add(p);
        }
        
        int right=list.size()-1;
        int left=0;
        Collections.sort(list);
        System.out.println(list);
        
        while(left<=right){
            int cur=list.get(left);
            while(cur+list.get(right)>limit){
                answer++;
                right--;
                if(left>=right) break;
            }
            
            if(left<right && cur+list.get(right)<=limit) answer++;
            else if(left==right) answer++;
            
            left++;
            right--;
        }
        
        return answer;
    }
}