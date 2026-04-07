

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
    static int n=10, answer;
    static int[][] board;
    static int[] used;
    static List<Point> papers = new ArrayList<>();


    static void dfs(int cnt) {
        if(cnt>=answer) return;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    Point tmp = new Point(i, j);
                    for (int k = 5; k >= 1; k--) {
                        if (canAttach(tmp, k)) {
                            if(used[k]>=5) continue;
                            attach(tmp, k, 0);
                            used[k]++;
                            dfs(cnt + 1);
                            used[k]--;
                            attach(tmp, k, 1);
                        }
                    }
                    return;
                }
            }
        }

        answer=Math.min(answer, cnt);
    }

    static void attach(Point p, int size, int value) {
        for (int i = p.x; i < p.x + size; i++) {
            for (int j = p.y; j < p.y + size; j++) {
                board[i][j] = value;
            }
        }
    }

    static boolean canAttach(Point p, int size) {
        if(p.x+size>10 || p.y+size>10) return false;
        for (int i = p.x; i < p.x + size; i++) {
            for (int j = p.y; j < p.y + size; j++) {
                if(board[i][j]!=1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j]==1) papers.add(new Point(i, j));
            }
        }

        answer = Integer.MAX_VALUE;
        used=new int[6];
        dfs(0);
        if(answer==Integer.MAX_VALUE) answer=-1;
        System.out.println(answer);
    }
}
