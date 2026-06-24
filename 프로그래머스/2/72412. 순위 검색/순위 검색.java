import java.util.*;

class Solution {
    public List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> score = new HashMap<>();
        
        for(int i=0; i<info.length; i++){
            String str=info[i];
            int sc=Integer.parseInt(str.substring(str.lastIndexOf(" ")+1));
            str=str.substring(0, str.lastIndexOf(" "));
            String[] arr=str.split(" ");
            
            makeKey(map, arr, 0, "", sc);
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        
        for(int i=0; i<query.length; i++){
            String str=query[i];
            int sc=Integer.parseInt(str.substring(str.lastIndexOf(" ")+1));
            str=str.substring(0,str.lastIndexOf(" "));
            String [] qarr=str.split(" and ");
            
            String key=qarr[0]+" "+qarr[1]+" "+qarr[2]+" "+qarr[3];
            List<Integer> list=map.getOrDefault(key, new ArrayList<>());
            int idx = binarySearch(list, sc);
            
            answer.add(list.size() - idx);
        }
        
        return answer;
    }
    
    public void makeKey(Map<String, List<Integer>> map, String[] arr, int depth, String key, int score) {
        if (depth == 4) {
            key = key.trim();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }

        makeKey(map, arr, depth + 1, key + arr[depth] + " ", score);
        makeKey(map, arr, depth + 1, key + "- ", score);
    }
    
    public int binarySearch(List<Integer> list, int target){
        int lt=0;
        int rt=list.size();
        
        while(lt<rt){
            int mid=(lt+rt)/2;
            if(list.get(mid) < target){
                lt=mid+1;
            }else{
                rt=mid;
            }
        }
        
        return lt;
    }
}