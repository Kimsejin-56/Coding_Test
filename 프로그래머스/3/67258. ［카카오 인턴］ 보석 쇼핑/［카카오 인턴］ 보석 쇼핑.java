import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        HashMap<String, Integer> map=new HashMap<>();

        for(String s : gems){
            map.putIfAbsent(s, 0);
        }

        int cnt=map.size();

        for(int i=0; i<gems.length; i++){
            if(map.get(gems[i]) == 0) cnt--;

            map.put(gems[i], map.get(gems[i])+1);

            if(cnt==0) {
                end=i+1;

                int j=start;
                if(start>0)  j=start-1;
                for(; j<end; j++){
                    if(map.get(gems[j])-1 == 0){
                        start= j+1;
                        break;
                    }
                    map.put(gems[j], map.get(gems[j])-1);
                }

                if(len>end-start){
                    len=end-start;
                    answer[0]=start;
                    answer[1]=end;
                }
            }
        }

        return answer;
    }
}