import java.awt.*;
import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    private int eng;
    private int math;

    public Point(int eng, int math){
        this.eng = eng;
        this.math = math;
    }

    public int getEng(){
        return eng;
    }
    public int getMath(){
        return math;
    }

    @Override
    public int compareTo(Point o){
        return this.eng-o.eng;
    }

}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for(int i=0; i<=n; i++){
            arr[i] = i;
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int connection = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int parentA = find(a);
            int parentB = find(b);
            if(connection==0){
                union(parentA,parentB);
            }else if(connection==1){
                if(parentA==parentB) bw.write("YES\n");
                else if(parentA!=parentB) bw.write("NO\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    public static int find(int num){
        if(num==arr[num]) return num;
        else return arr[num] = find(arr[num]);
    }

    public static void union(int parentA,int parentB){
        arr[parentA] = parentB;
    }


}//Main