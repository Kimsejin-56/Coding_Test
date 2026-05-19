class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int timeout=attacks[attacks.length-1][0];
        int t=1;
        int theal=bandage[1];
        int aheal=bandage[2];
        int cur=health;
        int cnt=0, idx=0;
        
        System.out.println(theal+" "+aheal);
        while(t<=timeout){
            if(t==attacks[idx][0]){
                cur-=attacks[idx][1];
                cnt=0;
                idx++;
            }else{
                cur+=theal;
                cnt++;
            }
            
            if(cnt==bandage[0]) {
                cur+=aheal;
                cnt=0;
            }
            
            System.out.println("t="+t+" cur="+cur+" "+idx);
            
            if(cur>health) cur=health;
            else if(cur<=0) return -1;
            t++;
        }
        
        return cur;
    }
}