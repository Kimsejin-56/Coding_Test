import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        visited=new boolean[n+1];
        List<List<Integer>> arr=new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int n1=edge[i][0];
            int n2=edge[i][1];
            
            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }
        
        return bfs(1, arr, n);
    }
    
     public int bfs(int num, List<List<Integer>> arr, int n){
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(num);
        visited[num]=true;
        int cnt=0;
        
        while(!q.isEmpty()){
            int len=q.size();
            
            for(int l=0; l<len; l++){
                int p=q.poll();
                
                for(int i : arr.get(p)){
                    if(!visited[i]){
                        q.offer(i);
                        visited[i]=true;
                    }
                }
            }
            cnt=len;
        }
        return cnt;
    }
}