import java.util.*;

class Point{
    int x, y;
    
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int answer, n, m;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static int[] oil;
    
    public int solution(int[][] land) {
        answer = 0;
        n=land.length;
        m=land[0].length;
        oil=new int[m];
        boolean[][] visited=new boolean[n][m];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(land[j][i]==0) continue;
                if(land[j][i]==1 && !visited[j][i]){
                    bfs(new Point(j, i), visited, land);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            answer=Math.max(answer, oil[i]);
        }
        
        return answer;
    }
    
    public void bfs(Point s, boolean[][] visited, int[][] land){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y]=true;
        int sum=1;
        Set<Integer> set=new HashSet<>();
        set.add(s.y);
        
        while(!q.isEmpty()){
            Point p=q.poll();
            
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && land[nx][ny]==1){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny]=true;
                    set.add(ny);
                    sum++;
                }
            }
        }
        
        for(int i : set){
            oil[i]+=sum;
        }
    }
}