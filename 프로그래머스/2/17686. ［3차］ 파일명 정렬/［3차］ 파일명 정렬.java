import java.util.*;

class File implements Comparable<File>{
    int idx;
    String head;
    int number;
    
    public File(int idx, String head, int number){
        this.idx=idx;
        this.head=head;
        this.number=number;
    }
    
    public int compareTo(File f){
        if(this.head.equals(f.head)) {
            if(this.number==f.number) return this.idx-f.idx;  
            return this.number-f.number;
        }
        return this.head.compareTo(f.head);
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list=new ArrayList<>();
        
        for(int l=0; l<files.length; l++){
            String str=files[l];
            int len=str.length();
            String s="";
            String h="";
            
            //head 구하기
            for(int i=0; i<len; i++){
                if(Character.isDigit(str.charAt(i))) break;
                else h+=str.charAt(i);
            }
            int start=h.length();
            
            //number 구하기
            for(int i=start; i<len; i++){
                if(Character.isDigit(str.charAt(i))) s+=str.charAt(i);
                else break;
            }
            
            list.add(new File(l, h.toLowerCase(), Integer.parseInt(s)));
        }
        Collections.sort(list);
        for(int i=0; i<answer.length; i++){
            answer[i]=files[list.get(i).idx];
        }
        
        return answer;
    }
}