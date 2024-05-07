import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.io.*;
import java.util.*;

class Point {
    private int m;
    private int n;
    private int h;

    public Point(int m, int n, int h) {
        this.m = m;
        this.n = n;
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getH() {
        return h;
    }


}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int m;
    static int n;
    static int h;
    static int[][][] arr;
    static Queue<Point> queue;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];
        queue = new LinkedList<>();
        //1. 초기화
        for (int i = 0; i < h; i++) {
            for (int l = 0; l < n; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    arr[i][l][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][l][j] == 1) queue.offer(new Point(j,l,i));
                }
            }
        }

        //2. bfs로 level추적
        int level = bfs();
        bw.write(level+"");

        bw.flush();
        bw.close();
        br.close();

    }

    public static int bfs() {
        //queue의 포인트에서 현재 익은 토마토 주변으로 전파
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            int currentH = currentPoint.getH();
            int currentM = currentPoint.getM();
            int currentN = currentPoint.getN();

            int[] dh = {1,-1,0,0,0,0};
            int[] dn = {0,0,1,-1,0,0};
            int[] dm = {0,0,0,0,-1,1};

            for(int i=0; i<6; i++){
                int moveH =currentH+dh[i];
                int moveN = currentN+dn[i];
                int moveM = currentM+dm[i];
                boolean isInBoundary = checkBoundary(moveH, moveN, moveM);
                if(isInBoundary) {
                    arr[moveH][moveN][moveM] = arr[currentH][currentN][currentM]+1;//이전에 익은 토마토의 값 + 1
                    queue.offer(new Point(moveM,moveN,moveH));
                }
            }//for



        }//while

        int result = Integer.MIN_VALUE;
        for(int [][] x : arr){
            for(int []y: x){
                for(int z: y){
                    if(z==0){//하나라도 안익었으면
                        return -1;//-1 반환
                    }else{
                        result = Math.max(result,z); //최대값(걸린일자) 반환
                    }
                }
            }
        }

        return result-1;
    }

    public static boolean checkBoundary(int currentH, int currentN,int currentM){
        //범위 내라면 true
        if(currentH >=0 && currentH<h
            && currentN >=0 && currentN<n
            && currentM >=0 && currentM<m
        && arr[currentH][currentN][currentM]==0){

            return true;
        }

        return false;
    }


}//Main Class
