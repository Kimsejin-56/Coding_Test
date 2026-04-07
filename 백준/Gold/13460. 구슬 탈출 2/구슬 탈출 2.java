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

public class Main {
    static int n, m, answer, rdis, bdis;
    static char[][] board;
    static Point R, B;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][][] visited;

    static void bfs(State state) {
        Queue<State> q = new LinkedList<>();
        q.offer(state);
        visited[state.rx][state.ry][state.bx][state.by] = true;

        while (!q.isEmpty()) {
            State s = q.poll();

            if (s.cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                rdis = 0;
                bdis = 0;

                int rnx = s.rx + dx[i];
                int rny = s.ry + dy[i];
                int bnx = s.bx + dx[i];
                int bny = s.by + dy[i];

                State tmp = new State(s.rx, s.ry, s.bx, s.by, s.cnt + 1);

                if (rnx >= 0 && rny >= 0 && rnx < n && rny < m && board[rnx][rny] != '#') {
                    rdis++;
                    while (board[rnx][rny] == '.' && (board[rnx + dx[i]][rny + dy[i]] == '.' || board[rnx + dx[i]][rny + dy[i]] == 'O')) {
                        rnx += dx[i];
                        rny += dy[i];
                        rdis++;
                    }
                    tmp.rx = rnx;
                    tmp.ry = rny;
                }

                if (bnx >= 0 && bny >= 0 && bnx < n && bny < m && board[bnx][bny] != '#') {
                    bdis++;
                    while (board[bnx][bny] == '.' && (board[bnx + dx[i]][bny + dy[i]] == '.' || board[bnx + dx[i]][bny + dy[i]] == 'O')) {
                        bnx += dx[i];
                        bny += dy[i];
                        bdis++;
                    }
                    tmp.bx = bnx;
                    tmp.by = bny;
                }

                if (board[tmp.bx][tmp.by] == 'O') {
                    continue;
                }

                if (board[tmp.rx][tmp.ry] == 'O') {
                    answer = tmp.cnt;
                    return;
                }

                if (tmp.rx == tmp.bx && tmp.ry == tmp.by) {
                    if (rdis > bdis) {
                        tmp.rx -= dx[i];
                        tmp.ry -= dy[i];
                    } else {
                        tmp.bx -= dx[i];
                        tmp.by -= dy[i];
                    }
                }
                if (!visited[tmp.rx][tmp.ry][tmp.bx][tmp.by]) {
                    q.offer(tmp);
                    visited[tmp.rx][tmp.ry][tmp.bx][tmp.by]=true;
                }
            }
        }

        answer=-1;
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
        bfs(state);

        System.out.println(answer);
    }
}