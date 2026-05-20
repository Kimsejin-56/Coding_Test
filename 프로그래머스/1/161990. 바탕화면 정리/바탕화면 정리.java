import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer> col= new ArrayList<>();
        List<Integer> row= new ArrayList<>();
        
        for(int i=0; i<wallpaper.length; i++){
            String str=wallpaper[i];
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='#') {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        
        Collections.sort(col);
        Collections.sort(row);
        
        answer[0]=row.get(0);
        answer[1]=col.get(0);
        answer[2]=row.get(row.size()-1)+1;
        answer[3]=col.get(col.size()-1)+1;
        
        return answer;
    }
}