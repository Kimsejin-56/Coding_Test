import java.util.*;

class Solution {
    static Map<Integer, Integer> cnt;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        cnt=new HashMap<>();

        cnt.put(0, 0);
        cnt.put(1, 0);

        cutArr(arr.length, arr);
        
        answer[0]=cnt.get(0);
        answer[1]=cnt.get(1);

        return answer;
    }

    public void cutArr(int len, int[][] arr) {
        if(test(arr)) return;
        
        len/=2;
        int sx=0, sy=0;

        for(int l=0; l<4; l++){
            int[][] cut=new int[len][len];

            for(int i=0; i<len; i++){
                if(l==1 || l==3) sy=len;
                else sy=0;

                for(int j=0; j<len; j++){
                    cut[i][j]=arr[sx][sy];
                    sy++;
                }
                sx++;
            }

            if(l==0) sx=0;
            else if(l==2) sx=len;

            cutArr(len, cut);
        }
    }

    public boolean test(int[][] arr){
        int cnt0=0, cnt1=0;

        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j]==0) cnt0++;
                else cnt1++;
            }
        }

        //압축
        if(cnt0==0 || cnt1==0){
            if(cnt0!=0) cnt.put(0, cnt.get(0)+1);
            else cnt.put(1, cnt.get(1)+1);
            return true;
        }

        return false;
    }
}