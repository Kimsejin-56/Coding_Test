import java.util.*;

class Solution {
    public List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> map=new HashMap<>();
        
        for(int i=0; i<info.length; i++){
            String[] arr=info[i].split(" ");
            dfs(0, arr, "", map);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for(int i=0; i<query.length; i++){
            String[] arr=query[i].split(" and ");
            String[] tmp=arr[3].split(" ");
            arr[3]=tmp[0];
            int score=Integer.parseInt(tmp[1]);
            
            String str="";
            for(int j=0; j<arr.length; j++){
                str+=arr[j]+" ";
            }
            
            if(map.get(str)==null) {
                answer.add(0);
                continue;
            }
            
            answer.add(binarySearch(map.get(str), score));
        }
        
        return answer;
    }
    
    public int binarySearch(List<Integer> list, int score){
        int lt=0;
        int rt=list.size();
        
        while(lt<rt){
            int mid=(lt+rt)/2;
            if(list.get(mid)<score) lt=mid+1;
            else rt=mid;
        }
        
        return list.size()-lt;
    }
    
    public void dfs(int depth, String[] arr, String str, Map<String, List<Integer>> map){
        if(depth==4){
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(Integer.parseInt(arr[depth]));
            return;
        }
       
        dfs(depth+1, arr, str+arr[depth]+" ", map);
        dfs(depth+1, arr, str+"- ", map);
    }
}