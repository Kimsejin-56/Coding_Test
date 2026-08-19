import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int n,m;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        n=board.length;
        m=board[0].length();
        int[][] arr=new int[n][m];
        visited=new boolean[n][m];
        Point s=new Point(0, 0);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j)=='D') arr[i][j]=-1;
                else if(board[i].charAt(j)=='R'){
                    s.x=i;
                    s.y=j;
                }else if(board[i].charAt(j)=='G') arr[i][j]=4;
            }
        }

        answer=bfs(s, arr);

        return answer;
    }

    public int bfs(Point s, int[][] arr){
        Queue<Point> q=new ArrayDeque<>();
        int cnt=0;
        q.offer(s);
        visited[s.x][s.y]=true;

        while(!q.isEmpty()){
            int len=q.size();
            for(int l=0; l<len; l++){
                Point p=q.poll();
                if(arr[p.x][p.y]==4) return cnt;
                for(int i=0; i<4; i++){
                    Point move=forward(dx[i], dy[i], new Point(p.x, p.y), arr);

                    if(!visited[move.x][move.y]){
                        q.offer(move);
                        visited[move.x][move.y]=true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public Point forward(int x, int y, Point p, int[][] arr){
        while(true){
            int nx=p.x+x;
            int ny=p.y+y;

            if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]!=-1){
                p.x=nx;
                p.y=ny;
            }else break;
        }
        return p;
    }
}