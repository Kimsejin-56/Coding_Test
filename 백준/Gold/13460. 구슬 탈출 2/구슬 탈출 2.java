import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class State {
    int rx, ry, bx, by, cnt;

    public State(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

class MoveResult{
    int x,y,dist;
    boolean hole;

    public MoveResult(int x, int y, int dist, boolean hole) {
        this.x = x;
        this.y = y;
        this.dist=dist;
        this.hole = hole;
    }
}

public class Main {
    static int n, m, answer, rdis, bdis;
    static char[][] board;
    static Point R, B;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][][] visited;

    static int bfs(State state) {
        Queue<State> q = new LinkedList<>();
        q.offer(state);
        visited[state.rx][state.ry][state.bx][state.by] = true;

        while (!q.isEmpty()) {
            State s = q.poll();

            if (s.cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                MoveResult rm = move(s.rx, s.ry, i);
                MoveResult bm = move(s.bx, s.by, i);

                if(bm.hole) continue;
                if(rm.hole) return s.cnt+1;
                if(rm.x==bm.x && rm.y==bm.y){
                    if(rm.dist>bm.dist){
                        rm.x -= dx[i];
                        rm.y -= dy[i];
                    }else{
                        bm.x -= dx[i];
                        bm.y -= dy[i];
                    }
                }

                if(!visited[rm.x][rm.y][bm.x][bm.y]){
                    visited[rm.x][rm.y][bm.x][bm.y]=true;
                    q.offer(new State(rm.x, rm.y, bm.x, bm.y, s.cnt + 1));
                }
            }
        }
        return -1;
    }

    static MoveResult move(int x, int y, int dir) {
        int dist=0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(board[nx][ny]=='#') break;

            x = nx;
            y = ny;
            dist++;

            if(board[nx][ny]=='O') return new MoveResult(nx, ny, dist, true);

        }

        return new MoveResult(x, y, dist, false);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == 'R') {
                    R = new Point(i, j);
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    B = new Point(i, j);
                    board[i][j] = '.';
                }
            }
        }
        visited=new boolean[n][m][n][m];
        State state = new State(R.x, R.y, B.x, B.y, 0);
        System.out.println(bfs(state));

    }
}