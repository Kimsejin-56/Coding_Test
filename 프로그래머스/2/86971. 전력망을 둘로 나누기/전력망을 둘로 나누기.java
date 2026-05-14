import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> graph=new HashMap<>();
        
        for(int i=0; i<wires.length; i++){
            int a=wires[i][0];
            int b=wires[i][1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            Map<Integer, List<Integer>> map=new HashMap<>();
            for(Integer key : graph.keySet()){
                map.put(key, new ArrayList<>(graph.get(key)));
            }
            boolean[] visited=new boolean[n+1];
            int a = wires[i][0];
            int b = wires[i][1];
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            dfs(visited, a, map);
            int cnt=0;
            for(boolean flag : visited) if(flag) cnt++;
            answer=Math.min(answer, Math.abs((n-cnt) - cnt));
        }

        
        
        return answer;
    }
    
    public void dfs(boolean[] visited, int idx, Map<Integer, List<Integer>> graph){
        if(visited[idx]) return;
        
        visited[idx]=true;
        for(int i : graph.get(idx)){
            dfs(visited, i, graph);
        }
        
    }
}