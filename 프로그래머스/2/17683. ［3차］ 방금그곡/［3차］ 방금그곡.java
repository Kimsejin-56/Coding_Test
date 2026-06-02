import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max=0;
        m=convert(m);
    
        for(int i=0; i<musicinfos.length; i++){
            String[] arr=musicinfos[i].split(",");
            int time=getTime(arr[0], arr[1]);
            String str=convert(arr[3]);
            
            String music="";
            int idx=0;
            for(int j=0; j<time; j++){
                idx=j % str.length();
                music+=String.valueOf(str.charAt(idx));
            }
            
            if(music.contains(m)){
                if(max < time){
                    max=time;
                    answer=arr[2];
                }
            }
        }
        
        return answer;
    }
    
    public int getTime(String s, String e){
        String[] sarr=s.split(":");
        String[] earr=e.split(":");
        
        int sh=Integer.parseInt(sarr[0]);
        int sm=Integer.parseInt(sarr[1]);
        int eh=Integer.parseInt(earr[0]);
        int em=Integer.parseInt(earr[1]);
        
        return (eh-sh)*60 + (em-sm);
    }
    
    
    public String convert(String s){
        s=s.replace("A#", "a");
        s=s.replace("C#", "c");
        s=s.replace("D#", "d");
        s=s.replace("F#", "f");
        s=s.replace("G#", "g");
        return s;
    }
}