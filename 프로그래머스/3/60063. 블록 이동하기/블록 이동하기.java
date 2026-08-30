import java.util.*;

class Point{
    int x, y, dir;
    public Point(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
}

class Solution {
    static boolean[][][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n=board.length;
        visited=new boolean[n][n][2];
        
        answer=bfs(board, new Point(0,0,0), n);
        
        return answer;
    }
    
    public int bfs(int[][] board, Point s, int n){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y][s.dir]=true;
        int cnt=0;
        
        while(!q.isEmpty()){
            int len=q.size();
            for(int l=0; l<len; l++){
                Point p=q.poll();
                if(p.dir==0){
                    if(p.x==n-1 && p.y+1==n-1) return cnt;
                }else{
                    if(p.x+1==n-1 && p.y==n-1) return cnt;
                }
                
                for(int i=0; i<4; i++){
                    int nx=p.x+dx[i];
                    int ny=p.y+dy[i];
                    int nx2=nx;
                    int ny2=ny;
                    
                    if(p.dir==0) ny2++;
                    else nx2++;
                    
                    if(nx>=0 && ny>=0 && nx<n && ny<n && nx2>=0 && ny2>=0 && nx2<n && ny2<n 
                       && board[nx][ny]==0 && board[nx2][ny2]==0 
                       && !visited[nx][ny][p.dir]){
                        q.offer(new Point(nx, ny, p.dir));
                        visited[nx][ny][p.dir]=true;
                    }
                }
                
                //회전 로직
                if(p.dir==0){
                    if(p.x+1<n && board[p.x+1][p.y]==0 && board[p.x+1][p.y+1]==0){
                        if(!visited[p.x][p.y][1]){
                            q.offer(new Point(p.x, p.y, 1));
                            visited[p.x][p.y][1]=true;
                        }
                        if(!visited[p.x][p.y+1][1]){
                            q.offer(new Point(p.x, p.y+1, 1));
                            visited[p.x][p.y+1][1]=true;
                        }
                    }
                    
                    if(p.x-1>=0 && board[p.x-1][p.y]==0 && board[p.x-1][p.y+1]==0){
                        if(!visited[p.x-1][p.y][1]){
                            q.offer(new Point(p.x-1, p.y, 1));
                            visited[p.x-1][p.y][1]=true;
                        }
                        if(!visited[p.x-1][p.y+1][1]){
                            q.offer(new Point(p.x-1, p.y+1, 1));
                            visited[p.x-1][p.y+1][1]=true;
                        }
                    }
                }else {
                    if(p.y+1<n && board[p.x][p.y+1]==0 && board[p.x+1][p.y+1]==0){
                        if(!visited[p.x][p.y][0]){
                            q.offer(new Point(p.x, p.y, 0));
                            visited[p.x][p.y][0]=true;
                        }
                        if(!visited[p.x+1][p.y][0]){
                            q.offer(new Point(p.x+1, p.y, 0));
                            visited[p.x+1][p.y][0]=true;
                        }
                    }
                    
                    if(p.y-1>=0 && board[p.x][p.y-1]==0 && board[p.x+1][p.y-1]==0){
                        if(!visited[p.x][p.y-1][0]){
                            q.offer(new Point(p.x, p.y-1, 0));
                            visited[p.x][p.y-1][0]=true;
                        }
                        if(!visited[p.x+1][p.y-1][0]){
                            q.offer(new Point(p.x+1, p.y-1, 0));
                            visited[p.x+1][p.y-1][0]=true;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}