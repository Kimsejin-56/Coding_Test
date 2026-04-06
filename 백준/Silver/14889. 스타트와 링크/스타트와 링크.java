import java.util.*;

public class Main {
    static int [][] arr;
    static int n, answer;
    static int[] pm;
    static int[] rest;
    static boolean[] players;

    static void dfs(int L, int s) {
        if (L == n / 2) {
            int idx = 0;
            for (int i = 1; i <= n; i++) {
                if (!players[i]) rest[idx++] = i;
            }
            int start = 0, link = 0;

            for (int i = 1; i <= n / 2 - 1; i++) {
                for (int j = i + 1; j <= n / 2; j++) {
                    start += arr[pm[i-1]][pm[j-1]];
                    link += arr[rest[i-1]][rest[j-1]];
                    start += arr[pm[j-1]][pm[i-1]];
                    link += arr[rest[j-1]][rest[i-1]];
                }
            }
            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        for (int i = s; i <= n; i++) {
            pm[L] = i;
            players[i] = true;
            dfs(L + 1, i + 1);
            players[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer=Integer.MAX_VALUE;

        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        pm = new int[n / 2];
        rest = new int[n / 2];
        players = new boolean[n + 1];
        dfs(0, 1);
        System.out.println(answer);
    }
}
