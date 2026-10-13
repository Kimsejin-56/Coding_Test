import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> answer = new HashMap<>();
        List<Integer> sort=new ArrayList<>();

        for(int i=0; i<records.length; i++){
            String record=records[i];
            String[] str=record.split(" ");
            String[] time=str[0].split(":");
            int cnum=Integer.parseInt(str[1]);
            String dir=str[2];
            int t=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);

            if(dir.equals("IN")){
                map.put(cnum, t);
            }else {
                int cur=t-map.get(cnum);
                answer.put(cnum, cur+answer.getOrDefault(cnum, 0));
                map.remove(cnum);
            }
        }

        int t=23*60+59;
        for(int cnum : map.keySet()){
            int time=t-map.get(cnum);
            answer.put(cnum, time+answer.getOrDefault(cnum, 0));
        }

        for(int cnum : answer.keySet()){
            sort.add(cnum);
            int time=answer.get(cnum);

            if(time<=fees[0]){
                answer.put(cnum, fees[1]);
            }else{
                time-=fees[0];
                int n=time/fees[2];
                if(time%fees[2]!=0) n++;
                answer.put(cnum, fees[1]+n*fees[3]);
            }
        }

        Collections.sort(sort);

        int[] arr=new int[sort.size()];
        for(int i=0; i<sort.size(); i++){
            arr[i]=answer.get(sort.get(i));
        }

        return arr;
    }
}