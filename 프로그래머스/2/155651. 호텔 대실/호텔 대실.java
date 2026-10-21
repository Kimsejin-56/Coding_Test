import java.util.*;

class Solution {
    static int[] time;
    static int n;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        n=60*24;
        time=new int[n];
        changeTime(book_time);
        
        for(int i=1; i<time.length; i++){
            time[i]+=time[i-1];
            answer=Math.max(answer, time[i]);
        }
        
        return answer;
    }
    
    public void changeTime(String[][] arr){
        for(int i=0; i<arr.length; i++){
            String[] t=arr[i];
            String[] str1=t[0].split(":");
            String[] str2=t[1].split(":");
            int st=Integer.parseInt(str1[0])*60+Integer.parseInt(str1[1]);
            int et=Integer.parseInt(str2[0])*60+Integer.parseInt(str2[1])+10;
            
            if(et>=n) et=n-1;
            
            time[st]+=1;
            time[et]-=1;
        }
    }
}