import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    static Map<Character, Integer> map;

    public int solution(int n, String[] data) {
        answer = 0;
        char[] p={'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited=new boolean[p.length];
        map=new HashMap();
        for(int i=0; i<p.length; i++) map.put(p[i], 0);

        dfs(0, p, data);

        return answer;
    }

    public void dfs(int depth, char[] p, String[] data){
        if(depth==p.length){
            if(simulation(data)) answer++;
        }else {
            for(int i=0; i<p.length; i++){
                if(!visited[i]){
                    visited[i]=true;
                    map.put(p[i], depth);
                    dfs(depth+1, p, data);
                    visited[i]=false;
                }
            }
        }
    }

    public boolean simulation(String[] data){
        for(int i=0; i<data.length; i++){
            String str=data[i];
            char p1=str.charAt(0);
            char p2=str.charAt(2);
            char compare=str.charAt(3);
            int n=Integer.parseInt(String.valueOf(str.charAt(4)));



            if(compare=='='){
                if(Math.abs(map.get(p1)-map.get(p2))-1!=n) return false;
            }else if(compare=='>'){
                if(Math.abs(map.get(p1)-map.get(p2))-1<=n) return false;
            }else if(compare=='<'){
                if(Math.abs(map.get(p1)-map.get(p2))-1>=n) return false;
            }
        }

        return true;
    }
}