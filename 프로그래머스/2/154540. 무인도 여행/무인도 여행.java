import java.util.*;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static boolean[][] visited;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};
    static int n, m;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        n=maps.length;
        m=maps[0].length();
        String[][] arr=new String[n][m];
        visited=new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=String.valueOf(maps[i].charAt(j));
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!arr[i][j].equals("X") && !visited[i][j]) list.add(bfs(new Point(i, j), arr));
            }
        }
        
        if(list.isEmpty()) {
            int[] tmp=new int[1];
            tmp[0]=-1;
            return tmp;
        }
        Collections.sort(list);
        
        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        
        return answer;
    }
    
    public int bfs(Point s, String[][] arr){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y]=true;
        int total=Integer.parseInt(arr[s.x][s.y]);
        
        while(!q.isEmpty()){
            Point p=q.poll();
            
            for(int i=0; i<4; i++){
                int nx=dx[i]+p.x;
                int ny=dy[i]+p.y;
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && !arr[nx][ny].equals("X")){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx, ny));
                    total+=Integer.parseInt(arr[nx][ny]);
                }
            }
        }
        
        System.out.println(total);
        return total;
    }
}