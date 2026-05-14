import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int vm=Integer.parseInt(video_len.substring(0, video_len.indexOf(":")));
        int vs=Integer.parseInt(video_len.substring(video_len.indexOf(":")+1));
        int totals=vm*60+vs;
        
        int posm=Integer.parseInt(pos.substring(0, pos.indexOf(":")));
        int poss=Integer.parseInt(pos.substring(pos.indexOf(":")+1));
        int ps=posm*60+poss;
        
        int ops_m=Integer.parseInt(op_start.substring(0, op_start.indexOf(":")));
        int ops_s=Integer.parseInt(op_start.substring(op_start.indexOf(":")+1));
        int ops=ops_m*60+ops_s;
        
        int ope_m=Integer.parseInt(op_end.substring(0, op_end.indexOf(":")));
        int ope_s=Integer.parseInt(op_end.substring(op_end.indexOf(":")+1));
        int ope=ope_m*60+ope_s;
        
        if(ops<=ps && ps<=ope) ps=ope;
        for(int i=0; i<commands.length; i++){
            String str=commands[i];
            if(str.equals("next")) ps+=10;
            else ps-=10;
            
            if(ps<0) ps=0;
            else if(ps>totals) ps=totals;
            if(ops<=ps && ps<=ope) ps=ope;
        }
        
        int m=ps/60;
        int s=ps%60;
        
        String tmpm="";
        String tmps="";
        if(String.valueOf(m).length()==1) tmpm="0"+m;
        else tmpm=String.valueOf(m);
        
        if(String.valueOf(s).length()==1) tmps="0"+s;
        else tmps=String.valueOf(s);
        
        answer=tmpm+":"+tmps;
        System.out.println(answer);
        
        return answer;
    }
}