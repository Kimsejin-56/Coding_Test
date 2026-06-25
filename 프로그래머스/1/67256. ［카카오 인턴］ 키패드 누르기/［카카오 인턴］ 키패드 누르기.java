import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] arr={{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1}};
        Point lt=new Point(3,0);
        Point rt=new Point(3,2);
                
        for(int i=0; i<numbers.length; i++){
            int n=numbers[i];
            
            for(int c=0; c<4; c++){
                for(int r=0; r<3; r++){
                    if(arr[c][r]==n){
                        if(r==0) {
                            answer+="L";
                            lt.x=c;
                            lt.y=r;
                        } else if(r==2) {
                            answer+="R";
                            rt.x=c;
                            rt.y=r;
                        } else if(r==1){
                            int disL=dist(lt, c, r);
                            int disR=dist(rt, c, r);
                            if(disL < disR){
                                answer+="L";
                                lt.x=c;
                                lt.y=r;
                            } else if(disL > disR){
                                answer+="R";
                                rt.x=c;
                                rt.y=r;
                            } else{
                                if(hand.equals("left")){
                                    answer+="L";
                                    lt.x=c;
                                    lt.y=r;
                                } else if(hand.equals("right")){
                                    answer+="R";
                                    rt.x=c;
                                    rt.y=r;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int dist(Point p, int x, int y){
        return Math.abs(x-p.x)+Math.abs(y-p.y);
    }
}