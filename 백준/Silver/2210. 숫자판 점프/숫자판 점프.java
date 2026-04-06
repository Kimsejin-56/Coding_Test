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
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int n=5;
    static Set<String> set = new HashSet<>();

    static void dfs(Point p, String str) {
        if(str.length()==6){
            set.add(str);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                String tmp = str;
                tmp += arr[nx][ny];
                dfs(new Point(nx, ny), tmp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(new Point(i, j), String.valueOf(arr[i][j]));
            }
        }

        System.out.println(set.size());
    }
}