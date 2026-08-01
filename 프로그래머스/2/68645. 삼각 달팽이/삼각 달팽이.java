import java.util.*;

class Solution {
    static int num, x, y;
    public int[] solution(int n) {
        int len=0;
        int[][] arr=new int[n][n];
        num=1;
        x=0;
        y=n-1;

        List<int[]> list=new ArrayList<>();
        for(int i=1; i<=n; i++) {
            len+=i;
            list.add(new int[i]);
        }
        int[] answer = new int[len];

        for(int i=0; i<=n/3; i++){
            arr=dir1(arr, n-3*i);
            if(num>len) break;
            arr=dir2(arr, n-3*i);
            if(num>len) break;
            arr=dir3(arr, n-3*i);
            if(num>len) break;
        }

        num=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]!=0) answer[num++]=arr[i][j];
            }
        }

        return answer;
    }

    public int[][] dir1(int[][]arr, int n){
        for(int i=0; i<n; i++){
            if(i!=n-1) arr[x++][y--]=num++;
            else arr[x][y]=num++;
        }
        y++;
        return arr;
    }

    public int[][] dir2(int[][]arr, int n){
        for(int i=0; i<n-1; i++){
            if(i!=n-2) arr[x][y++]=num++;
            else arr[x][y]=num++;
        }
        x--;
        return arr;
    }

    public int[][] dir3(int[][]arr, int n){
        for(int i=0; i<n-2; i++){
            if(i!=n-3) arr[x--][y]=num++;
            else arr[x][y]=num++;
        }
        x++;
        y--;
        return arr;
    }
}