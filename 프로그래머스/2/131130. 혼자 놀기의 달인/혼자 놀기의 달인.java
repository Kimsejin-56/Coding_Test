import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;

    public int solution(int[] cards) {
        answer = 0;
        visited=new boolean[cards.length];

        dfs(0, cards.length, new int[2], cards);

        return answer;
    }

    public void dfs(int depth, int num, int[] arr, int[] cards){
        if(depth==arr.length){
            answer=Math.max(simulation(arr, cards), answer);
        }else {
            for(int i=0; i<num; i++){
                if(!visited[i]){
                    visited[i]=true;
                    arr[depth]=i;
                    dfs(depth+1, num, arr, cards);
                    visited[i]=false;
                }
            }
        }
    }

    public int simulation(int[] arr, int[] cards){
        boolean[] visit=new boolean[cards.length];
        int cnt1=0;
        int cnt2=0;

        for(int i=0; i<arr.length; i++){
            int idx=arr[i];
            int cnt=0;

            while(!visit[idx]){
                visit[idx]=true;
                idx=cards[idx]-1;
                cnt++;
            }
            if(i==0) cnt1=cnt;
            else cnt2=cnt;
        }

        return cnt1*cnt2;
    }
}