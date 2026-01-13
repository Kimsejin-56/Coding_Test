import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        int result = 0;
        String tmp="";
        List<String> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            if(i%5 == 0) list.add(String.valueOf(i));
            
            
        }
        
        
        for(int i=0; i<list.size(); i++){
            tmp=list.get(i).replace("5","").replace("0","");
            if(tmp.equals("")) temp.add(list.get(i));
        }
        
        int[] answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = Integer.parseInt(temp.get(i));
        }
        
        if(temp.size()==0) {
            answer=Arrays.copyOf(answer, answer.length+1);
            answer[0]=-1;
        }
        return answer;
    }
}