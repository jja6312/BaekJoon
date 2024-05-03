import java.io.*;
import java.util.*;

class Point{
    private int x;
    private int y;

    Point (int x, int  y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[][] map;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        //미리 집과 치킨집에 해당하는 좌표를 ArrayList에 넣어둠.
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==1){
                    person.add(new Point(i,j));
                }else if(map[i][j]==2){
                    chicken.add(new Point(i,j));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0,0);
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();


    }//main

    private static void dfs(int start, int cnt) {
        if(cnt==m){
            int res = 0;
            for(int i=0; i<person.size(); i++){
                int tmp = Integer.MAX_VALUE;

                //어떤 집과 치킨 집 중 open한 치킨집의 모든 거리를 비교하고, 최소거리를 구한다.
                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){
                        int distance = Math.abs(person.get(i).getX() - chicken.get(j).getX()) + Math.abs(person.get(i).getY() - chicken.get(j).getY());
                        tmp = Math.min(tmp, distance);
                    }
                }

                res +=tmp;
            }
            ans = Math.min(ans,res);
        }
        
        //백트래킹
        for(int i=start; i<chicken.size(); i++){
            open[i] = true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }

}//Main Class
