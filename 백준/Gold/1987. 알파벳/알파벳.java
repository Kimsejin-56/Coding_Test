

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
    static int r, c, answer;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[] alpha = new boolean[26];

    static void dfs(int L, Point p) {
        alpha[arr[p.x][p.y] - 'A'] = true;
        answer = Math.max(answer, L);

        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !alpha[arr[nx][ny]-'A']) {
                dfs(L + 1, new Point(nx, ny));
                alpha[arr[nx][ny] - 'A'] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new char[r][c];

        sc.nextLine();
        for (int i = 0; i < r; i++) {
            String tmp=sc.nextLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] =tmp.charAt(j);
            }
        }

        dfs(1, new Point(0, 0));
        System.out.println(answer);
    }
}
