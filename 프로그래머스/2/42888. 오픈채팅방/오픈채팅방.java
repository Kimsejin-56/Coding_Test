import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer=new ArrayList<>();
        Map<String, String> action=new HashMap<>();
        Map<String, String> id=new HashMap<>();
        
        action.put("Enter", "님이 들어왔습니다.");
        action.put("Leave", "님이 나갔습니다.");
        
        for(String str : record){
            String[] tmp=str.split(" ");
            if(tmp.length==2) continue;
            id.put(tmp[1], tmp[2]);
        }
        
        for(int i=0; i<record.length; i++){
            String str=record[i];
            String[] tmp=str.split(" ");
            if(tmp[0].equals("Change")) continue;
            answer.add(id.get(tmp[1])+action.get(tmp[0]));
        }
        
        return answer.toArray(new String[0]);
    }
}