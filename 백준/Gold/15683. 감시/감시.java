import java.util.*;

class Point{
    int x;
    int y;
    int num;

    public Point(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main {
    static int n, m, answer;
    static int[] caseCount = {4, 2, 4, 4, 1};
    static int[][] arr;
    static boolean[][] visited;
    static List<Point> list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] choice;
    static int[][][] typeDir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}}
    };

    static void dfs(int L) {
        if (L == list.size()) {
            simulation();
            return;
        }

        Point p = list.get(L);
        int count = caseCount[p.num - 1];

        for (int i = 0; i < count; i++) {
            choice[L] = i;
            dfs(L + 1);
        }

    }

    static void simulation() {
        visited=new boolean[n][m];

        for (int i = 0; i < list.size(); i++) {
            Point cctv = list.get(i);
            int type = cctv.num;
            int[] dirs=typeDir[type][choice[i]];
            for (int dir : dirs) {
                watch(cctv, dir);
            }
        }

        int blind=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    blind++;
                }
            }
        }

        answer = Math.min(answer, blind);
    }

    static void watch(Point cctv, int dir) {
        int nx = cctv.x + dx[dir];
        int ny = cctv.y + dy[dir];
        while (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 6) {
            visited[nx][ny] = true;
            nx = nx + dx[dir];
            ny = ny + dy[dir];
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
                if(arr[i][j]!=0 && arr[i][j]!=6) list.add(new Point(i, j, arr[i][j]));
            }
        }

        answer = Integer.MAX_VALUE;
        //cctv 방향 선택 배열
        choice = new int[list.size()];
        dfs(0);
        System.out.println(answer);
    }
}
