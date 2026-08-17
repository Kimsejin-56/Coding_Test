import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static boolean[][] visited;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static int n, m;
    static boolean open;
    static Point exit, lever;
    static int[][] dis;
    
    public int solution(String[] maps) {
        int answer = 0;
        n=maps.length;
        m=maps[0].length();
        visited=new boolean[n][m];
        int[][] board=new int[n][m];
        open=false;
        dis=new int[n][m];
        Point start=new Point(0,0);
        
        for(int i=0; i<n; i++){
            String s=maps[i];
            for(int j=0; j<m; j++){
                if(s.charAt(j)=='X'){
                   board[i][j]=-1;   
                }else if(s.charAt(j)=='S'){
                   start.x=i;
                   start.y=j;
                }else if(s.charAt(j)=='E'){
                   exit=new Point(i, j); 
                }else if(s.charAt(j)=='L'){
                   board[i][j]=4;
                   lever=new Point(i, j);
                }
            }
        }
        
        bfs(board, start);
        if(!open) return -1;
        visited=new boolean[n][m];
        bfs(board, lever);
        
        if(dis[exit.x][exit.y]>0) answer=dis[exit.x][exit.y];
        else answer=-1;
        
        return answer;
    }
    
    public void bfs(int[][] board, Point s){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y]=true;
        
        while(!q.isEmpty()){
            Point p=q.poll();
            
            for(int i=0; i<4; i++){
                int nx=dx[i]+p.x;
                int ny=dy[i]+p.y;
                
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && board[nx][ny]!=-1){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx, ny));
                    
                    if(!open && board[nx][ny]==4) {
                        open=true;
                        q.clear();
                        dis[nx][ny]=dis[p.x][p.y]+1;
                        break;
                    }
                    
                    dis[nx][ny]=dis[p.x][p.y]+1;
                }
            }
        }
    }
}