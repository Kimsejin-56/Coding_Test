import java.util.*;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<roads.length; i++){
            int n1=roads[i][0];
            int n2=roads[i][1];

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        for(int i=0; i<sources.length; i++) answer[i]=bfs(sources[i], list, destination, new boolean[n+1]);

        return answer;
    }

    public int bfs(int s, List<List<Integer>> list, int des, boolean[] visited){
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(s);
        visited[s]=true;
        int cnt=0;
        
        while(!q.isEmpty()){
            int len=q.size();
            
            for(int l=0; l<len; l++){
                int i=q.poll();
                if(i==des) return cnt;
                
                for(int n : list.get(i)){
                    if(!visited[n]){
                        q.offer(n);
                        visited[n]=true;
                    }
                }
            } 
            cnt++;
        }

        return -1;
    }
}