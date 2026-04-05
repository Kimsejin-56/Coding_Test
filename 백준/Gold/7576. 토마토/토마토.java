import java.util.*;
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m;
    static int[][] arr;
    static List<Point> list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        for(Point p : list) q.offer(p);
        int L=-1;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        arr[nx][ny] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) return -1;
            }
        }

        return L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==1) list.add(new Point(i, j));
            }
        }
        System.out.println(bfs());
    }
}
