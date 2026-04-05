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
    static int n,m, k;
    static int[][] arr;
    static Point[] rec;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        arr[p.y][p.x]=1;

        int count=1;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[ny][nx] == 0) {
                    q.offer(new Point(nx, ny));
                    arr[ny][nx]=1;
                    count++;
                }
            }
        }
        return count;
    }

    static void  fill() {
        for (int i = 0; i < 2*k; i+=2) {
            Point tmp1 = rec[i];
            Point tmp2 = rec[i+1];
            int n1=tmp2.x-tmp1.x;
            int n2=tmp2.y-tmp1.y;
            for(int j=tmp1.y; j<tmp1.y+n2; j++){
                for (int l = tmp1.x; l < tmp1.x + n1; l++) {
                    arr[j][l]=-1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        arr=new int[m][n];
        visited=new boolean[m][n];
        rec=new Point[k*2];
        for (int i = 0; i < k*2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            rec[i]=new Point(x, y);
        }
        fill();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==0){
                    int val=bfs(new Point(j, i));
                    list.add(val);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list) System.out.print(i+" ");
    }
}