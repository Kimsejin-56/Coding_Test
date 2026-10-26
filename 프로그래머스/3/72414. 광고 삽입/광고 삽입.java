import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long max=0;
        int idx=0;
        int start=0;
        int adv=getTime(adv_time);
        int play=getTime(play_time);
        int[] time=new int[play+1];
        
        getLogs(logs, time);
        long sum=time[0];
        
        for(int i=1; i<adv; i++){
            time[i]+=time[i-1];
            sum+=time[i];
        }
        
        max=sum;
        
        for(int i=adv; i<time.length; i++){
            time[i]+=time[i-1];
            sum+=time[i];
            sum-=time[idx++];
            
            if(max<sum){
                max=sum;
                start=idx;
            }
        }
        
        return makeTime(start);
    }
    
    public String makeTime(int n){
        String h=String.valueOf(n/3600);
        String m=String.valueOf((n%3600)/60);
        String s=String.valueOf((n%3600)%60);
        
        if(h.length()==1) h="0"+h;
        if(m.length()==1) m="0"+m;
        if(s.length()==1) s="0"+s;
        
        return h+":"+m+":"+s;
    }
    
    public int getTime(String str){
        String[] t=str.split(":");
        return Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
    }
    
    public void getLogs(String[] logs, int[] time){
        for(int i=0; i<logs.length; i++){
            String[] t=logs[i].split("-");
            int n1=getTime(t[0]);
            int n2=getTime(t[1]);;
            
            time[n1]++;
            time[n2]--;
        }
    }
}