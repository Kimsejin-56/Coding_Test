import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] crew=new int[timetable.length];
        int idx=0;
        int cnt=0;
        int bus=0;
        
        for(int i=0; i<crew.length; i++){
            crew[i]=convertInt(timetable[i]);
        }
        Arrays.sort(crew);
        
        for(int i=0; i<n; i++){
            bus=540+i*t;
            cnt=0;
            
            while(idx<crew.length && crew[idx]<=bus && cnt<m){
                cnt++;
                idx++;
            }
        }
        
        if(cnt<m) answer=convertString(bus);
        else if(cnt==m){
            answer=convertString(crew[idx-1]-1);
        }
        
        return answer;
    }
    
    public int convertInt(String str){
        String[] arr=str.split(":");
        int[] is=new int[2];
        int time=0;
        
        for(int i=0; i<2; i++){
            is[i]=Integer.parseInt(arr[i]);
        }
        
        time+=is[0]*60;
        time+=is[1];
        
        return time;
    }

    public String convertString(int n){
        String str="";
        int h=n/60;
        int m=n%60;
        
        if(h<10){
            str+="0";
            str+=h+":";
        }else str+=h+":";
        
        if(m<10){
            str+="0";
            str+=m;
        }else str+=m;
        
        return str;
    }
}