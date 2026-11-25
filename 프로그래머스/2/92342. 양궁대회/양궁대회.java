import java.util.*;

class Solution {
    static List<int[]> list;
    static int max;
    
    public int[] solution(int n, int[] info) {
        list=new ArrayList<>();
        max=Integer.MIN_VALUE;
        
        dfs(0, 0, new int[11], n, info);
        
        if(max<=0) return new int[] {-1};
        if(list.size()==1) return list.get(0);
        
        int [] max=list.get(0);
        for(int i=1; i<list.size(); i++){
            if(isBetter(max, list.get(i))){
                max=list.get(i);
            }
        }
        
        return max;
    }

    public void dfs(int depth, int start, int[] arr, int n, int[] info){
        if(depth==n){
            int cur=calc(arr, info);
            if(max<cur){
                max=cur;
                list.clear();
                list.add(arr.clone());
            }else if(max==cur) list.add(arr.clone());
        }else {
            for(int i=start; i<11; i++){
                arr[i]++;
                dfs(depth+1, i, arr, n, info);
                arr[i]--;
            }
        }
    }
    
    public int calc(int[] arr, int[] info){
        int my=0;
        int you=0;
        
        for(int i=0; i<11; i++){
            if(arr[i]==0 && info[i]==0) continue;
            
            if(arr[i]>info[i]) my+=10-i;
            else you+=10-i;
        }
        
        return my-you;
    }
    
    public boolean isBetter(int[] max, int[] cur){
        for(int i=10; i>=0; i--){
            if(max[i]!=cur[i]) return max[i]<cur[i];
        }
        
        return false;
    }
}