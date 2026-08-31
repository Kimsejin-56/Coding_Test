import java.util.*;

class Point{
    int num, index, x,y,gx,gy;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<Point> p=new ArrayList<>();
        List<Point> s=new ArrayList<>();
        Map<String, Integer> cnt=new HashMap<>();

        for(int i=0; i<points.length; i++){
            p.add(new Point(points[i][0], points[i][1]));
        }

        for(int i=0; i<routes.length; i++){
            int[] tmp=routes[i];
           Point cur=new Point(p.get(tmp[0]-1).x, p.get(tmp[0]-1).y);
           Point g=p.get(tmp[1]-1);
           cur.gx=g.x;
           cur.gy=g.y;
           cur.num=i;
           cur.index=1;
           s.add(cur);
        }

        for (int j = 0; j < s.size(); j++) {
            Point p1 = s.get(j);
            for (int k = 0; k < s.size(); k++) {
                if (j == k) continue;
                Point p2 = s.get(k);
                if (p1.x == p2.x && p1.y == p2.y) {
                    cnt.put(p1.x + ":" + p1.y, 0);
                }
            }
        }
        answer+=cnt.size();
        cnt.clear();

        while(!s.isEmpty()) {
            for (int i = 0; i <s.size(); i++) {
                Point start = s.get(i);

                for (int j = 0; j < 4; j++) {
                    int nx = start.x + dx[j];
                    int ny = start.y + dy[j];

                    if (getDis(nx, ny, start.gx, start.gy) < getDis(start.x, start.y, start.gx, start.gy)) {
                        start.x = nx;
                        start.y = ny;
                        break;
                    }
                }
            }

            for (int j = 0; j < s.size(); j++) {
                Point p1 = s.get(j);
                for (int k = 0; k < s.size(); k++) {
                    if (j == k) continue;
                    Point p2 = s.get(k);
                    if (p1.x == p2.x && p1.y == p2.y) {
                        cnt.put(p1.x + ":" + p1.y, 0);
                    }
                }
            }

            answer+=cnt.size();
            cnt.clear();

            for(int j=0; j<s.size(); j++){
                Point ps=s.get(j);
                if(ps.x==ps.gx && ps.y==ps.gy) {
                    ps.index++;
                    
                    if(ps.index==routes[ps.num].length){
                        s.remove(ps);
                        j--;
                    }else {
                        ps.gx=p.get(routes[ps.num][ps.index]-1).x;
                        ps.gy=p.get(routes[ps.num][ps.index]-1).y;
                    }
                }
            }
        }

        return answer;
    }

    public int getDis(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
}