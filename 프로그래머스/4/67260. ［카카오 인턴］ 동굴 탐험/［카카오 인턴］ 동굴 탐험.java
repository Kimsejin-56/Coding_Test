import java.util.*;

class Solution {
    static List<List<Integer>> tree;   
    static int[] before, wait;
    
    public boolean solution(int n, int[][] path, int[][] order) {
        tree=new ArrayList<>();
        before=new int[n];
        wait=new int[n];
        Arrays.fill(before, -1);
        Arrays.fill(wait, -1);
        
        for(int[] o : order){
            before[o[1]]=o[0];
        }
        if(before[0] != -1) return false;
        
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i=0; i<path.length; i++){
            tree.get(path[i][0]).add(path[i][1]);
            tree.get(path[i][1]).add(path[i][0]);
        }
        
        boolean[] visited=new boolean[n];
        bfs(0, visited);
        int cnt=0;
        for(boolean flag : visited) if(flag) cnt++;
        if(cnt==n) return true;
        return false;
    }
    
    public void bfs(int node, boolean[] visited){
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            int nd=q.poll();
                
            if(before[nd] != -1 && !visited[before[nd]]){
                wait[before[nd]]=nd;
                continue;                        
            }
                
            
            if(!visited[nd]){
                if(wait[nd] != -1) q.offer(wait[nd]);
                visited[nd]=true;
                for(int tmp : tree.get(nd)) q.offer(tmp);
            }
        }
    }
}