import java.util.*;

class Point {
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static int n,m;
    static Map<Integer, List<Integer>> map;

    public int solution(int[][] land) {
        int answer = 0;
        n=land.length;
        m=land[0].length;
        boolean[][] visited=new boolean[n][m];
        map=new HashMap<>();

        for(int i=0; i<m; i++) map.put(i, new ArrayList<>());


        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(land[i][j]==1 && !visited[i][j]) bfs(new Point(i, j), land, visited);
            }
        }

        for(int i=0; i<m; i++){
            int sum=0;
            for(int y : map.get(i)) sum+=y;
            answer=Math.max(answer, sum);
        }

        return answer;
    }

    public void bfs(Point s, int[][] land, boolean[][] visited){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y]=true;
        int cnt=1;
        Set<Integer> set=new HashSet<>();
        set.add(s.y);

        while(!q.isEmpty()){
            Point p=q.poll();
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && land[nx][ny]==1){
                    visited[nx][ny]=true;
                    cnt++;
                    set.add(ny);
                    q.offer(new Point(nx, ny));
                }
            }
        }

        for(int i : set) map.get(i).add(cnt);
    }
}