import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int max = 0;
        int idx = 0;
        int start, end;
        int arr[][]=new int[2][2];
        Set<String> set = new HashSet<>();

      
        for(int i=0; i<3; i++){
            int num = lines[i][1]-lines[i][0];
            if(max < num){
                max = num;
                idx = i;
            }
        }
        
        start=lines[idx][0];
        end=lines[idx][1];
        int cnt=0;
        for(int i=0; i<3; i++){
            if(idx==i) continue;
            arr[cnt++]=lines[i];
            for(int j=lines[i][0]; j<lines[i][1]; j++){
                if(start<=j && j<=end){
                    if(j+1 <= end){
                        int tmp=j+1;
                        set.add("["+ j +","+ tmp +"]");
                    }
                }
            }
        }
        
        System.out.println(Arrays.deepToString(arr));
        
        start=arr[1][0];
        end=arr[1][1];
        for(int i=arr[0][0]; i<arr[0][1]; i++){
            if(start<=i && i<=end){
                if(i+1 <= end){
                    int tmp=i+1;
                    set.add("["+ i +","+ tmp +"]");
                }
            }
        }
        
        System.out.println(set);
        answer=set.size();
        return answer;
    }
}