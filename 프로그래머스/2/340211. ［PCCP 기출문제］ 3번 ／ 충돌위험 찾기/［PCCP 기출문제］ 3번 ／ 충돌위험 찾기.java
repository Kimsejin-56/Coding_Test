import java.util.*;

class Point{
    int x, y;
    List<int[]> exits=new ArrayList<>();
    boolean dead;
    int idx=0;
    
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<Point> ps=new ArrayList<>();
        List<Point> robots=new ArrayList<>();
        
        for(int[] arr : routes){
            int start=arr[0]-1;
            
            Point p=new Point(points[start][0], points[start][1]);
            robots.add(p);
            
            for(int i=1; i<arr.length; i++){
                int n=arr[i]-1;
                System.out.println(Arrays.toString(points[n]));
                p.exits.add(points[n]);
            }
            System.out.println();
        }
        
        answer+=crush(robots);
        
        while(exit(robots)){
            move(robots);
            answer+=crush(robots);
            dead(robots);
        }
        
        return answer;
    }
    
    public void move(List<Point> robots){
        for(Point p : robots){
            if(p.dead) continue;
            
            int min=getDis(p.x, p.y, p.exits.get(p.idx)[0], p.exits.get(p.idx)[1]);
            int idx=0;
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                int dis=getDis(nx, ny, p.exits.get(p.idx)[0], p.exits.get(p.idx)[1]);
                
                if(min>dis){
                    min=dis;
                    idx=i;
                }
            }
            
            p.x+=dx[idx];
            p.y+=dy[idx];
        }
    }
    
    public void dead(List<Point> robots){
        for(Point p : robots){
            if(p.dead) continue;
            
            if(p.x==p.exits.get(p.idx)[0] && p.y==p.exits.get(p.idx)[1]){
                p.idx++;
                if(p.exits.size()<=p.idx) p.dead=true;
            }
        }
    }
    
    public boolean exit(List<Point> robots){
        for(Point p : robots){
            if(!p.dead) return true;
        }
        return false;
    }

    public int crush(List<Point> robots){
        Map<String, Integer> map=new HashMap<>();
        int cnt=0;
        
        for(Point p : robots){
            if(p.dead) continue;
            
            String key=p.x+":"+p.y;
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key)>1) cnt++;
        }
        
        return cnt;
    }
    
    public int getDis(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}