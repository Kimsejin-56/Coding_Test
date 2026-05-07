import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static boolean[][] visited;
    static int[][] dis;
    static int n,m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n=maps.length;
        m=maps[0].length;
        visited=new boolean[n][m];
        dis=new int[n][m];
        
        bfs(maps, new Point(0,0));
        
        if(dis[n-1][m-1]>0) answer=dis[n-1][m-1];
        else if(dis[n-1][m-1]==0) answer=-1;
        
        return answer;
    }
    
    public void bfs(int[][] maps, Point start){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y]=true;
        dis[start.x][start.y]=1;
        
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[p.x][p.y] + 1;
                }
            }
        }
    }
}