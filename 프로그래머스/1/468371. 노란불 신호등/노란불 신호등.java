import java.util.*;

class Solution {
    static int[] turn;
    public int solution(int[][] signals) {
        boolean[] ex=new boolean[signals.length];
        turn=new int[signals.length];
        int stop=minus(signals);
        
        int time=1;
        int[] tmp=new int[signals.length];
        Arrays.fill(tmp, 1);
        while(time<=stop){
            if(exit(ex)) return time;
            for(int i=0; i<signals.length; i++){
                int choice=turn[i] % 3;
                if(tmp[i] - signals[i][choice] == 0){
                    turn[i]++;
                    tmp[i]=0;
                }
                if(turn[i]%3==1) ex[i]=true;
                else ex[i]=false;
                
            }
            
            time++;
            for(int i=0; i<signals.length; i++) tmp[i]++;
        }
        
        return -1;
    }
    
    public int minus(int[][] signals){
        int[] sum=new int[signals.length];
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<signals.length; i++){
            for(int j=0; j<signals[i].length; j++){
                sum[i]+=signals[i][j];
            }
            set.add(sum[i]);            
        }
        
        int multi=1;
        for(int i : set){
            multi *= i;
        }
        return multi;
    }
    
    public boolean exit(boolean[] ex){
        for(int i=0; i<ex.length; i++){
            if(!ex[i]) return false;
        }
        return true;
    }
    
}
