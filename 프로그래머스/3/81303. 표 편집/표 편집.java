import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int idx=k;
        int size=n;
        Stack<Integer> rm=new Stack<>();
        int[] prev=new int[n];
        int[] next=new int[n];
        
        for(int i=0; i<n; i++){
            next[i]=i+1;
            prev[i]=i-1;
        }
        
        for(int i=0; i<cmd.length; i++){
            String c=cmd[i];
            
            if(c.length()==1){
                if(c.equals("C")) {
                    rm.push(idx);
                    if(prev[idx]!=-1) next[prev[idx]]=next[idx];
                    if(next[idx]!=n) prev[next[idx]]=prev[idx];
                    
                    if(next[idx]==n) idx=prev[idx];
                    else idx=next[idx];
                    
                }else {
                    int rn=rm.pop();
                    if(prev[rn]!=-1) next[prev[rn]]=rn;
                    if(next[rn]!=n) prev[next[rn]]=rn;
                }
            }else{
                String[] cs=c.split(" ");
                int len=Integer.parseInt(cs[1]);
                
                if(cs[0].equals("D")){
                    for(int j=0; j<len; j++){
                        idx=next[idx];
                    }
                }else {
                    for(int j=0; j<len; j++){
                        idx=prev[idx];
                    }
                }
            }
        }
        
        char[] answer=new char[n];
        Arrays.fill(answer, 'O');
        while(!rm.isEmpty()) answer[rm.pop()]='X';
        
        return String.valueOf(answer);
    }
}