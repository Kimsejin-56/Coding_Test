import java.util.*;
class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited=new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && !visited[i][j]){
                    bfs(visited, computers, new Point(i, j));
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    public void bfs(boolean[][] visited, int[][] computers, Point cur){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur.x][cur.y]=true;
        
        while(!q.isEmpty()){
            Point p=q.poll();
            // System.out.println(p.x+" "+p.y);
            for(int i=0; i<computers.length; i++){
                if(computers[p.x][i]==1 && !visited[p.x][i]){
                    visited[p.x][i]=true;
                    q.offer(new Point(i, p.x));
                }
            }
        }
         // System.out.println();
    }
}