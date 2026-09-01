import java.util.*;

class Solution {
    static boolean[][][] visited;
    static char[][] arr;
    static int n,m;

    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        n= grid.length;;
        m=grid[0].length();
        arr=new char[n][m];
        visited=new boolean[n][m][4];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=grid[i].charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<4; k++){

                    if(visited[i][j][k]) continue;

                    list.add(move(i, j, k));
                }
            }
        }
        
        Collections.sort(list);
        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }

        return answer;
    }

    public int move(int x, int y, int dir){
        int cnt=0;

        while(!visited[x][y][dir]){
            visited[x][y][dir]=true;
            cnt++;

            if(arr[x][y]=='S'){
                if(dir==0){
                    y++;
                    if(y==m) y=0;
                }else if(dir==1){
                    x++;
                    if(x==n) x=0;
                }else if(dir==2){
                    y--;
                    if(y<0) y=m-1;
                }else {
                    x--;
                    if(x<0) x=n-1;
                }
            }else if(arr[x][y]=='L'){
                if(dir==0){
                    x--;
                    dir=3;
                    if(x<0) x=n-1;
                }else if(dir==1){
                    y++;
                    dir=0;
                    if(y==m) y=0;
                }else if(dir==2){
                    x++;
                    dir=1;
                    if(x==n) x=0;
                }else {
                    y--;
                    dir=2;
                    if(y<0) y=m-1;
                }
            }else if(arr[x][y]=='R'){
                if(dir==0){
                    x++;
                    dir=1;
                    if(x==n) x=0;
                }else if(dir==1){
                    y--;
                    dir=2;
                    if(y<0) y=m-1;
                }else if(dir==2){
                    x--;
                    dir=3;
                    if(x<0) x=n-1;
                }else {
                    y++;
                    dir=0;
                    if(y==m) y=0;
                }
            }
        }

        return cnt;
    }
}