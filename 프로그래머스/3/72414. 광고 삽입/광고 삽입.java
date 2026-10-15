import java.util.*;

class Point{
    int s, e;
    public Point(int s, int e){
        this.s=s;
        this.e=e;
    }
}

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        List<Point> list=new ArrayList<>();
        String[] tmp=play_time.split(":");
        int pt=Integer.parseInt(tmp[0])*60*60+Integer.parseInt(tmp[1])*60+Integer.parseInt(tmp[2]);
        tmp=adv_time.split(":");
        int at=Integer.parseInt(tmp[0])*60*60+Integer.parseInt(tmp[1])*60+Integer.parseInt(tmp[2]);
        
        for(String str : logs){
            String[] substr=str.split("-");
            tmp=substr[0].split(":");
            int s=Integer.parseInt(tmp[0])*60*60+Integer.parseInt(tmp[1])*60+Integer.parseInt(tmp[2]);
            tmp=substr[1].split(":");
            int e=Integer.parseInt(tmp[0])*60*60+Integer.parseInt(tmp[1])*60+Integer.parseInt(tmp[2]);
            list.add(new Point(s, e));
        }
        
        list.sort((a,b)->a.s-b.s);
        int[] time=new int[pt+1];
        for(Point p : list){
            time[p.s]++;
            time[p.e]--;
        }
        
        for(int i=1; i<time.length; i++){
            time[i]+=time[i-1];
        }
        int idx=0;
        long sum=0;
        long max=0;
        int start=0;
        
        for(int i=0; i<at; i++) sum+=time[i];
        max=sum;
        for(int i=at; i<time.length; i++){
            sum+=time[i];
            sum-=time[idx++];
            if(max<sum){
                max=sum;
                start=idx;
            }
        }
        
        String h=String.valueOf(start/3600);
        int temp=(start%3600);
        String m=String.valueOf(temp/60);
        String s=String.valueOf(temp%60);
        
        if(h.length()==1) h="0"+h;
        if(m.length()==1) m="0"+m;
        if(s.length()==1) s="0"+s;
        answer+=h+":"+m+":"+s;
        
        return answer;
    }
}