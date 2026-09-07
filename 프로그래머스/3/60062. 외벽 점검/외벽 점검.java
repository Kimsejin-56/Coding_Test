import java.util.*;

class Solution {
    static boolean[] visited;
    static int total;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        total = n;

        visited = new boolean[dist.length];

        for(int i = 0; i < dist.length; i++){
            answer = dfs(0, new int[i + 1], dist, weak);
            if(answer > 0) return answer;
        }

        return -1;
    }

    public int dfs(int depth, int[] p, int[] dist, int[] weak){
        if(depth == p.length){
            boolean[] arrive = new boolean[total];

            if(isAnswer(0, weak, p, arrive)) return p.length;
            else return 0;

        }else{
            for(int i = 0; i < dist.length; i++){
                if(!visited[i]){
                    p[depth] = dist[i];
                    visited[i] = true;

                    int n = dfs(depth + 1, p, dist, weak);

                    visited[i] = false;

                    if(n > 0) return n;
                }
            }
        }

        return 0;
    }

    public boolean isAnswer(int depth, int[] weak, int[] p, boolean[] param){
        if(depth == p.length){
            for(int i = 0; i < weak.length; i++){
                if(!param[weak[i]]) return false;
            }
            return true;
        }

        if(depth == 0){
            for(int i = 0; i < weak.length; i++){
                boolean[] arrive = Arrays.copyOf(param, total);

                int start = weak[i];
                int dis = start + p[depth];

                if(dis >= total){
                    for(int s = 0; s <= dis - total; s++){
                        arrive[s] = true;
                    }
                    dis = total - 1;
                }

                for(int s = start; s <= dis; s++){
                    arrive[s] = true;
                }

                if(isAnswer(depth + 1, weak, p, arrive)) return true;
            }

            return false;
        }

        int start = -1;

        for(int i = 0; i < weak.length; i++){
            if(!param[weak[i]]){
                start = weak[i];
                break;
            }
        }

        if(start == -1) return true;

        boolean[] arrive = Arrays.copyOf(param, total);

        int dis = start + p[depth];

        if(dis >= total){
            for(int s = 0; s <= dis - total; s++){
                arrive[s] = true;
            }
            dis = total - 1;
        }

        for(int s = start; s <= dis; s++){
            arrive[s] = true;
        }

        return isAnswer(depth + 1, weak, p, arrive);
    }
}