import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}


class Solution {
    static int[][] board;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] visited=new boolean[101][101];
        board=new int[101][101];
        
        for(int i=0; i<rectangle.length; i++){
            int row=(rectangle[i][2]-rectangle[i][0])*2;
            int col=(rectangle[i][3]-rectangle[i][1])*2;
            
            for(int c=0; c<=col; c++){
                for(int r=0; r<=row; r++){
                    board[rectangle[i][1]*2+c][rectangle[i][0]*2+r]=1;
                }
            }
        }
        
        for(int i=0; i<rectangle.length; i++){
            int row=(rectangle[i][2]-rectangle[i][0])*2;
            int col=(rectangle[i][3]-rectangle[i][1])*2;
            
            for(int c=1; c<=col-1; c++){
                for(int r=1; r<=row-1; r++){
                    board[rectangle[i][1]*2+c][rectangle[i][0]*2+r]=0;
                }
            }
        
        }
        
        answer=bfs(visited, new Point(characterX*2, characterY*2), new Point(itemX*2, itemY*2));
        
        return answer;
    }
    
    
    public int bfs(boolean[][] visited, Point start, Point end){
        Queue<Point> q=new ArrayDeque<>();
        q.offer(start);
        visited[start.y][start.x]=true;
        
        int turn=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int l=0; l<len; l++){
                Point p=q.poll();
                for(int i=0; i<4; i++){
                    int nx=p.x+dx[i];
                    int ny=p.y+dy[i];
                    if(nx>=0 && nx<101 && ny>=0 && ny<101 && !visited[ny][nx] && board[ny][nx]==1){
                        visited[ny][nx]=true;
                        if(end.x==nx && end.y==ny) return (turn+1)/2;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            turn++;
        }
        
        return 0;
    }
}
