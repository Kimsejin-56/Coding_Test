import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                bfs(visited, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(boolean[] visited, int[][] computers, int cur){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur]=true;
        
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<computers.length; i++){
                if(computers[x][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }
}