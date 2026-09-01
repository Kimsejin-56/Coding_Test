import java.sql.SQLOutput;
import java.util.*;

class Point{
    int x,y,dir;
    public Point(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
}

class Solution {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};

    public int solution(int[][] board) {
        int answer = 0;
        int n=board.length;
        int c=0;
        int[][][] cost=new int[n][n][2];
        Queue<Point> q=new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        q.offer(new Point(0,0, 0));
        q.offer(new Point(0,0, 1));
        cost[0][0][0]=0;
        cost[0][0][1]=0;

        while(!q.isEmpty()){
            Point p=q.poll();
            for(int i=0; i<4; i++){
                c=100;
                int dir=p.dir;

                if(dx[i]!=0 && p.dir==0){
                    c+=500;
                    dir=1;
                } else if(dy[i]!=0 && p.dir==1){
                    c+=500;
                    dir=0;
                }
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                int cur=cost[p.x][p.y][p.dir]+c;

                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]!=1 && cur<cost[nx][ny][dir] ){
                    cost[nx][ny][dir]=cur;
                    q.offer(new Point(nx, ny, dir));

                }
            }
        }

        
        return Math.min(cost[n-1][n-1][0], cost[n-1][n-1][1]);
    }
}