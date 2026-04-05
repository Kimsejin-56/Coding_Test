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
    static int w, h, answer;
    static int[][] arr, dis, dist;
    static Point start;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Point> nodes;
    static int[] pm;
    static boolean[] v;

    static void initDis() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dis[i][j] = -1;
            }
        }
    }
    static void bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        initDis();
        q.offer(s);
        dis[s.y][s.x]=0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < w && ny < h && dis[ny][nx]==-1 && arr[ny][nx] != -1) {
                    q.offer(new Point(nx, ny));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
    }

    static boolean minDis() {
        List<Point> list = new ArrayList<>();
        list.add(start);
        list.addAll(nodes);
        int len = list.size();
        dist = new int[len][len];

        for (int i = 0; i < len; i++) {
            bfs(list.get(i));

            for (int j = 0; j < len; j++) {
                Point p = list.get(j);
                dist[i][j]=dis[p.y][p.x];
                if(dist[i][j]==-1)return false;
            }
        }

        return true;
    }

    static void dfs(int L){
        if(L==pm.length){
            int tmp=dist[0][pm[0]];
            for (int i = 0; i < pm.length - 1; i++) {
                tmp += dist[pm[i]][pm[i + 1]];
            }
            answer = Math.min(answer, tmp);
            return;
        }

        for (int i = 1; i <= pm.length; i++) {
            if (!v[i]) {
                v[i] = true;
                pm[L] = i;
                dfs(L+1);
                v[i] = false;
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) break;
            arr = new int[h][w];
            dis = new int[h][w];
            nodes = new ArrayList<>();
            String[] strs = new String[h];

            sc.nextLine();
            for (int i = 0; i < h; i++) strs[i] = sc.nextLine();

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    char c = strs[i].charAt(j);

                    if (c == '*') {
                        arr[i][j] = 1;
                        nodes.add(new Point(j, i));
                    } else if (c == '.') arr[i][j] = 0;
                    else if (c == 'x') arr[i][j] = -1;
                    else start = new Point(j, i);
                }
            }
            if(nodes.size()==0){
                System.out.println(0);
                continue;
            }
            answer = Integer.MAX_VALUE;
            if(!minDis()){
                System.out.println(-1);
                continue;
            }

            pm = new int[nodes.size()];
            v = new boolean[pm.length + 1];
            dfs(0);
            System.out.println(answer);
        }
    }
}