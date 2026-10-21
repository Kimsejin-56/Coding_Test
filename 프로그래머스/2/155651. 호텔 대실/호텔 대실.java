import java.util.*;

//8:14

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time=changeTime(book_time);
        int n=60*24;
        int[] t=new int[n];
        
        for(int i=0; i<time.length; i++){
            int[] tarr=time[i];
            
            if(tarr[1]>n) tarr[1]=n;
            
            for(int j=tarr[0]; j<tarr[1]; j++){
                t[j]++;
            }
        }
        
        for(int i=0; i<t.length; i++){
            answer=Math.max(answer, t[i]);
        }
        
        return answer;
    }
    
    public int[][] changeTime(String[][] arr){
        int[][] time=new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            String[] t=arr[i];
            String[] str1=t[0].split(":");
            String[] str2=t[1].split(":");
            int st=Integer.parseInt(str1[0])*60+Integer.parseInt(str1[1]);
            int et=Integer.parseInt(str2[0])*60+Integer.parseInt(str2[1]);
            time[i][0]=st;
            time[i][1]=et+10;
        }
        
        return time;
    }
}