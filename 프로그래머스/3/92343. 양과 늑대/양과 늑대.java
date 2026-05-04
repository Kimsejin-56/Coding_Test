import java.util.*;

class Solution {
    static List<List<Integer>> tree;
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        tree=new ArrayList<>();
        
        for(int i=0; i<info.length; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            tree.get(edges[i][0]).add(edges[i][1]);
        }
        List<Integer> candidates=new ArrayList<>();
        candidates.add(0);
        dfs(info, 0, 0, candidates);
        
        return answer;
    }
    
    public void dfs(int[] info, int sheep, int wolf, List<Integer> candidates){
        for(int i=0; i<candidates.size(); i++){
            int ns=sheep;
            int nw=wolf;
            
            if(info[candidates.get(i)]==0) ns++;
            else nw++;
            
            if(nw>=ns) continue;
            
            answer=Math.max(answer, ns);
            
            List<Integer> nc=new ArrayList<>(candidates);
            nc.remove(i);
            for(int node : tree.get(candidates.get(i))){
                nc.add(node);
            }
            dfs(info, ns, nw, nc);
        }
        
    }
}

