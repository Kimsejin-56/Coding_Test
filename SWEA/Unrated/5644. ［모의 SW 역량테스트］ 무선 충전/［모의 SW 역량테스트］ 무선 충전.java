import java.util.*;
import java.io.FileInputStream;

class Point{
   	int x;
    int y;
    int c;
    int p;
    
    public Point(int x, int y, int c, int p){
        this.x=x;
        this.y=y;
        this.c=c;
        this.p=p;
    }
}
   


class Solution
{
    static int m, a;
    static int[] userA, userB;
    static int[][] arr;
    static List<Point> list;
    
    public static int solution(){
        int answer=0;
     	Point A= new Point(1,1,0,0);
        Point B= new Point(10,10,0,0);
        
        //초기 위치 검사
        int temp=0;
        for(Point poA :  range(A.x,A.y)){
              	for(Point poB : range(B.x,B.y)){
                 	if(poA.p == poB.p && poA.x==poB.x && poA.y==poB.y && poA.c==poB.c){
                     	temp=Math.max(temp, poA.p/2 + poB.p/2);   
                    }else {
                    	temp=Math.max(temp, poA.p+poB.p);   
                    }
                }
             }
        
        for(Point po : range(A.x,A.y)) temp=Math.max(temp, po.p);
        for(Point po : range(B.x,B.y)) temp=Math.max(temp, po.p);
        
        answer+=temp;
        
         for(int i=0; i<m; i++){
                
             //A 검사
             if(userA[i] ==1){
                A.y--;
            } else if(userA[i] ==2){
                A.x++;
            } else if(userA[i] ==3){
                A.y++;
            } else if(userA[i] ==4){
                A.x--;
            }
            
            //B검사
           	if(userB[i] ==1){
                B.y--;
            } else if(userB[i] ==2){
                B.x++;
            } else if(userB[i] ==3){
                B.y++;
            } else if(userB[i] ==4){
                B.x--;
            }  
           
            List<Point> tmpA = range(A.x, A.y);
            List<Point> tmpB = range(B.x, B.y);
            
             int max=0;
             //2개다 존재하는 경우
             for(Point poA : tmpA){
              	for(Point poB : tmpB){
                    //System.out.println("m="+i+" poA.p="+poA.p+" poB.p="+poB.p);
                 	if(poA.p == poB.p && poA.x==poB.x && poA.y==poB.y && poA.c==poB.c){
                     	max=Math.max(max, poA.p/2 + poB.p/2);   
                    }else {
                    	max=Math.max(max, poA.p+poB.p);   
                    }
                }
             }
             
             //각각 1개만 있는 경우 
             for(Point po : tmpA) max=Math.max(max, po.p);
              for(Point po : tmpB) max=Math.max(max, po.p);
             answer+=max;
            // System.out.println("m="+i+" max="+max+" answer="+answer);
        }
        
        return answer;
    }
    
    //범위 확인
    public static List<Point> range(int x, int y){
     	List<Point> avaliable = new ArrayList<>();
        for(Point po : list){
			int dis =Math.abs(po.x-x) + Math.abs(po.y - y);
            if(dis <= po.c) avaliable.add(po);
        }
        return avaliable;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			m=sc.nextInt();
            a=sc.nextInt();
            
            userA=new int[m];
            userB=new int[m];
            for(int i=0; i<m; i++) userA[i]=sc.nextInt();
            for(int i=0; i<m; i++) userB[i]=sc.nextInt();
			
            list=new ArrayList<>();
            for(int i=0; i<a; i++){
            	list.add(new Point(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            arr=new int[11][11];
			System.out.println("#"+test_case+" "+solution());
		}
	}
}