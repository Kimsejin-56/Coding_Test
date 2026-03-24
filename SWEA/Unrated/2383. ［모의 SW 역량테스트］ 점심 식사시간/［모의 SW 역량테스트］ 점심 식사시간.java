import java.util.*;
import java.io.FileInputStream;

class Point{
 	int x;
    int y;
    int cnt;
    
    public Point(int x, int y, int cnt){
     	this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}


class Solution
{
    static  List<Point> persons;
    static List<Point> stairs;
    static int pcnt, answer;
    static int[] selected;
    
    public static void dfs(int d){
        if(d==pcnt){
         	answer=Math.min(answer, cal());
            return;
        }
        selected[d]=0;
        dfs(d+1);
        
        selected[d]=1;
        dfs(d+1);
    }
   
    //총 시간 계산
    public static int cal(){
        List<Integer> stair0=new ArrayList<>();
        List<Integer> stair1=new ArrayList<>();
        for(int i=0; i<pcnt; i++){
         	Point p=persons.get(i);
            Point s = stairs.get(selected[i]);
            int dis=Math.abs(p.x-s.x) + Math.abs(p.y-s.y);  
            if(selected[i] ==0) stair0.add(dis);
            else stair1.add(dis);
        }
        
        return Math.max(cal2(stair0, 0), cal2(stair1, 1));
    }
    
    //각 계단 시간 계산
    public static int cal2(List<Integer> s, int n){
        if(s.isEmpty()) return 0;
        
     	Collections.sort(s);
        int[] num=new int[s.size()];
        
        for(int i=0; i<s.size(); i++){
        	int ready=s.get(i)+1;
            
            if(i < 3){
                num[i]=stairs.get(n).cnt+ready;   
            } else{
             	num[i]=Math.max(ready, num[i-3])+stairs.get(n).cnt;   
            }
        }
        
        return num[s.size()-1];
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            int[][] arr=new int[n][n];
            
            answer=Integer.MAX_VALUE;
            persons = new ArrayList<>();
            stairs = new ArrayList<>();
            
            for(int i=0; i<n; i++){
             	for(int j=0; j<n; j++){
					arr[i][j]=sc.nextInt();
                    if(arr[i][j]==1) persons.add(new Point(i, j, 0));
					else if(arr[i][j]>=2) stairs.add(new Point(i, j, arr[i][j]));
                }
            }
            pcnt=persons.size();
            selected=new int[pcnt];
            dfs(0);
                                                
			System.out.println("#"+test_case+" "+answer);
		}
	}
}