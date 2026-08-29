import java.util.*;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int n;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n=game_board.length;
        int[][] arr=new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j]==1) arr[i][j]=0;
                else arr[i][j]=1;
            }
        }
        
        List<int[][]> keys=extract(table);
        List<int[][]> board=extract(arr);
        
        boolean[] used=new boolean[board.size()];
        for(int i=0; i<keys.size(); i++){
            int tk[][]=keys.get(i);
            for(int j=0; j<board.size(); j++){
                int[][] tb=board.get(j);
                
                if(used[j]) continue;
                
                int cnt=same(tk, tb);
                if(cnt>0){
                    answer+=cnt;
                    used[j]=true;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public List<int[][]> extract(int[][] arr){
        List<List<Point>> list=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]) list.add(bfs(arr, new Point(i, j), visited));
            }
        }
        
        List<int[][]> pieces=new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            pieces.add(makeArr(list.get(i)));
        }
        
        return pieces;
    }
    
    public List<Point> bfs(int[][] arr, Point s, boolean[][] visited){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(s);
        visited[s.x][s.y]=true;
        List<Point> list=new ArrayList<>();
        list.add(s);
        
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int i=0; i<4; i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && arr[nx][ny]==1){
                    Point np=new Point(nx, ny);
                    q.offer(np);
                    visited[nx][ny]=true;
                    list.add(np);
                }
            }
        }
        
        return list;
    }
    
    public int[][] makeArr(List<Point> list){
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=0;
        int maxY=0;
        
        for(int i=0; i<list.size(); i++){
            Point p=list.get(i);
            minX=Math.min(minX, p.x);
            minY=Math.min(minY, p.y);
            maxX=Math.max(maxX, p.x);
            maxY=Math.max(maxY, p.y);
        }
        
        int[][] arr=new int[maxX-minX+1][maxY-minY+1];
        for(int i=0; i<list.size(); i++){
            Point p=list.get(i);
            arr[p.x-minX][p.y-minY]=1;
        }
            
        return arr;
    }
    
    public int same(int[][] tk, int[][] tb){
        boolean pass;
        int num=0;
        
        for(int l=0; l<4; l++){
            pass=false;
            
            if(tk.length == tb.length && tk[0].length==tb[0].length){
                for(int i=0; i<tk.length; i++){
                    for(int j=0; j<tk[0].length; j++){
                        if(tk[i][j]!=tb[i][j]){
                            pass=true;
                            num=0;
                            break;
                        }else if(tk[i][j]==1) num++;
                    }
                    if(pass) break;
                }
            }
            if(num>0) break;
            tk=rotate(tk);
        }
        
        return num; 
    }
    
    public int[][] rotate(int[][] tk){
        int r=tk.length;
        int c=tk[0].length;
        int[][] tmp=new int[c][r];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                tmp[j][r-i-1]=tk[i][j];
            }           
        }
        
        return tmp;
    }
}