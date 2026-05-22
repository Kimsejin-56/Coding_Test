import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> time=new HashMap<>();
        Map<String, Integer> money=new HashMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] tmp=records[i].split(" ");
            int m=getTime(tmp[0]);
            if(tmp[2].equals("IN")){
                time.put(tmp[1], m);
            } else{
                int in=time.get(tmp[1]);
                int minus=m-in;
                money.put(tmp[1], money.getOrDefault(tmp[1], 0)+minus);
                time.remove(tmp[1]);
            }
        }
        
        if(!time.isEmpty()){
            for(String key : time.keySet()){
                int cur=getTime("23:59");
                int total=cur-time.get(key);
                money.put(key, money.getOrDefault(key, 0)+total);
            }
        }
        
        for(String key : money.keySet()){
            int t=money.get(key);
            if(t<=fees[0]) {
                money.put(key, fees[1]);
                continue;
            }
            
            int m=0;
            if((t-fees[0])%fees[2]==0){
                m=(t-fees[0])/fees[2]*fees[3];
            } else{
                m=(((t-fees[0])/fees[2])+1)*fees[3];
            }
            money.put(key, m+fees[1]);
        }
        
        TreeMap<String, Integer> map=new TreeMap<>(money);
        int[] answer=new int[map.size()];
        int idx=0;
        for(String key : map.keySet()){
            answer[idx++]=map.get(key);
        }
        
        return answer;
    }
    
    public int getTime(String str){
        int h=Integer.parseInt(str.substring(0, str.indexOf(":")));
        int m=Integer.parseInt(str.substring(str.indexOf(":")+1));
        return h*60+m;
    }
}