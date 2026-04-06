

import java.util.Scanner;

public class Main {
    static boolean[][] arr;
    static int N, H, M;
    static int answer = 4;

    static void dfs(int s, int count) {
        if(count>=answer) return;
        if(isAvailable()){
            answer = count;
            return;
        }
        if(count==3) return;

        for (int i = s; i <= H * (N - 1); i++) {
            int h = (i - 1) % H + 1;
            int row = (i - 1) / H + 1;

            if(!check(h,row)) continue;

            arr[h][row] = true;
            dfs(i + 1, count + 1);
            arr[h][row] = false;
        }
    }


    static boolean check(int h, int row) {
        if (arr[h][row]) return false;
        if(row>1 && arr[h][row - 1]) return false;
        if(row<N-1 && arr[h][row+1]) return false;
        return true;
    }

    static boolean isAvailable() {
        for (int i = 1; i <= N; i++) {
            int row = i;

            for (int j = 1; j <= H; j++) {
                if(row<N  && arr[j][row]){
                    row++;
                }else if(row>1 && arr[j][row-1]){
                    row--;
                }
            }
            if(row!=i) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        arr = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            arr[sc.nextInt()][sc.nextInt()] = true;
        }

        dfs(1, 0);

       if(answer==4) answer = -1;
       System.out.println(answer);
    }
}
