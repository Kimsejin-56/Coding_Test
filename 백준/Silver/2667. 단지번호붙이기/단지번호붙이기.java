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
    static int n, count;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visited[point.x][point.y] = false;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    count++;
                    visited[nx][ny] = false;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> list = new ArrayList<>();
        String[] str = new String[n];

        sc.nextLine();
        for (int i = 0; i < n; i++) str[i] = sc.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str[i].charAt(j)));
                if(arr[i][j]==1) visited[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count=1;
                if(visited[i][j]) list.add(bfs(new Point(i, j)));
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }
}