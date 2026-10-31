import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int[] time=new int[(24*3600000)+(60*60000)+60000];
        
        for(String str : lines){
            writeTime(str, time);
            
        }
        
        int answer = time[0];
        
        for(int i=1; i<time.length; i++){
            time[i]+=time[i-1];
            answer=Math.max(answer, time[i]);
        }
        
        return answer;
    }
    
    public void writeTime(String str, int[] time){
        str=str.substring(11);
            
        String[] t=str.split(" ");
        
        String[] tarr=t[0].split(":");
        
        int total=Integer.parseInt(tarr[0])*3600000+Integer.parseInt(tarr[1])*60000;
        double dn=Double.parseDouble(tarr[2])*1000;
        total+=(int)dn;
        int end=total;
        
        t[1]=t[1].replace("s", "");
        dn=Double.parseDouble(t[1])*1000;
        total-=(int)dn;
        int start=total+1;
        
        start=Math.max(0, start - 999);
        
        time[start]+=1;
        time[end+1]-=1;
    }
}