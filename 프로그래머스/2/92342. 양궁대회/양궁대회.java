import java.util.*;

class Solution {
    static int[] arr;
    static List<int[]> list;
    static int me, you, answer;
    public int[] solution(int n, int[] info) {
        answer=1;
        list=new ArrayList<>();
        arr=new int[11];
        dfs(0, n, info);
        
        if(list.size()==0){
            int[] tmp=new int[1];
            tmp[0]=-1;
            return tmp;
        } else if(list.size() > 1){
            for(int i=10; i>=0; i--){
                int max=0;
                for(int j=0; j<list.size(); j++){
                    max=Math.max(max, list.get(j)[i]);
                }
                
                for(int j=0; j<list.size(); j++){
                    if(max!=list.get(j)[i]) {
                        list.remove(j);
                        j--;
                    }
                }
                if(list.size()==1) break;
            }
        }
        
        return list.get(0);
    }
    
    public void dfs(int idx, int remain, int[] info){
        if(idx==11) {
            me=0;
            you=0;
            for(int i=0; i<=10; i++){
                if(info[i]==0 && arr[i]==0) continue;
                if(info[i] < arr[i]) me+=10-i;
                else you+=10-i;
            }
            int diff=me-you;
            
            if(answer < diff){
                answer=diff;
                list.clear();
                list.add(Arrays.copyOf(arr, arr.length));
            } else if(answer==diff) list.add(Arrays.copyOf(arr, arr.length));
            return;
        } 
        for(int i=0; i<=remain; i++){
            arr[idx]=i;
            dfs(idx+1, remain-i, info);
        }
    }
}