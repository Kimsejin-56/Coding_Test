import java.util.*;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited=new boolean [11][11][11][11];
        Point cur=new Point(0,0);

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                visited[i][j][i][j]=true;
            }
        }

        for(int i=0; i<dirs.length(); i++) {
            char c=dirs.charAt(i);
            int x=cur.x+5;
            int y=cur.y+5;

            if(c=='U'){
                cur.y+=1;
            }else if(c=='D'){
                cur.y-=1;
            }else if(c=='R'){
                cur.x+=1;
            }else if(c=='L'){
                cur.x-=1;
            }

            if(cur.x<-5) cur.x=-5;
            else if(cur.x>5)cur.x=5;
            else if(cur.y<-5) cur.y=-5;
            else if(cur.y>5) cur.y=5;

            if(!visited[x][y][cur.x+5][cur.y+5]){
                visited[x][y][cur.x+5][cur.y+5]=true;
                visited[cur.x+5][cur.y+5][x][y]=true;
                answer++;
            }
        }

        return answer;
    }
}