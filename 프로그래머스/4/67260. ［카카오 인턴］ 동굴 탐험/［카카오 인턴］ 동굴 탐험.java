import java.util.*;

//위상정렬 방식
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] p : path){
            int a = p[0];
            int b = p[1];
            tree[a].add(b);
            tree[b].add(a);
        }
        
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree=new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        makeGraph(tree, graph, indegree, 0, n);
        
        for(int[] o : order){
            int a = o[0];
            int b = o[1];
            graph[a].add(b);
            indegree[b]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0) q.offer(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            
            for(int next : graph[cur]){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        
        return cnt==n;
    }
    
    
    public void makeGraph( List<Integer>[] tree,
                      List<Integer>[] graph,
                      int[] indegree,
                      int start, int n){
        boolean[] visited=new boolean[n];
        visited[start]=true;
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next : tree[cur]){
                if(visited[next]) continue;
                graph[cur].add(next);
                visited[next]=true;
                q.offer(next);
                indegree[next]++;
            }
        }
    }
}