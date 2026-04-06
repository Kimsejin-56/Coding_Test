
import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m, count, answer;
    static int[][] arr;
    static boolean[][] visited;
    static Point[] move;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Point> list = new ArrayList<>();

    static void dfs(int L, int s) {
        if(L==3){
            visited = new boolean[n][m];
            bfs(list);

            int cnt=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]==0 && !visited[i][j]) cnt++;
                }
            }

            answer = Math.max(answer, cnt);
            return;
        }
        for (int i = s; i < count; i++) {
            Point tmp = move[i];
            arr[tmp.x][tmp.y]=1;
            dfs(L+1, i+1);
            arr[tmp.x][tmp.y]=0;
        }
    }

    static void bfs(List<Point> point) {
        Queue<Point> q = new LinkedList<>();
        for(Point p : point) {
            q.offer(p);
            visited[p.x][p.y] = true;

        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==0) count++;
                if(arr[i][j]==2) list.add(new Point(i, j));
            }
        }

        move = new Point[count];
        int idx=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0) move[idx++] = new Point(i, j);
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

}
